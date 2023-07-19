package com.app.nexus.services;

import java.util.List;

import com.app.nexus.entity.InsuredQuestionnaire;

public interface InsuredQuestionnaireService {
	
	List<InsuredQuestionnaire> findAll();
	
	InsuredQuestionnaire save(InsuredQuestionnaire insuredQuestionnaire);
	
	InsuredQuestionnaire findById(int id);
	
	void deleteById(int id);
}
