package com.app.nexus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.nexus.entity.TreatingDrQuestionnaire;
import com.app.nexus.repository.TreatingDrQuestionnaireRepository;

@Service
public class TreatingDrQuestionnaireServiceImpl implements TreatingDrQuestionnaireServices{
	
	private TreatingDrQuestionnaireRepository drQuestionnaireRepository;
	
	@Autowired
	public TreatingDrQuestionnaireServiceImpl(TreatingDrQuestionnaireRepository thedrQuestionnaireRepository) {
		
		drQuestionnaireRepository = thedrQuestionnaireRepository;
	}

	@Override
	public List<TreatingDrQuestionnaire> findAll() {
		return null;
	}

	@Override
	public TreatingDrQuestionnaire save(TreatingDrQuestionnaire drQuestionnaire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreatingDrQuestionnaire findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

}
