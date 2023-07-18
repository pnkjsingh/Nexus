package com.app.nexus.services;

import java.util.List;

import com.app.nexus.entity.FamilyDoctorQuestionnaire;

public interface FamilyDoctorServices {

	List<FamilyDoctorQuestionnaire> findAll();
	
	FamilyDoctorQuestionnaire save(FamilyDoctorQuestionnaire doctorQuestionnaire);
	
	FamilyDoctorQuestionnaire findById(int id);
	
//	void deleteById(int id);	

}
