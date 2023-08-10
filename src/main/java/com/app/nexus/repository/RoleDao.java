package com.app.nexus.repository;

import com.app.nexus.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
