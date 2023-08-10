//package com.app.nexus.services;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.app.nexus.entity.Document;
//import com.app.nexus.repository.DocumentUploadRepository;
//
//@Service
//public class DocumentUploadServiceImpl implements DocumentUploadService {
//	
//	private DocumentUploadRepository documentUploadRepository;
//	
//	@Autowired
//	public DocumentUploadServiceImpl(DocumentUploadRepository thedocumentUploadRepository) {
//		documentUploadRepository = thedocumentUploadRepository;
//	}
//
//	@Override
//	public List<Document> findAll() {
//		return documentUploadRepository.findAll();
//	}
//
//	@Override
//	public Document save(Document Document) {
//		return documentUploadRepository.save(Document);
//	}
//
//	@Override
//	public Document findById(int id) {
//		Optional<Document> result= documentUploadRepository.findById(id);
//		Document document=null;
//		if(result.isPresent()) {
//			document=result.get();
//		}
//		else {
//			//Not found document of given id
//			throw new RuntimeException("did not found document of given id:"+id);
//		}
//		return document;
//	}
//
//	@Override
//	public void deleteById(int id) {
//		documentUploadRepository.deleteById(id);
//	}
//}