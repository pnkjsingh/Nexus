package com.app.nexus.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.nexus.entity.Document;
import com.app.nexus.repository.DocumentUploadRepository;
//import com.app.nexus.services.DocumentUploadService;

@RestController
@RequestMapping("/api/documents")
public class DocumentUploadController {
	
	private final DocumentUploadRepository documentRepository;

    @Autowired
    public DocumentUploadController(DocumentUploadRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file) {
        try {
            Document document = new Document();
            document.setName(file.getOriginalFilename());
            document.setContent(file.getBytes());
            documentRepository.save(document);
            return ResponseEntity.ok("File uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }
    
//    @Autowired
//	private  documentUploadService;
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file) {
//        if (file.isEmpty()) {
//            return new ResponseEntity<>("Please select a file to upload.", HttpStatus.BAD_REQUEST);
//        }
//
//        try {
//            // Save the file to the database
//            Document document = new Document();
//            document.setFileName(file.getOriginalFilename());
//            document.setFileType(file.getContentType());
//            document.setData(file.getBytes());
//
//            documentUploadService.save(document);
////            System.out.println(documentUploadService);
//
//            return new ResponseEntity<>("File uploaded successfully.", HttpStatus.OK);
//        } catch (IOException e) {
//            return new ResponseEntity<>("Failed to upload the file.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}