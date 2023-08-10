package com.app.nexus.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.app.nexus.entity.User;
import com.app.nexus.user.WebUser;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	void save(WebUser webUser);

}
