package com.app.nexus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.nexus.entity.FamilyDoctorQuestionnaire;
import com.app.nexus.repository.FamilyDoctorRepository;

@Service
public class FamilyDoctorServicesImpl implements FamilyDoctorServices {
	
	private FamilyDoctorRepository familyDoctorRepository;
	
	@Autowired
	public FamilyDoctorServicesImpl(FamilyDoctorRepository theFamilyDoctorRepository) {
		familyDoctorRepository=theFamilyDoctorRepository;
	}
	@Override
	public List<FamilyDoctorQuestionnaire> findAll() {
		return familyDoctorRepository.findAll();
	}

	@Override
	public FamilyDoctorQuestionnaire save(FamilyDoctorQuestionnaire doctorQuestionnaiore) {
		return familyDoctorRepository.save(doctorQuestionnaiore);
	}

	@Override
	public FamilyDoctorQuestionnaire findById(int id) {
		// TODO Auto-generated method stub
		Optional<FamilyDoctorQuestionnaire> result=familyDoctorRepository.findById(id);
		FamilyDoctorQuestionnaire doctorQuestionnaiore=null;
		if(result.isPresent()) {
			doctorQuestionnaiore=result.get();
		}
		else {
			//Not found doctor Questionnaire detail of given doctor number
			throw new RuntimeException("did not found given doctor Questionnaire id"+id);
			
		}
		return doctorQuestionnaiore;
	}
}