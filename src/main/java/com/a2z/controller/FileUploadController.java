package com.a2z.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.a2z.dao.FileUploadDAO;
import com.a2z.model.UploadFile;

public class FileUploadController {
	@Autowired
	private FileUploadDAO fileUploadDao;

	@RequestMapping(value = "/doUploaddddd", method = RequestMethod.POST)
	public String handleFileUpload(HttpServletRequest request, @RequestParam CommonsMultipartFile[] fileUpload)
			throws Exception {

		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload) {

				System.out.println("Saving file: " + aFile.getOriginalFilename());

				UploadFile uploadFile = new UploadFile();
				uploadFile.setFileName(aFile.getOriginalFilename());
				uploadFile.setData(aFile.getBytes());
				fileUploadDao.save(uploadFile);
			}
		}

		return "Success";
	}
}
