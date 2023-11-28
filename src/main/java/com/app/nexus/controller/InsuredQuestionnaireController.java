package com.app.nexus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.nexus.entity.Claim;
import com.app.nexus.entity.Insurance;
import com.app.nexus.entity.InsuredQuestionnaire;
import com.app.nexus.services.ClaimServices;
import com.app.nexus.services.InsuranceServices;
import com.app.nexus.services.InsuredQuestionnaireService;

@Controller
@RequestMapping("/insured")
public class InsuredQuestionnaireController {
	
	private InsuredQuestionnaireService insuredQuestionnaireService;
	
	@Autowired
	private InsuranceServices insuranceServices;
	
	@Autowired
	private ClaimServices claimServices;

	@Autowired
	public InsuredQuestionnaireController(InsuredQuestionnaireService theInsuredQuestionnaireService) {
		insuredQuestionnaireService = theInsuredQuestionnaireService;
	}

//	@GetMapping("/questionnaireForm")
//	public String showInsuredQuestionnaireForm(Model theModel) {
//		
//		//Create model attribute to bind form data
//		InsuredQuestionnaire insuredQuestionnaire=new InsuredQuestionnaire();
//		theModel.addAttribute("insuredQuestionnaire",insuredQuestionnaire);
//		return "insured_questionnaire";
//	}
	
	@PostMapping("/add")
	public String addInsuredQuestionnaire(@ModelAttribute("insuredQuestionnaire") InsuredQuestionnaire theInsuredQuestionnaire,Model model) {
		try {
			if(/*theInsuredQuestionnaire.getClaimNumber().equals("") || theInsuredQuestionnaire.getInsuredName().equals("") || 
					theInsuredQuestionnaire.getInsuranceCompany().equals("") ||*/ theInsuredQuestionnaire.getHospitalName().equals("")||
					theInsuredQuestionnaire.getQuestionnaireDate().equals("") || theInsuredQuestionnaire.getIdentityProof().equals("")
					) {
				throw new Exception();
			}
			else {
//				theInsuredQuestionnaire.setId(0);
				//save the employee
				insuredQuestionnaireService.save(theInsuredQuestionnaire);
				model.addAttribute("message","Insured Questionnaire added successfully!");
			}
		}
		 catch (Exception e) {
				model.addAttribute("message","Error in insuredQuestionnaire");
		}
		return "redirect:/insuranceclaim/show/all";
	}

	@GetMapping("/questionnaireForm/{id}")
	public String showUpdateForm(@PathVariable("id") String id, Model model) {
		// Retrieve InsuredQuestionnaire by ID
		Claim claim=claimServices.findByClaimNumber(id);
		Insurance insurance=insuranceServices.findById(claim.getInsurance().getInsuranceId());
		InsuredQuestionnaire insuredQuestionnaire = insuredQuestionnaireService.findById(claim.getInsuredQuestionnaire().getId());
		insuredQuestionnaire.setClaim(claim);
		
		// Retrieve corresponding Claim by claimNumber
		//Claim claim = claimService.getClaimByClaimNumber(insuredQuestionnaire.getClaimNumber());
		// Add both entities to the model
		model.addAttribute("insuredQuestionnaire", insuredQuestionnaire);
		model.addAttribute("claim", claim);
		model.addAttribute("insurance", insurance);

		return "insured_questionnaire";
	}
}