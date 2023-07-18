package com.app.nexus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.nexus.entity.DocumentUpload;
import com.app.nexus.repository.DocumentUploadRepository;

@Service
public class DocumentUploadServiceImpl implements DocumentUploadService {
	
	private DocumentUploadRepository documentUploadRepository;
	
	@Autowired
	public DocumentUploadServiceImpl(DocumentUploadRepository thedocumentUploadRepository) {
		documentUploadRepository = thedocumentUploadRepository;
	}

	@Override
	public List<DocumentUpload> findAll() {
		return documentUploadRepository.findAll();
	}

	@Override
	public DocumentUpload save(DocumentUpload documentUpload) {
		return documentUploadRepository.save(documentUpload);
	}

	@Override
	public DocumentUpload findById(int id) {
		Optional<DocumentUpload> result= documentUploadRepository.findById(id);
		DocumentUpload document=null;
		if(result.isPresent()) {
			document=result.get();
		}
		else {
			//Not found document of given id
			throw new RuntimeException("did not found document of given id:"+id);
		}
		return document;
	}

	@Override
	public void deleteById(int id) {
		documentUploadRepository.deleteById(id);
	}
}