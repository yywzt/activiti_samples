package com.example.controller;

import com.example.config.ResponseData;
import com.example.request.LeaveRequest;
import com.example.model.activiti.ProcessLeave;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author yanzt
 * @date 2018/11/28 22:25
 * @describe
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public ResponseData newProcessLeave(@RequestBody @Validated ProcessLeave processLeave){
        processLeave.setLeaveDate(new Date());
        processLeave.setState("0");
        return ResponseData.success();
    }

    @RequestMapping(value = "/new2",method = RequestMethod.POST)
    public ResponseData newProcessLeave2(@RequestBody @Validated LeaveRequest leaveRequest){
        return ResponseData.success();
    }

    @RequestMapping(value = "/new3",method = RequestMethod.POST)
    public ResponseData newProcessLeave3(@RequestBody @Validated List<ProcessLeave> processLeaves){
        return ResponseData.success();
    }
}
