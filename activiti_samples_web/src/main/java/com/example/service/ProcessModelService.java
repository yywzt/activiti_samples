package com.example.service;

import com.example.model.ProcessModel;
import com.example.repository.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/16 11:23
 * @desc
 */
@Service
public class ProcessModelService extends BaseService<ProcessModel> {

    @Autowired
    private ProcessRepository processRepository;

    public ProcessRepository getProcessRepository() {
        return processRepository;
    }

    public boolean save(ProcessModel processModel){
        ProcessModel save = processRepository.save(processModel);
        if(save!=null) {
            return true;
        }
        return false;
    }

    public Page findAll(Integer pageSize,Integer pageNumber){
        ProcessModel processModel = new ProcessModel();
        processModel.setEnabledFlag(1L);
        Example example = Example.of(processModel);
        Pageable pageable = PageRequest.of(pageNumber-1,pageSize,new Sort(Sort.Direction.DESC,"creationDate"));
        return processRepository.findAll(example, pageable);
    }
}
