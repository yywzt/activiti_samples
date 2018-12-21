package com.example.service.ssm;

import com.example.model.ssm.UserInf;
import com.example.repository.ssm.UserInfRepository;
import com.example.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/28 11:09
 * @desc
 */

@Service
@CacheConfig(cacheNames = "user_inf")
public class UserInfService extends BaseService<UserInf,Long> {

    public UserInfService(@Autowired UserInfRepository userInfRepository) {
        super(userInfRepository);
    }

    public UserInfRepository getRepository(){
        return (UserInfRepository) baseRepository;
    }

    public UserInf findByUsername(String username){
        return getRepository().findByUsername(username);
    }

    @Cacheable
    public String getUserNameByUserId(Long userId){
        Optional<UserInf> userInf = getRepository().findById(userId);
        if(userInf.isPresent()){
            return userInf.get().getUsername();
        }else{
            return null;
        }
    }
}
