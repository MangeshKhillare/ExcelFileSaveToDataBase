package com.maukaz.infotech;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExcelToDataBaseSaveProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExcelToDataBaseSaveProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("This is testing");
		
	}

}
