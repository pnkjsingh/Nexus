package com.app.nexus.services;

import java.util.List;

import com.app.nexus.entity.FamilyDoctorQuestionnior;

public interface FamilyDoctorServices {

	List<FamilyDoctorQuestionnior> findAll();
	
	FamilyDoctorQuestionnior save(FamilyDoctorQuestionnior doctorQuestionnior);
	
	FamilyDoctorQuestionnior findById(int id);
	
//	void deleteById(int id);	

}
