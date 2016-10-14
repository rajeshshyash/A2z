package com.a2z.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.a2z.model.UploadFile;


@Repository("fileUploadDAO")
@Transactional
public class FileUploadDAOImpl extends AbstractDao<Integer, UploadFile> implements FileUploadDAO {

	public void save(UploadFile uploadFile) {
		getSession().save(uploadFile);
	}
	

}
