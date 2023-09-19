package com.app.nexus.services;


import java.util.List;

import com.app.nexus.entity.Claim;

public interface ClaimServices {

	List<Claim> findAll();
	
	Claim  save(Claim claim);
	
	Claim findById(Long id);
	
	void deleteById(Long id);
	
}
