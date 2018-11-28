package com.example.model.ssm;

import com.example.model.BaseModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author yanzt
 * @date 2018/7/17 13:03
 * @description
 */
@Data
@Entity
@Table(name = "user_roles")
public class UserRoles extends BaseModel<Long> implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;
}
