package com.app.nexus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.nexus.entity.DocumentUpload;

public interface DocumentUploadRepository extends JpaRepository<DocumentUpload, Integer>{

}
