package com.coeding.springmvc.dto;

import org.springframework.web.multipart.MultipartFile;


public class FileDTO {
	
	private String name, pwd, title, content, fileName;
	private MultipartFile uploadfile;
	private long fileSize;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public MultipartFile getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}
	public void setFileSize(long size) {
		this.fileSize = size;
	}
	public long getFileSize() {
		return fileSize;
	}
}
