package com.example.mapper.activiti;

import com.example.model.activiti.ActProcdefInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActProcdefInfoMapper {
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
    int insert(ActProcdefInfo record);

    /**
     * @describe 动态字段,写入数据库记录
     * @param record
     * @return int
     */
    int insertSelective(ActProcdefInfo record);

    /**
     * @describe 根据指定主键获取一条数据库记录
     * @param ID_
     * @return ActProcdefInfo
     */
    ActProcdefInfo selectByPrimaryKey(String ID_);

    /**
     * @describe 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(ActProcdefInfo record);

    /**
     * @describe 根据主键来更新符合条件的数据库记录
     * @param record
     * @return int
     */
    int updateByPrimaryKey(ActProcdefInfo record);
}