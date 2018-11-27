package com.example.service;

import com.example.model.ProcessModel;
import com.example.repository.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/16 11:23
 * @desc
 */
@Service
public class ProcessModelService extends BaseService<ProcessModel,Long> {

    public ProcessModelService(@Autowired ProcessRepository processRepository) {
        super(processRepository);
    }

    public ProcessRepository getProcessRepository() {
        return (ProcessRepository) super.baseRepository;
    }

    /**
     * 保存流程模型
     * */
    /*public boolean save(ProcessModel processModel){
        this.setDefault(processModel,true);
        ProcessModel save = processRepository.save(processModel);
        if(save!=null) {
            return true;
        }
        return false;
    }*/

    /**
     * 流程模型列表
     * */
    public Page findAll(Integer pageSize,Integer pageNumber){
        ProcessModel processModel = new ProcessModel();
        Example example = Example.of(processModel);
        Pageable pageable = PageRequest.of(pageNumber-1,pageSize,new Sort(Sort.Direction.DESC,"creationDate"));
        return getProcessRepository().findAll(example, pageable);
    }

    public ProcessModel findByActivitiId(String activitiId){
        ProcessModel processModel = new ProcessModel();
        processModel.setActiviModelId(activitiId);
        processModel.setEnabledFlag(1L);
        Example example = Example.of(processModel);
        Optional<ProcessModel> one = getProcessRepository().findOne(example);
        return one.isPresent()?one.get():null;
    }
}
