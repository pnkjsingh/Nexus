//package com.app.nexus.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//import com.app.nexus.entity.DocumentUpload;
//import com.app.nexus.services.DocumentUploadService;
//
//@Controller
//public class DocumentUploadController {
//	
//	private DocumentUploadService documentUploadService;
//	
//	@Autowired
//	public DocumentUploadController(DocumentUploadService thedocumentUploadService) {
//		documentUploadService = thedocumentUploadService;
//	}
//	
//	// Method to create a new document
//    public void createDocument(DocumentUpload document) {
//    	documentUploadService.create(document);
//    }
//
//    // Method to retrieve a document by ID
//    public DocumentUpload getDocumentById(int id) {
//        return documentUploadService.getById(id);
//    }
//
//    // Method to retrieve all documents
//    public List<DocumentUpload> getAllDocuments() {
//        return documentUploadService.getAll();
//    }
//
//    // Method to update a document
//    public void updateDocument(DocumentUpload document) {
//    	documentUploadService.update(document);
//    }
//
//    // Method to delete a document
//    public void deleteDocument(int id) {
//    	documentUploadService.delete(id);
//    }
//
//	
//
//}
