package com.example.repository.ssm;

import com.example.model.ssm.UserInf;
import com.example.repository.BaseRepository;

/**
 * @author yanzt
 * @date 2018/7/17 15:21
 * @description
 */
public interface UserInfRepository extends BaseRepository<UserInf,Long> {

    UserInf findByUsername(String username);
}
