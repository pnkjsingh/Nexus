package com.app.nexus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.nexus.entity.Insurance;
import com.app.nexus.repository.InsuranceRepository;

@Service
public class InsuranceServiceImpl implements InsuranceServices {
	
	private InsuranceRepository insuranceRepository;
	
	@Autowired
	public InsuranceServiceImpl(InsuranceRepository theInsuranceRepository) {
		insuranceRepository=theInsuranceRepository;
	}

	@Override
	public List<Insurance> findAll() {
		
		return insuranceRepository.findAll();
	}

	@Override
	public Insurance save(Insurance insurance) {
		// TODO Auto-generated method stub
		return insuranceRepository.save(insurance);
	}

	@Override
	public Insurance findById(Long id) {
		Optional<Insurance> result=insuranceRepository.findById(id);
		Insurance insurance=null;
		if(result.isPresent()) {
			insurance=result.get();
		}
		else {
			//Not found doctor Questionnaire detail of given doctor number
			throw new RuntimeException("did not found Insurance id"+id);
			
		}
		return insurance;
	}

	@Override
	public void deleteById(Long id) {
		Optional<Insurance> result=insuranceRepository.findById(id);
		Insurance insurance=null;
		if(result.isPresent()) {
			insuranceRepository.delete(insurance);
		}
		else {
			//Not found doctor Questionnaire detail of given doctor number
			throw new RuntimeException("did not found Insurance id"+id);
		}
	}
}