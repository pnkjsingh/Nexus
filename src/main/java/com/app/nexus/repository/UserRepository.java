package com.app.nexus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.nexus.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findByEnabled(boolean enabled);

}