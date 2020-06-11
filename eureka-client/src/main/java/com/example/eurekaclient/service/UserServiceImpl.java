package com.example.eurekaclient.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.weitao.entity.User;
import com.example.eurekaclient.mapper.UserMapper;
import com.weitao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 分库，具体参考 https://github.com/baomidou/dynamic-datasource-spring-boot-starter
 */
@Component
public class UserServiceImpl implements UserService
{

    @Autowired
    UserMapper userMapper ;

    @DS("slave_1") @Override public User Sel(int id){
        return userMapper.Sel(id);
    }

    @DS("slave_1") @Override public void Save(User user)
    {
        userMapper.Save(user);
    }

    @DS("master") @Override public List<User> SelectAll()
    {
        return userMapper.SelectAll();
    }

}
