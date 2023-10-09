package com.app.nexus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.nexus.entity.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, String>{

}
