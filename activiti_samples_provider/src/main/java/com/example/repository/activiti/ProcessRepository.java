package com.example.repository.activiti;

import com.example.model.activiti.ProcessModel;
import com.example.repository.BaseRepository;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/14 15:07
 * @desc
 */
public interface ProcessRepository extends BaseRepository<ProcessModel,Long> {

    ProcessModel findByActiviModelId(String activitiModelId);
    ProcessModel findByModelCode(String modelCode);
}
