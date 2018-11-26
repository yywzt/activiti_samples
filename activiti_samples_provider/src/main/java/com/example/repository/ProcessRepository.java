package com.example.repository;

import com.example.model.ProcessModel;

import java.util.List;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/14 15:07
 * @desc
 */
public interface ProcessRepository extends BaseRepository<ProcessModel,Long>  {

    ProcessModel findByActiviModelId(String activitiModelId);
    ProcessModel findByModelCode(String modelCode);
}
