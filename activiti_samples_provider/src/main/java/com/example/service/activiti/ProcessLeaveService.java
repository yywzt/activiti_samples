package com.example.service.activiti;

import com.example.model.activiti.ProcessLeave;
import com.example.repository.activiti.ProcessLeaveRepository;
import com.example.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/26 17:09
 * @desc
 */
@Service
public class ProcessLeaveService extends BaseService<ProcessLeave,Long> {

    public ProcessLeaveService(@Autowired ProcessLeaveRepository processLeaveRepository) {
        super(processLeaveRepository);
    }

    public ProcessLeaveRepository getRepository(){
        return (ProcessLeaveRepository) super.baseRepository;
    }

}
