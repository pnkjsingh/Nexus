package com.app.nexus.services;

import java.util.List;

import com.app.nexus.entity.Insurance;

public interface InsuranceServices {
	
	List<Insurance> findAll();
	
	Insurance save(Insurance insurance);
	
	Insurance findById(String id);
	
	void deleteById(String id);	

}
