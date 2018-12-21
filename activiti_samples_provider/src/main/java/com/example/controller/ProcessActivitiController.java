package com.example.controller;

import com.example.bo.ActivitiBo;
import com.example.config.ResponseData;
import com.example.constant.ProcessCode;
import com.example.service.common.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanzt
 * @date 2018/12/20 16:18
 * @describe
 */
@RestController
@RequestMapping("/processActiviti")
public class ProcessActivitiController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping(value = "/getActivitiListNotMe", method = RequestMethod.GET)
    public ResponseData getActivitiList(@RequestParam("processDefinitionId") String processDefinitionId, @RequestParam("currentNodeId") String activitiId) {
        if(StringUtils.isEmpty(activitiId) || StringUtils.isEmpty(processDefinitionId)){
            return ResponseData.failure(ProcessCode.PLATFORM_ARG_ERROR.format("参数错误!").getMessage());
        }
        List<ActivitiBo> activitiList = this.activityService.getActivitiListNotMe(processDefinitionId,activitiId);
        return ResponseData.success(activitiList);
    }
}
