package com.example.travalBuddy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.travalBuddy.model.BillDetails;

@RestController
public class PDFGeneratorController {
	
	@PostMapping(value = "/generate")
	public void createUser(BillDetails billDetails) {
		CreatePDF.createPDF(String.valueOf(Math.random()));
	} 
	
	@GetMapping(value = "/test")
	public String testing() {
		return "success";
	}

}
