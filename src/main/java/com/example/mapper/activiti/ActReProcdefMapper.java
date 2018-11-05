package com.example.mapper.activiti;

import com.example.model.activiti.ActReProcdef;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActReProcdefMapper {
    /**
     * @describe 根据主键删除数据库的记录
     * @param ID_
     * @return int
     */
    int deleteByPrimaryKey(String ID_);

    /**
     * @describe 新写入数据库记录
     * @param record
     * @return int
     */
    int insert(ActReProcdef record);

    /**
     * @describe 动态字段,写入数据库记录
     * @param record
     * @return int
     */
    int insertSelective(ActReProcdef record);

    /**
     * @describe 根据指定主键获取一条数据库记录
     * @param ID_
     * @return ActReProcdef
     */
    ActReProcdef selectByPrimaryKey(String ID_);

    /**
     * @describe 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(ActReProcdef record);

    /**
     * @describe 根据主键来更新符合条件的数据库记录
     * @param record
     * @return int
     */
    int updateByPrimaryKey(ActReProcdef record);
}