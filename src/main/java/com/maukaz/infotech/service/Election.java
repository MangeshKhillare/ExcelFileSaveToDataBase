package com.maukaz.infotech.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


import com.maukaz.infotech.entites.ElectionApp;

public interface Election {
	

	public void save(MultipartFile file);
	
	public List<ElectionApp> getAllElectionAppData();
}
