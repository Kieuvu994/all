package com.coeding.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.coeding.springmvc.dao.FileDAO;
import com.coeding.springmvc.dto.FileDTO;
@Deprecated
@Controller
public class FileController implements ApplicationContextAware{
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	private static final String UPLOAD_PATH = "D:/kits-testroom/images/";
	private WebApplicationContext context = null;

	@RequestMapping(value = "/file.do", method = RequestMethod.GET)
	public String fileForm() {
		return "fileform";
	}
	
	@RequestMapping(value = "/file.do", method = RequestMethod.POST)
	public String fileSubmit(FileDTO dto) {
//	public String fileSubmit(MultipartHttpServletRequest mptRequest){
//		MultipartFile uploadfile = mptRequest.getFile("file");
		logger.info("{}", dto);
		MultipartFile uploadfile = dto.getUploadfile();
		if (uploadfile != null) {
			String fileName = uploadfile.getOriginalFilename();
			dto.setFileName(fileName);
			try {
			// 1. FileOutputStream 사용
			// byte[] fileData = file.getBytes();
			// FileOutputStream output = new FileOutputStream(UPLOAD_PATH + fileName);
			// output.write(fileData);
			// 2. File 사용
				File file = new File(UPLOAD_PATH + fileName);
				uploadfile.transferTo(file);
			} catch (IOException e) {
				e.printStackTrace();
			} // try ‐ catch
		} // if
		// 데이터 베이스 처리를 현재 위치에서 처리
		return "redirect:/"; // 일단 제외하고 구현
	}

	@RequestMapping(value = "/file/list.do", method = RequestMethod.GET)
	public String fileList(Model model) {
//		ArrayList<FileDTO> list =  FileDAO.listFile();
//		model.addAttribute("list", list);
		return "fileList";
	}

	@RequestMapping(value = "/file/down.do", method = RequestMethod.GET)
	public String fileDown(@RequestParam("fileName") String fileName, Model model) {
		String fullPath = UPLOAD_PATH + fileName ;
		File downloadFile = new File(fullPath);
		model.addAttribute("downloadFile", downloadFile);
		return "download";
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context  = (WebApplicationContext) applicationContext;
	}
}

