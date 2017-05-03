package com.main.identification.model;

import org.springframework.web.multipart.MultipartFile;

public class UploadFileBaseModel extends  BaseModel{
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
		
}
