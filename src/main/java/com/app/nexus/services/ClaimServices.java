package com.app.nexus.services;


import java.util.List;

import com.app.nexus.entity.Claim;

public interface ClaimServices {

	List<Claim> findAll();
	
	Claim  save(Claim claim);
	
	Claim findByClaimNumber(String claimNumber);
	
	void deleteById(String id);
	
}
