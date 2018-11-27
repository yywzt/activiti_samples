package com.example.service;

import com.example.model.Leave;
import com.example.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/26 17:09
 * @desc
 */
@Service
public class LeaveService extends BaseService<Leave,Long> {

    public LeaveService(@Autowired LeaveRepository leaveRepository) {
        super(leaveRepository);
    }

    public LeaveRepository getRepository(){
        return (LeaveRepository) super.baseRepository;
    }

}
