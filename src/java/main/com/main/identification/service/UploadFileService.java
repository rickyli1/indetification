package com.main.identification.service;

import java.io.InputStream;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;

@Service
public class UploadFileService {
	@Autowired
	private GridFsOperations gridFsTemplcate;  

	public String save(InputStream inputStream, String contentType, String filename) {  
	  
	DBObject metaData = new BasicDBObject();  
	metaData.put("meta1", filename);  
	metaData.put("meta2", contentType);  
	  
	GridFSFile file = gridFsTemplcate.store(inputStream, filename, metaData);  
	  
	return file.getId().toString(); 
	}  
	  
	public GridFSDBFile get(String id) {  
	  
	System.out.println("Finding by ID: " + id);  
	return gridFsTemplcate.findOne(new Query(Criteria.where("_id").is(new ObjectId(id))));  
	}  
	  
	public List<GridFSDBFile> listFiles() {  
	  
	return gridFsTemplcate.find(null);  
	}  
	  
	public GridFSDBFile getByFilename(String filename) {  
	return gridFsTemplcate.findOne(new Query(Criteria.where("filename").is(filename)));  
	}  
	
}
