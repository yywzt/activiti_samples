package com.example.service;

import com.example.constant.Pagination;
import com.example.model.BaseModel;
import com.example.repository.BaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/16 11:24
 * @desc
 */
@Slf4j
@Transactional
public abstract class BaseService<T,PK> {

    protected BaseRepository<T,PK> baseRepository;

    public BaseService(BaseRepository<T, PK> baseRepository) {
        this.baseRepository = baseRepository;
    }

    /**
     * 插入数据
     *
     * 如果主键是基于DB的方式，数据插入成功后，主键值会自动填充到输入对象中
     *
     * @param data 数据
     * @return 返回操作记录
     */
    public T insert(T data) {
        T result = null;
        try {
            setDefault(data, true);
            result = baseRepository.save(data);
        } catch (Exception e) {

        }
        return result;
    }

    /**
     * 批量插入数据
     * @param datas 数据
     * @return 返回操作记录
     */
    public List<T> insertBatch(List<T> datas) {
        List<T> result = null;
        try {
            if (datas != null) {
                for (T data : datas) {
                    setDefault(data, true);
                }
            }
            result = baseRepository.saveAll(datas);
        } catch (Exception e) {
            log.error("数据批量新增失败", e);
        }

        return result;
    }

    /**
     * 更新数据
     * 主键为更新条件，其他为数据
     * @param datas 数据
     * @return 更新结果
     */
    public boolean update(T... datas) {
        if (datas != null) {
            try {
                for (T data : datas) {
                    setDefault(data, false);
                    baseRepository.save(data);
                }
            } catch (Exception e) {
                log.error("数据更新失败", e);
                return false;
            }
        }

        return true;
    }

    /**
     * 批量更新数据
     * @param datas 数据
     * @return 更新结果
     */
    public boolean updateBatch(List<T> datas) {
        try {
            if (datas != null) {
                for (T data : datas) {
                    setDefault(data, true);
                    baseRepository.save(data);
                }
            }

        } catch (Exception e) {
            log.error("数据批量更新失败", e);
            return false;
        }

        return true;
    }

    /**
     * 通过主键删除记录
     * @param id  主键
     * @return    删除结果
     */
    public boolean delete(PK id) {
        try {
            baseRepository.deleteById(id);
        } catch (Exception e) {
            log.error("数据批量更新失败", e);
            return false;
        }

        return true;
    }


    /**
     * 通过主键获取数据
     * @param id  主键
     * @return    一行数据
     */
    public Optional<T> get(PK id) {
        Optional<T> result = null;
        try {
            result = baseRepository.findById(id);
        } catch (Exception e) {
            log.error("数据获取失败");
            return null;
        }

        return result;
    }

    public Page<T> search(Example example,Pagination<T> pagination){
        Pageable pageable = PageRequest.of(pagination.getPageNumber(),pagination.getPageSize(),new Sort(Sort.Direction.DESC,"creationDate"));
        if(example==null){
            return baseRepository.findAll(pageable);
        }
        return baseRepository.findAll(example,pageable);
    }

    /**
     * 设置添加公用参数
     *
     * @param data
     */
    private void setDefault(T data, boolean isNew) {
        if (data instanceof BaseModel) {
            BaseModel model = (BaseModel) data;

            if (isNew) {
                if (model.getCreationDate() == null) {
                    model.setCreationDate(new Timestamp(System.currentTimeMillis()));
                }
                model.setCreatedBy("-1");
            }

            model.setUpdationDate(new Timestamp(System.currentTimeMillis()));

            model.setUpdatedBy("-1");

            if (model.getEnabledFlag() == null) {
                model.setEnabledFlag(1L);
            }
        }
    }

}
