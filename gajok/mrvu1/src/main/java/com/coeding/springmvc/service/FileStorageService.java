package com.coeding.springmvc.service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import com.coeding.springmvc.exception.FileStorageException;

@Service
public class FileStorageService {
	
    public Resource loadFileAsResource(String fileName) {
        try {
        	String dirFolder = "D:/images/";
			Path pathFile = Paths.get(dirFolder, fileName);
            Resource resource = new UrlResource(pathFile.toUri());
            if(resource.exists()) {
            	System.out.println("resource===>>"+resource.toString());
                return resource;
            } else {
                throw new FileStorageException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new FileStorageException("File not found " + fileName, ex);
        }
    }

}
