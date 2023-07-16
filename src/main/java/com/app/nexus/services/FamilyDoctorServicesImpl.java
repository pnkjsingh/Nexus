package com.app.nexus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.nexus.entity.FamilyDoctorQuestionnior;
import com.app.nexus.repository.FamilyDoctorRepository;

@Service
public class FamilyDoctorServicesImpl implements FamilyDoctorServices {
	
	private FamilyDoctorRepository familyDoctorRepository;
	
	public FamilyDoctorServicesImpl(FamilyDoctorRepository theFamilyDoctorRepository) {
		familyDoctorRepository=theFamilyDoctorRepository;
	}
	@Override
	public List<FamilyDoctorQuestionnior> findAll() {
		return familyDoctorRepository.findAll();
	}

	@Override
	public FamilyDoctorQuestionnior save(FamilyDoctorQuestionnior doctorQuestionnior) {
		return familyDoctorRepository.save(doctorQuestionnior);
	}

	@Override
	public FamilyDoctorQuestionnior findById(int id) {
		// TODO Auto-generated method stub
		Optional<FamilyDoctorQuestionnior> result=familyDoctorRepository.findById(id);
		FamilyDoctorQuestionnior doctorQuestionnior=null;
		if(result.isPresent()) {
			doctorQuestionnior=result.get();
		}
		else {
			//Not found doctor Questionnior detail of given doctor number
			throw new RuntimeException("did not found given doctor Questionnior id"+id);
			
		}
		return doctorQuestionnior;
	}
}