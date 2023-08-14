package com.maukaz.infotech.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import com.maukaz.infotech.entites.ElectionApp;
import com.maukaz.infotech.helper.Helper;
import com.maukaz.infotech.service.Election;

@RestController
@CrossOrigin("*")
public class ElectionController {

	@Autowired
	private Election electionI;
	
	 @PostMapping("/election/upload")
	    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
	        if (Helper.checkExcelFormat(file)) {
	            //true

	            this.electionI.save(file);

	            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));


	        }
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
	    }


	    @GetMapping("/allElctionData")
	    public List<ElectionApp> getAllElectionData() {
	       
	    	return this.electionI.getAllElectionAppData();
	    }
}
