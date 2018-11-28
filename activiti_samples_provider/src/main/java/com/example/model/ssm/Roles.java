package com.example.model.ssm;

import com.example.model.BaseModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author yanzt
 * @date 2018/7/17 12:57
 * @description
 */
@Data
@Entity
@Table(name = "roles")
public class Roles extends BaseModel<Long> implements Serializable {

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_code")
    private String roleCode;

}
