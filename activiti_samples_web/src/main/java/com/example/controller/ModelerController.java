package com.example.controller;

import com.example.config.ResponseData;
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
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
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
    ProcessEngine processEngine;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    RepositoryService repositoryService;
    /**
     * 新建一个空模型
     * @return
     * @throws UnsupportedEncodingException
     */
    @PostMapping
    public String newModel() throws UnsupportedEncodingException {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //初始化一个空模型
        Model model = repositoryService.newModel();

        //设置一些默认信息
        String name = "new-process";
        String description = "";
        int revision = 1;
        String key = "process";

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
        return id;
    }

    /**
     * 获取所有模型
     * @return
     */
    @GetMapping
    public ResponseData modelList(){
        List<Model> models = repositoryService.createModelQuery().list();
        return ResponseData.success(models);
    }

    /**
     * 删除模型
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
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
    @PostMapping("{id}/deployment")
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