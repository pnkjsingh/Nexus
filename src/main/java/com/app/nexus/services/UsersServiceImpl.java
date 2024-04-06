package com.app.nexus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.nexus.entity.User;
import com.app.nexus.repository.UserRepository;

@Service
public class UsersServiceImpl implements UsersService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UsersServiceImpl(UserRepository theUserRepository) {
		userRepository=theUserRepository;
	}


	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public List<User> findAllEnabledUser() {
		// TODO Auto-generated method stub
		return userRepository.findByEnabled(true);
	}


	@Override
	public List<User> findAllDisabledUser() {
		// TODO Auto-generated method stub
		return userRepository.findByEnabled(false);
	}

}
