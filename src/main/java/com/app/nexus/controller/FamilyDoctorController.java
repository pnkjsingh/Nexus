package com.app.nexus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.nexus.entity.FamilyDoctorQuestionnior;
import com.app.nexus.services.FamilyDoctorServices;

@Controller
@RequestMapping("/familyDoctorPage")
public class FamilyDoctorController {
	
	private FamilyDoctorServices familyDoctorServices;
	
	@Autowired
	public FamilyDoctorController(FamilyDoctorServices  theFamilyDoctorController) {
		familyDoctorServices=theFamilyDoctorController;
	}
	
	@PostMapping("/add")
	public String addContact(@ModelAttribute FamilyDoctorQuestionnior thefamilyDoctorQuestionnior) {
		//also just in case they pass an id in JSON ... set id to 0
		//this is to force a save of new item ... instead of update
		thefamilyDoctorQuestionnior.setId(0);
		FamilyDoctorQuestionnior newContact=familyDoctorServices.save(thefamilyDoctorQuestionnior);
		return "contact-me";
	
	}
	
}
