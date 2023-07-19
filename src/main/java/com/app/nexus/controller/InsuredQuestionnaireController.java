package com.app.nexus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.nexus.entity.InsuredQuestionnaire;
import com.app.nexus.services.InsuredQuestionnaireService;

@Controller
@RequestMapping("/insured")
public class InsuredQuestionnaireController {
	
	private InsuredQuestionnaireService insuredQuestionnaireService;

	@Autowired
	public InsuredQuestionnaireController(InsuredQuestionnaireService theInsuredQuestionnaireService) {
		insuredQuestionnaireService = theInsuredQuestionnaireService;
	}

	@GetMapping("/questionnaireForm")
	public String insuredQuestionnaireAdd(Model theModel) {
		
		//Create model attribute to bind form data
		InsuredQuestionnaire insuredQuestionnaire=new InsuredQuestionnaire();
		theModel.addAttribute("insuredQuestionnaire",insuredQuestionnaire);
		return "insured_questionnaire";
	}
	
	@PostMapping("/add")
	public String addContact(@ModelAttribute("familydrquestionnare") InsuredQuestionnaire theInsuredQuestionnaire) {
		theInsuredQuestionnaire.setId(0);
		//save the employee
		insuredQuestionnaireService.save(theInsuredQuestionnaire);
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/insured/questionnaireForm";
	}
}