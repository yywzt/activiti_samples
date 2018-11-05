package com.example.mapper.activiti;

import com.example.model.activiti.ActIdMembershipKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActIdMembershipMapper {
    /**
     * @describe 根据主键删除数据库的记录
     * @param key
     * @return int
     */
    int deleteByPrimaryKey(ActIdMembershipKey key);

    /**
     * @describe 新写入数据库记录
     * @param record
     * @return int
     */
    int insert(ActIdMembershipKey record);

    /**
     * @describe 动态字段,写入数据库记录
     * @param record
     * @return int
     */
    int insertSelective(ActIdMembershipKey record);
}