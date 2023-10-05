package com.app.nexus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.nexus.services.InsuranceServices;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {

	private InsuranceServices insuranceServices;
	
	@Autowired
	public InsuranceController(InsuranceServices theInsuranceServices) {
		insuranceServices=theInsuranceServices;
	}
	
	

}
