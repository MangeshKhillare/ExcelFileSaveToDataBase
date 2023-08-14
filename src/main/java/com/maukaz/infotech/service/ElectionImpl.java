package com.maukaz.infotech.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.maukaz.infotech.helper.Helper;
import com.maukaz.infotech.entites.ElectionApp;
import com.maukaz.infotech.repository.ElectionRepository;

@Service
public class ElectionImpl implements Election {

	 
	@Autowired
	private ElectionRepository repository;

	@Override
	public void save(MultipartFile file) {

		try {
			List<ElectionApp> electionAppData = Helper.convertExcelToListOfElectionApp(file.getInputStream());
			this.repository.saveAll(electionAppData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ElectionApp> getAllElectionAppData() {

		return this.repository.findAll();
	}

}
