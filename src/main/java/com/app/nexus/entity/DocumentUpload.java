package com.app.nexus.entity;

import java.sql.Timestamp;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "documents ")
public class DocumentUpload {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
    private int id;
	
	@Column(name = "title")
    private String title;

	@Column(name = "content")
	private byte[] content;

	@Column(name = "file_type")
	private String fileType;

	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "uploaded_at")
	private Timestamp uploadedAt;

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public byte[] getContent() {
		return content;
	}

	public String getFileType() {
		return fileType;
	}

	public String getFileName() {
		return fileName;
	}

	public Timestamp getCreatedAt() {
		return uploadedAt;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.uploadedAt = createdAt;
	}

	public DocumentUpload() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DocumentUpload(int id, String title, byte[] content, String fileType, String fileName, Timestamp createdAt) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.fileType = fileType;
		this.fileName = fileName;
		this.uploadedAt = createdAt;
	}

	@Override
	public String toString() {
		return "DocumentUpload [id=" + id + ", title=" + title + ", content=" + Arrays.toString(content) + ", fileType="
				+ fileType + ", fileName=" + fileName + ", createdAt=" + uploadedAt + "]";
	}
}