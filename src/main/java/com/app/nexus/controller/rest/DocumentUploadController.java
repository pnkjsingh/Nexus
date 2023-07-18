package com.app.nexus.controller.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.nexus.entity.DocumentUpload;
import com.app.nexus.services.DocumentUploadService;

@RestController
@RequestMapping("/api/documents")
public class DocumentUploadController {
    @Autowired
    
    private DocumentUploadService documentUploadService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("Please select a file to upload.", HttpStatus.BAD_REQUEST);
        }

        try {
            // Save the file to the database
            DocumentUpload document = new DocumentUpload();
            document.setContent(file.getBytes());
            document.setTitle(file.getName());
//            document.setCreatedAt()
            
            documentUploadService.save(document);

            return new ResponseEntity<>("File uploaded successfully.", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload the file.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
