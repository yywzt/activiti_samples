package com.example.service.activiti;

import com.example.model.activiti.ProcessModel;
import com.example.repository.activiti.ProcessRepository;
import com.example.service.BaseService;
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

    public ProcessRepository getRepository() {
        return (ProcessRepository) super.baseRepository;
    }

    public ProcessModel findByActivitiId(String activitiId){
        ProcessModel processModel = new ProcessModel();
        processModel.setActiviModelId(activitiId);
        processModel.setEnabledFlag(1L);
        Example example = Example.of(processModel);
        Optional<ProcessModel> one = getRepository().findOne(example);
        return one.isPresent()?one.get():null;
    }
}
