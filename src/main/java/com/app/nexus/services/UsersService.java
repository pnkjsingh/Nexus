package com.app.nexus.services;

import java.util.List;

import com.app.nexus.entity.User;

public interface UsersService {
	
	List<User> findAll();
	
	List<User> findAllEnabledUser();

	List<User> findAllDisabledUser();

}