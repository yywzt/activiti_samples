package com.example.repository.ssm;

import com.example.model.ssm.Roles;
import com.example.repository.BaseRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author yanzt
 * @date 2018/7/17 13:05
 * @description
 */
@Transactional(readOnly = true)
public interface RolesRepository extends BaseRepository<Roles,Long> {

    Optional<Roles> findByRoleCode(String roleCode);

}
