package com.app.nexus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.nexus.entity.TreatingDrQuestionnaire;
import com.app.nexus.services.TreatingDrQuestionnaireServices;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/treatingDoctor")
public class TreatingDrQuestionnaireConroller {
	
	private TreatingDrQuestionnaireServices drQuestionnaireServices;

	@Autowired
	public TreatingDrQuestionnaireConroller(TreatingDrQuestionnaireServices thedrQuestionnaireServices) {
		drQuestionnaireServices = thedrQuestionnaireServices;
	}
	
	@GetMapping("/show")
	public String showFormForAdd(Model theModel) {
		
		//Create model attribute to bind form data
		TreatingDrQuestionnaire treatingDrQuestionnaire=new TreatingDrQuestionnaire();
		theModel.addAttribute("treatingdrquestionnaire",treatingDrQuestionnaire);
		return "treating_Dr_Questionnaire";
	}
	
	@PostMapping("/add")
	public String addContact(@ModelAttribute("treatingdrquestionnaire") @Valid TreatingDrQuestionnaire thetreatingDrQuestionnaire,BindingResult bindingResult) {
		
		 if (bindingResult.hasErrors()) {
				/*
				 * System.out.println(
				 * "===============================================================");
				 * System.out.println(
				 * "===============================================================");
				 * System.out.println(bindingResult); System.out.println(
				 * "===============================================================");
				 * System.out.println(
				 * "===============================================================");
				 * System.out.println(thetreatingDrQuestionnaire); System.out.println(
				 * "===============================================================");
				 * System.out.println(
				 * "===============================================================");
				 */
			 
			 return "treating_Dr_Questionnaire";
	        }
		thetreatingDrQuestionnaire.setId(0);
		//save the Questionnaire
		/*
		 * System.out.println(
		 * "===============================================================");
		 * System.out.println(
		 * "===============================================================");
		 * System.out.println(thetreatingDrQuestionnaire); System.out.println(
		 * "===============================================================");
		 * System.out.println(
		 * "===============================================================");
		 */
		// Save the Treating Doctor Questionnaire Form.
		drQuestionnaireServices.save(thetreatingDrQuestionnaire);
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/treatingDoctor/show";
	}
}