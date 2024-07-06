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
import com.app.nexus.entity.Insurance;
import com.app.nexus.entity.TreatingDrQuestionnaire;
import com.app.nexus.services.ClaimServices;
import com.app.nexus.services.InsuranceServices;
import com.app.nexus.services.TreatingDrQuestionnaireServices;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/treatingDoctor")
public class TreatingDrQuestionnaireConroller {
	
	private TreatingDrQuestionnaireServices drQuestionnaireServices;
	@Autowired
	private InsuranceServices insuranceServices;
	
	@Autowired
	private ClaimServices claimServices;

	@Autowired
	public TreatingDrQuestionnaireConroller(TreatingDrQuestionnaireServices thedrQuestionnaireServices) {
		drQuestionnaireServices = thedrQuestionnaireServices;
	}
	
//	@GetMapping("/show")
//	public String showFormForAdd(Model theModel) {
//		
//		//Create model attribute to bind form data
//		TreatingDrQuestionnaire treatingDrQuestionnaire=new TreatingDrQuestionnaire();
//		theModel.addAttribute("treatingdrquestionnaire",treatingDrQuestionnaire);
//		return "treating_Dr_Questionnaire";
//	}
	
	@PostMapping("/add")
	public String addContact(@ModelAttribute("treatingdrquestionnaire") @Valid TreatingDrQuestionnaire thetreatingDrQuestionnaire,
			BindingResult bindingResult, Model model) {
		
		 if (bindingResult.hasErrors()) {
			 			 
			model.addAttribute("message", "Questionnaire failed to save!"); 
			return "treating_Dr_Questionnaire";	
		}

		 //		thetreatingDrQuestionnaire.setId(0);
		drQuestionnaireServices.save(thetreatingDrQuestionnaire);

		model.addAttribute("message", "Questionnaire saved successfully!");
		//use a redirect to prevent duplicate submissions
		return "redirect:/insuranceclaim/show/all";
	}
	
	@GetMapping("/questionnaireForm/{id}")
	public String showUpdateForm(@PathVariable("id") String id, Model model) {
		// Retrieve InsuredQuestionnaire by ID
		Claim claim=claimServices.findByClaimNumber(id);
		Insurance insurance=insuranceServices.findById(claim.getInsurance().getInsuranceId());
		TreatingDrQuestionnaire treatingDrQuestionnaire = drQuestionnaireServices.findById(claim.getTreatingDrQuestionnaire().getId());
		treatingDrQuestionnaire.setClaim(claim);
		
		// Retrieve corresponding Claim by claimNumber
		//Claim claim = claimService.getClaimByClaimNumber(insuredQuestionnaire.getClaimNumber());
		// Add both entities to the model
		model.addAttribute("treatingdrquestionnaire", treatingDrQuestionnaire);
		model.addAttribute("claim", claim);
		model.addAttribute("insurance", insurance);

        return "treating_Dr_Questionnaire";
    }
}