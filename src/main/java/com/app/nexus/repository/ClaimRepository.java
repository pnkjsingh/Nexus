package com.app.nexus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.nexus.entity.Claim;

public interface ClaimRepository extends JpaRepository<Claim, String> {

}
