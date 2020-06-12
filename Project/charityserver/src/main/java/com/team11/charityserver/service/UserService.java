package com.team11.charityserver.service;

import com.team11.charityserver.mapper.UserMapper;
import com.team11.charityserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    UserMapper userMapper;

    @Override
    public User loadUserByUsername(String username) {
        User user = userMapper.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username does not exist!");
        }
        return user;
    }

    public User getUserByUserId(Integer userId) {
        return userMapper.getUserByUserId(userId);
    }

    public Integer addUser(User user) {
        return userMapper.insertSelective(user);
    }

    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }


    public boolean checkUserExists(String username) {
        return userMapper.checkUserExists(username);
    }
}
