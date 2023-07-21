package com.app.nexus.services;

import java.util.List;

import com.app.nexus.entity.TreatingDrQuestionnaire;

public interface TreatingDrQuestionnaireServices {
	
	List<TreatingDrQuestionnaire> findAll();

	TreatingDrQuestionnaire save(TreatingDrQuestionnaire drQuestionnaire);
	
	TreatingDrQuestionnaire findById(int id);
	
	void deleteById(int id);
}
