package com.app.nexus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.nexus.entity.InsuredQuestionnaire;
import com.app.nexus.repository.InsuredQuestionnaireRepository;

@Service
public class InsuredQuestionnaireServiceImpl implements InsuredQuestionnaireService {
	
	private InsuredQuestionnaireRepository insuredQuestionnaireRepository;
	
	@Autowired
	public InsuredQuestionnaireServiceImpl(InsuredQuestionnaireRepository theInsuredQuestionnaireRepository) {
		insuredQuestionnaireRepository = theInsuredQuestionnaireRepository;
	}

	@Override
	public List<InsuredQuestionnaire> findAll() {
		return insuredQuestionnaireRepository.findAll();
	}

	@Override
	public InsuredQuestionnaire save(InsuredQuestionnaire insuredQuestionnaire) {
		return insuredQuestionnaireRepository.save(insuredQuestionnaire);
	}

	@Override
	public InsuredQuestionnaire findById(int id) {
		Optional<InsuredQuestionnaire> result=insuredQuestionnaireRepository.findById(id);
		InsuredQuestionnaire insuredQuestionnaire=null;
		if(result.isPresent()) {
			insuredQuestionnaire=result.get();
		}else {
			throw new RuntimeException("Did not found Insured id"+id);
		}
		return insuredQuestionnaire;
	}

	@Override
	public void deleteById(int id) {
		Optional<InsuredQuestionnaire> result=insuredQuestionnaireRepository.findById(id);
		if(result.isPresent()) {
			insuredQuestionnaireRepository.deleteById(id);
		}else {
			throw new RuntimeException("Did not found Insured id"+id);
		}
	}
}