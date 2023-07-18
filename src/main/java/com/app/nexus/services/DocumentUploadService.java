package com.app.nexus.services;

import java.util.List;

import com.app.nexus.entity.DocumentUpload;

public interface DocumentUploadService {
	
	List<DocumentUpload> findAll();
	
	DocumentUpload save(DocumentUpload documentUpload);
	
	DocumentUpload findById(int id);
	
	void deleteById(int id);
}
