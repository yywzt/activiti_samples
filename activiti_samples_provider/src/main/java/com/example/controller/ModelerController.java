package com.example.controller;

import com.example.config.ResponseData;
import com.example.constant.Pagination;
import com.example.constant.ProcessModelStates;
import com.example.model.ProcessModel;
import com.example.service.ProcessModelService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.FormService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.util.FileSystemUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/7 15:55
 * @desc
 */
@RestController
@RequestMapping("/models")
public class ModelerController {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private ProcessModelService processModelService;

    @Autowired
    private FormService formService;
    /**
     * 新建一个空模型
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/newModel",method = RequestMethod.POST)
    public ResponseData newModel(@RequestBody @Valid ProcessModel processModel, BindingResult bindingResult) throws UnsupportedEncodingException {
        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            StringBuffer stringBuffer = new StringBuffer();
            allErrors.forEach(objectError -> {
                stringBuffer.append(objectError.getDefaultMessage());
            });
            return ResponseData.failure(stringBuffer.toString());
        }
        ProcessModel processModels = processModelService.getProcessRepository().findByModelCode(processModel.getModelCode());
        if(processModels!=null){
            return ResponseData.failure("模型编码已经存在了的啊！");
        }
        //初始化一个空模型
        Model model = repositoryService.newModel();

        //设置一些默认信息
        String name = processModel.getModelName();
        String description = processModel.getModelDesc();
        int revision = 1;
        String key = processModel.getModelCode();

        ObjectNode modelNode = objectMapper.createObjectNode();
        modelNode.put(ModelDataJsonConstants.MODEL_NAME, name);
        modelNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
        modelNode.put(ModelDataJsonConstants.MODEL_REVISION, revision);

        model.setName(name);
        model.setKey(key);
        model.setMetaInfo(modelNode.toString());

        repositoryService.saveModel(model);
        String id = model.getId();

        //完善ModelEditorSource
        ObjectNode editorNode = objectMapper.createObjectNode();
        editorNode.put("id", "canvas");
        editorNode.put("resourceId", "canvas");
        ObjectNode stencilSetNode = objectMapper.createObjectNode();
        stencilSetNode.put("namespace",
                "http://b3mn.org/stencilset/bpmn2.0#");
        editorNode.put("stencilset", stencilSetNode);
        repositoryService.addModelEditorSource(id,editorNode.toString().getBytes("utf-8"));

        processModel.setModelVersion(model.getVersion().longValue());
        processModel.setActiviModelId(id);
        processModel.setModelStates(0);
        processModelService.insert(processModel);
        return ResponseData.success(processModel);
    }

    /**
     * 获取所有模型
     * @return
     */
    @RequestMapping(value = "/getModelLists",method = RequestMethod.GET)
    public ResponseData modelList(@RequestParam(value = "pageSize",required = false) Integer pageSize,@RequestParam(value = "pageNumber",required = false) Integer pageNumber){
        Pagination pagination = new Pagination(pageNumber,pageSize);
        Page models = processModelService.search(pagination);
        return ResponseData.success(models);
    }

    /**
     * 删除模型
     * @param id
     * @return
     */
    @RequestMapping(value = "/del/{id}",method = RequestMethod.DELETE)
    public ResponseData deleteModel(@PathVariable("id")Long id){
//        Model model = repositoryService.createModelQuery().modelId(id).singleResult();
//        Model model = repositoryService.getModel(id);
        ProcessModel processModel = new ProcessModel();
        processModel.setId(id);
        Example example = Example.of(processModel);
        Optional<ProcessModel> one = processModelService.getProcessRepository().findOne(example);
        if(!one.isPresent()){
            return ResponseData.failure("model不存在");
        }
        processModelService.getProcessRepository().deleteById(one.get().getId());
        repositoryService.deleteModel(one.get().getActiviModelId());
        return ResponseData.failure("删除模型成功");
    }

    /**
     * 发布模型为流程定义
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deployment/{id}",method = RequestMethod.POST)
    public ResponseData deploy(@PathVariable("id")String id) throws Exception {
        ProcessModel processModel = processModelService.findByActivitiId(id);
        //获取模型
        Model modelData = repositoryService.getModel(id);
        byte[] bytes = repositoryService.getModelEditorSource(modelData.getId());

        if (bytes == null) {
            return ResponseData.failure("模型数据为空，请先设计流程并成功保存，再进行发布。");
        }

        JsonNode modelNode = new ObjectMapper().readTree(bytes);

        BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
        if(model.getProcesses().size()==0){
            return ResponseData.failure("数据模型不符要求，请至少设计一条主线流程。");
        }
        byte[] bpmnBytes = new byte[0];
        try {
            bpmnBytes = new BpmnXMLConverter().convertToXML(model);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.failure(e.getMessage());
        }

        //发布流程
        String processName = modelData.getName() + ".bpmn20.xml";
        Deployment deployment = repositoryService.createDeployment()
                .name(modelData.getName())
                .addString(processName, new String(bpmnBytes, "UTF-8"))
                .deploy();
        modelData.setDeploymentId(deployment.getId());
        repositoryService.saveModel(modelData);

        ProcessDefinition pd = repositoryService.
                createProcessDefinitionQuery().
                deploymentId(deployment.getId()).
                orderByProcessDefinitionVersion().
                desc().singleResult();
        if (pd != null) {
            processModel.setDeploymentId(pd.getDeploymentId());
            processModel.setModelDefinitionId(pd.getId());
            processModel.setModelDefinitionKey(pd.getKey());
            processModel.setModelVersion(Long.valueOf(pd.getVersion()));
            if (processModel.getModelStates() == ProcessModelStates.SAVE.getState()) {
                processModel.setModelStates(ProcessModelStates.ENBLED.getState());
            }
            this.processModelService.getProcessRepository().save(processModel);
        }
        return ResponseData.success();
    }

    /**
     * 查看流程图（流程定义文档的资源）
     * */
    @RequestMapping("/viewImage")
    public void viewImage(String deploymentId) throws IOException {
        List<String> names = repositoryService.getDeploymentResourceNames(deploymentId);
        String imageName = null;
        for(String s:names){
            System.out.println("name: " + s);
            if(s.indexOf(".png")>=0){
                imageName = s;
            }
        }
        System.out.println("imageName: " + imageName);
        if(imageName!=null){
            File file = new File("e:/" + imageName);
            InputStream in = repositoryService.getResourceAsStream(deploymentId, imageName);
            FileUtils.copyInputStreamToFile(in,file);
        }

    }
}