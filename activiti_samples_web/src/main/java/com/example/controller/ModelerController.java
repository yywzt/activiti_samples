package com.example.controller;

import com.example.config.ResponseData;
import com.example.model.ProcessModel;
import com.example.repository.ProcessRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/7 15:55
 * @desc
 */
@RestController
@RequestMapping("/models")
public class ModelerController {

    @Autowired
    private ProcessEngine processEngine;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private ProcessRepository processRepository;
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
        processModel.setActiviModelId(Long.valueOf(id));
        processRepository.save(processModel);
        return ResponseData.success(processModel);
    }

    /**
     * 获取所有模型
     * @return
     */
    @RequestMapping(value = "/getModelLists",method = RequestMethod.GET)
    public ResponseData modelList(@RequestParam(value = "pageSize",required = false) Integer pageSize,@RequestParam(value = "pageNumber",required = false) Integer pageNumber){
        if(pageSize==null) {
            pageSize = 20;
        }
        if(pageNumber==null) {
            pageNumber = 1;
        }
//        List<Model> models = repositoryService.createModelQuery().list();
        ProcessModel processModel = new ProcessModel();
        processModel.setEnabledFlag(1L);
        Example example = Example.of(processModel);
        Pageable pageable = PageRequest.of(pageNumber,pageSize,new Sort(Sort.Direction.DESC,"creationDate"));
        Page models = processRepository.findAll(example, pageable);
        return ResponseData.success(models.getContent());
    }

    /**
     * 删除模型
     * @param id
     * @return
     */
    @RequestMapping(value = "/del/{id}",method = RequestMethod.DELETE)
    public ResponseData deleteModel(@PathVariable("id")String id){
//        Model model = repositoryService.createModelQuery().modelId(id).singleResult();
        Model model = repositoryService.getModel(id);
        if(model==null){
            return ResponseData.failure("model不存在");
        }
        repositoryService.deleteModel(id);
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

        //获取模型
        Model modelData = repositoryService.getModel(id);
        byte[] bytes = repositoryService.getModelEditorSource(modelData.getId());

        if (bytes == null) {
            return ResponseData.failure("模型数据为空，请先设计流程并成功保存，再进行发布。");
        }

        JsonNode modelNode = new ObjectMapper().readTree(bytes);

        BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
        if(model.getProcesses().size()==0){
            ResponseData.failure("数据模型不符要求，请至少设计一条主线流程。");
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
        return ResponseData.success();
    }
}