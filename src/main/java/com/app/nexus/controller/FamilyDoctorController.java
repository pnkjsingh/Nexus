package com.app.nexus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@GetMapping("/showFormForContact")
	public String showFormForAdd(Model theModel) {
		
		//Create model attribute to bind form data
		FamilyDoctorQuestionnior familyDoctorQuestionnior=new FamilyDoctorQuestionnior();
		theModel.addAttribute("familydrquestionnare",familyDoctorQuestionnior);
		return "dr_questionnare";
	}
	
	@PostMapping("/add")
	public String addContact(@ModelAttribute("familydrquestionnare") FamilyDoctorQuestionnior thefamilyDoctorQuestionnior) {
		thefamilyDoctorQuestionnior.setId(0);
		//save the employee
		familyDoctorServices.save(thefamilyDoctorQuestionnior);
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/familyDoctorPage/showFormForContact";
	}

	
}
