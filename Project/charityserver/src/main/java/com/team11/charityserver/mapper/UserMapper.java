package com.team11.charityserver.mapper;

import com.team11.charityserver.model.User;

public interface UserMapper {
    int insertSelective(User user);

    int updateUser(User user);

    User loadUserByUsername(String username);

    User getUserByUserId(Integer userId);

    Boolean checkUserExists(String username);
}
