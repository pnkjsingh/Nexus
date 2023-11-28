package com.app.nexus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.nexus.entity.Claim;
import com.app.nexus.entity.FamilyDoctorQuestionnaire;
import com.app.nexus.entity.Insurance;
import com.app.nexus.services.ClaimServices;
import com.app.nexus.services.FamilyDoctorServices;
import com.app.nexus.services.InsuranceServices;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/familyDoctor")
public class FamilyDoctorController {

	private FamilyDoctorServices familyDoctorServices;
	@Autowired
	private InsuranceServices insuranceServices;
	
	@Autowired
	private ClaimServices claimServices;

	@Autowired
	public FamilyDoctorController(FamilyDoctorServices  theFamilyDoctorController) {
		familyDoctorServices=theFamilyDoctorController;
	}

//	@GetMapping("/show")
//	public String showFormForAdd(Model theModel) {
//
//		//Create model attribute to bind form data
//		FamilyDoctorQuestionnaire familyDoctorQuestionnaire=new FamilyDoctorQuestionnaire();
//		theModel.addAttribute("familydrquestionnaire",familyDoctorQuestionnaire);
//		return "dr_questionnaire";
//	}

	@PostMapping("/add")
	public String addContact(@ModelAttribute("familydrquestionnaire") @Valid FamilyDoctorQuestionnaire thefamilyDoctorQuestionnaiore, 
			/* @ModelAttribute("claim") @Valid Claim theclaim , */	 BindingResult bindingResult, Model model) {

		if(bindingResult.hasErrors()) {

			 model.addAttribute("message", "Questionnaire failed to save!");
			return "dr_questionnaire";
		}

//		thefamilyDoctorQuestionnaiore.setId(0);
		//save the employee
		familyDoctorServices.save(thefamilyDoctorQuestionnaiore);
		
		model.addAttribute("message", "Questionnaire saved successfully!");
//		model.addAttribute("claim", new Claim());
		//use a redirect to prevent duplicate submissions
		return "redirect:/insuranceclaim/show/all";
	}
	
	@GetMapping("/questionnaireForm/{id}")
	public String showUpdateForm(@PathVariable("id") String id, Model model) {

		// Retrieve InsuredQuestionnaire by ID
		Claim claim=claimServices.findByClaimNumber(id);
		Insurance insurance=insuranceServices.findById(claim.getInsurance().getInsuranceId());
		FamilyDoctorQuestionnaire familydrquestionnaire = familyDoctorServices.findById(claim.getFamilyDrQuestionnaire().getId());
		familydrquestionnaire.setClaim(claim);

		model.addAttribute("familydrquestionnaire", familydrquestionnaire);
		model.addAttribute("claim", claim);
		model.addAttribute("insurance", insurance);

        return "dr_questionnaire";
    }
}