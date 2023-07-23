package com.app.nexus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.nexus.entity.FamilyDoctorQuestionnaire;
import com.app.nexus.services.FamilyDoctorServices;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/familyDoctor")
public class FamilyDoctorController {
	
	private FamilyDoctorServices familyDoctorServices;
	
	@Autowired
	public FamilyDoctorController(FamilyDoctorServices  theFamilyDoctorController) {
		familyDoctorServices=theFamilyDoctorController;
	}
	
	@GetMapping("/show")
	public String showFormForAdd(Model theModel) {
		
		//Create model attribute to bind form data
		FamilyDoctorQuestionnaire familyDoctorQuestionnaire=new FamilyDoctorQuestionnaire();
		theModel.addAttribute("familydrquestionnaire",familyDoctorQuestionnaire);
		return "dr_questionnaire";
	}
	
	@PostMapping("/add")
	public String addContact(@ModelAttribute("familydrquestionnare") @Valid FamilyDoctorQuestionnaire thefamilyDoctorQuestionnaiore,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "dr_questionnaire";
		}

		thefamilyDoctorQuestionnaiore.setId(0);
		//save the employee
		familyDoctorServices.save(thefamilyDoctorQuestionnaiore);
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/familyDoctor/show";
	}

	
}
