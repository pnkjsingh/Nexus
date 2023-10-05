package com.app.nexus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.nexus.entity.Claim;
import com.app.nexus.repository.ClaimRepository;

@Service
public class ClaimServicesImpl implements ClaimServices {
	
	private ClaimRepository claimRepository;

	@Autowired
	public ClaimServicesImpl(ClaimRepository theClaimRepository) {
		claimRepository=theClaimRepository;
	}
	
	@Override
	public List<Claim> findAll() {
		
		return claimRepository.findAll();
	}

	@Override
	public Claim save(Claim claim) {
		// TODO Auto-generated method stub
		return claimRepository.save(claim);
	}

	@Override
	public Claim findById(Long id) {
		Optional<Claim> result=claimRepository.findById(id);
		Claim claim=null;
		if(result.isPresent()) {
			claim=result.get();
		}else {
			throw new RuntimeException("Did not found given Claim id: "+id);
		}
		return claim;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		Optional<Claim> result=claimRepository.findById(id);
		Claim claim=null;
		if(result.isPresent()) {
			claimRepository.delete(claim);
		}else {
			throw new RuntimeException("Did not found given Claim id: "+id);
		}
	}
}