package com.example.mapper.activiti;

import com.example.model.activiti.ActEvtLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActEvtLogMapper {
    /**
     * @describe 根据主键删除数据库的记录
     * @param LOG_NR_
     * @return int
     */
    int deleteByPrimaryKey(Long LOG_NR_);

    /**
     * @describe 新写入数据库记录
     * @param record
     * @return int
     */
    int insert(ActEvtLog record);

    /**
     * @describe 动态字段,写入数据库记录
     * @param record
     * @return int
     */
    int insertSelective(ActEvtLog record);

    /**
     * @describe 根据指定主键获取一条数据库记录
     * @param LOG_NR_
     * @return ActEvtLog
     */
    ActEvtLog selectByPrimaryKey(Long LOG_NR_);

    /**
     * @describe 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(ActEvtLog record);

    /**
     * @describe
     * @param record
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(ActEvtLog record);

    /**
     * @describe 根据主键来更新符合条件的数据库记录
     * @param record
     * @return int
     */
    int updateByPrimaryKey(ActEvtLog record);
}