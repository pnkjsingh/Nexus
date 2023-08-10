package com.app.nexus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.nexus.entity.Document;

public interface DocumentUploadRepository extends JpaRepository<Document, Long>{

}
