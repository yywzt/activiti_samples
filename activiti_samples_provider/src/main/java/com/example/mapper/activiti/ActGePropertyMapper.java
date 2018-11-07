package com.example.mapper.activiti;

import com.example.model.activiti.ActGeProperty;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActGePropertyMapper {
    /**
     * @describe 根据主键删除数据库的记录
     * @param NAME_
     * @return int
     */
    int deleteByPrimaryKey(String NAME_);

    /**
     * @describe 新写入数据库记录
     * @param record
     * @return int
     */
    int insert(ActGeProperty record);

    /**
     * @describe 动态字段,写入数据库记录
     * @param record
     * @return int
     */
    int insertSelective(ActGeProperty record);

    /**
     * @describe 根据指定主键获取一条数据库记录
     * @param NAME_
     * @return ActGeProperty
     */
    ActGeProperty selectByPrimaryKey(String NAME_);

    /**
     * @describe 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(ActGeProperty record);

    /**
     * @describe 根据主键来更新符合条件的数据库记录
     * @param record
     * @return int
     */
    int updateByPrimaryKey(ActGeProperty record);
}