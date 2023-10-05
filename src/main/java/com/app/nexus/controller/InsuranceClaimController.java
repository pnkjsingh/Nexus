package com.app.nexus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.nexus.entity.Claim;
import com.app.nexus.entity.Insurance;
import com.app.nexus.entity.dto.InsuranceClaimDTO;
import com.app.nexus.services.ClaimServices;
import com.app.nexus.services.InsuranceServices;

@Controller
@RequestMapping("/insuranceclaim")
public class InsuranceClaimController {
    
	private InsuranceServices insuranceService;
    private ClaimServices claimService;

    @Autowired
    public InsuranceClaimController(InsuranceServices insuranceService, ClaimServices claimService) {
        this.insuranceService = insuranceService;
        this.claimService = claimService;
    }
    
	@GetMapping("/show")
	public String showInsuranceClaim(Model theModel) {
		
		//Create model attribute to bind form data
		Insurance insurance=new Insurance();
		Claim claim=new Claim();
		theModel.addAttribute("insurance",insurance);
		theModel.addAttribute("claim",claim);
		theModel.addAttribute("insuranceClaimDTO", new InsuranceClaimDTO());
		return "create-insurance-claim";
	}  
    
		@PostMapping("/add")
		public String addInsuranceClaim(@ModelAttribute InsuranceClaimDTO insuranceClaimDTO,Model model) {
			try {
				// Create and populate Insurance and Claim entities from the DTO
				Insurance insurance = new Insurance();
				insurance.setPolicyNumber(insuranceClaimDTO.getPolicyNumber());
				insurance.setInsuranceType(insuranceClaimDTO.getInsuranceType());
				insurance.setInsuredName(insuranceClaimDTO.getInsuredName());
				insurance.setInsuranceCompany(insuranceClaimDTO.getInsuranceCompany());
				insurance.setPremiumAmount(insuranceClaimDTO.getPremiumAmount());
				
				Claim claim = new Claim();
				claim.setClaimAmount(insuranceClaimDTO.getClaimAmount());
				claim.setClaimDate(insuranceClaimDTO.getClaimDate());
				claim.setInsurance(insurance);
				
				// Save both Insurance and Claim entities to the database
				// (You'll need to inject your repository or service classes here)
				insuranceService.save(insurance);
				claimService.save(claim);
				model.addAttribute("message","Insurance Claim added successfully!");				
			}catch (Exception e) {
				model.addAttribute("message","Error adding Insurance-Claim");
			}
            
			return "/insuranceclaim/show";
		}

    
	/*
	 * @PostMapping("/add") public String
	 * addContact(@ModelAttribute("treatingdrquestionnaire") @Valid
	 * TreatingDrQuestionnaire thetreatingDrQuestionnaire, BindingResult
	 * bindingResult, Model model) {
	 * 
	 * if (bindingResult.hasErrors()) {
	 * 
	 * model.addAttribute("message", "Questionnaire fail to save!");
	 * 
	 * return "treating_Dr_Questionnaire"; } thetreatingDrQuestionnaire.setId(0);
	 * 
	 * drQuestionnaireServices.save(thetreatingDrQuestionnaire);
	 * 
	 * model.addAttribute("message", "Questionnaire saved successfully!"); //use a
	 * redirect to prevent duplicate submissions return
	 * "redirect:/treatingDoctor/show"; }
	 */
}
