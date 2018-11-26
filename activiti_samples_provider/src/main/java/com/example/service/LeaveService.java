package com.example.service;

import com.example.model.Leave;
import com.example.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/26 17:09
 * @desc
 */
@Service
public class LeaveService extends BaseService<Leave> {

    @Autowired
    private LeaveRepository leaveRepository;

    public LeaveRepository getLeaveRepository() {
        return leaveRepository;
    }

    public Page findAll(Integer pageSize, Integer pageNumber){
        Leave leave = new Leave();
        Example example = Example.of(leave);
        Pageable pageable = PageRequest.of(pageNumber-1,pageSize,new Sort(Sort.Direction.DESC,"creationDate"));
        return leaveRepository.findAll(example, pageable);
    }

    public boolean update(Leave leave){
        getLeaveRepository().save(leave);
        return true;
    }
}
