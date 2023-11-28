package com.app.nexus.repository;

import java.util.List;

import com.app.nexus.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User theUser);
    
    List<String> findAllUsernames();

}
