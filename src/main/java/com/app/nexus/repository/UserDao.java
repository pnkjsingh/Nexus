package com.app.nexus.repository;

import com.app.nexus.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User theUser);
}
