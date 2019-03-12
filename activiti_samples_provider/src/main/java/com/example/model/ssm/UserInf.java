package com.example.model.ssm;

import com.example.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

/**
 * @author yanzt
 * @date 2018/7/17 11:46
 * @description
 */
@Data
@Entity
@Table(name = "user_inf")
public class UserInf extends BaseModel<Long> implements Serializable {

    @NotEmpty(message = "用户名不能为空")
    @Column(name = "uname")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Column(name = "passwd")
    private String password;

    @Column(name = "gentel")
    private String gentel;

    @Column(name = "email")
    private String email;

    @Column(name = "city")
    private String city;

    //1、关系维护端，负责多对多关系的绑定和解除
    //2、@JoinTable注解的name属性指定关联表的名字，joinColumns指定外键的名字，关联到关系维护端(User)
    //3、inverseJoinColumns指定外键的名字，要关联的关系被维护端(Authority)
    //4、其实可以不使用@JoinTable注解，默认生成的关联表名称为主表表名+下划线+从表表名，
    //即表名为user_authority
    //关联到主表的外键名：主表名+下划线+主表中的主键列名,即user_id
    //关联到从表的外键名：主表中用于关联的属性名+下划线+从表的主键列名,即authority_id
    //主表就是关系维护端对应的表，从表就是关系被维护端对应的表
    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> rolesSet;

    @Override
    public String toString() {
        return "UserInf{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gentel='" + gentel + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", id=" + id +
                ", createdBy='" + createdBy + '\'' +
                ", creationDate=" + creationDate +
                ", updatedBy='" + updatedBy + '\'' +
                ", updationDate=" + updationDate +
                ", enabledFlag=" + enabledFlag +
                '}';
    }
}
