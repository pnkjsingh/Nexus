package com.app.nexus.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.nexus.entity.Claim;
import com.app.nexus.entity.FamilyDoctorQuestionnaire;
import com.app.nexus.entity.Insurance;
import com.app.nexus.entity.InsuranceAndClaim;
import com.app.nexus.entity.InsuredQuestionnaire;
import com.app.nexus.entity.TreatingDrQuestionnaire;
import com.app.nexus.entity.dto.InsuranceClaimDTO;
import com.app.nexus.services.ClaimServices;
import com.app.nexus.services.FamilyDoctorServices;
import com.app.nexus.services.InsuranceServices;
import com.app.nexus.services.InsuredQuestionnaireService;
import com.app.nexus.services.TreatingDrQuestionnaireServices;
import com.app.nexus.services.UserService;

@Controller
@RequestMapping("/insuranceclaim")
public class InsuranceClaimController {
	private InsuranceServices insuranceService;
	private ClaimServices claimService;
	private InsuredQuestionnaireService insuredQuestionnaireService;
	private FamilyDoctorServices familyDoctorServices;
	private TreatingDrQuestionnaireServices treatingDrQuestionnaireServices;

	@Autowired
	private UserService userService;
	
	@Autowired
	public InsuranceClaimController(InsuranceServices insuranceService, ClaimServices claimService, InsuredQuestionnaireService insuredQuestionnaireService,
			FamilyDoctorServices familyDoctorServices, TreatingDrQuestionnaireServices treatingDrQuestionnaireServices) {
		this.insuranceService = insuranceService;
		this.claimService = claimService;
		this.insuredQuestionnaireService=insuredQuestionnaireService;
		this.familyDoctorServices=familyDoctorServices;
		this.treatingDrQuestionnaireServices=treatingDrQuestionnaireServices;
	}

	@GetMapping("/show")
	public String showInsuranceClaim(Model theModel) {
		
		//Create model attribute to bind form data
		Insurance insurance=new Insurance();
		Claim claim=new Claim();
		List<String> userList = userService.findAllUserName();
		// Fetch data from other tables as needed
		theModel.addAttribute("users", userList);
		theModel.addAttribute("insurance",insurance);
		theModel.addAttribute("claim",claim);
		theModel.addAttribute("insuranceClaimDTO", new InsuranceClaimDTO());
		return "create-insurance-claim";
	}  
    
	@PostMapping("/add")
	public String addInsuranceClaim(@ModelAttribute("insuranceClaimDTO") InsuranceClaimDTO insuranceClaimDTO, BindingResult bindingResult, Model model) {
		try {
			if(insuranceClaimDTO.getPolicyNumber().equals("")||insuranceClaimDTO.getInsuredName().equals("")||
					insuranceClaimDTO.getInsuranceCompany().equals("")||insuranceClaimDTO.getClaimNumber().equals("")||
					insuranceClaimDTO.getClaimAmount()<=0||insuranceClaimDTO.getPremiumAmount()<0||insuranceClaimDTO.getClaimDate().before(insuranceClaimDTO.getPolicyDate()) ){

				throw new Exception("Check, some non-empty field is empty.!");
			}
			else {
				Claim existingClaim = claimService.findByClaimNumber(insuranceClaimDTO.getClaimNumber());
				if (existingClaim != null) {
					// Handle duplicate claim number, you can throw an exception or display an error message
					throw new Exception("Claim with this claim number is already attached to another insurance.");
				}else {
					// Create and populate Insurance and Claim entities from the DTO
					Insurance insurance = new Insurance();
					insurance.setPolicyNumber(insuranceClaimDTO.getPolicyNumber());
					insurance.setInsuranceType(insuranceClaimDTO.getInsuranceType());
					insurance.setInsuredName(insuranceClaimDTO.getInsuredName());
					insurance.setInsuranceCompany(insuranceClaimDTO.getInsuranceCompany());
					insurance.setPremiumAmount(insuranceClaimDTO.getPremiumAmount());
					insurance.setPolicyDate(insuranceClaimDTO.getPolicyDate());

					Claim claim = new Claim();
					claim.setClaimNumber(insuranceClaimDTO.getClaimNumber());
					claim.setClaimAmount(insuranceClaimDTO.getClaimAmount());
					claim.setClaimDate(insuranceClaimDTO.getClaimDate());
					claim.setAssignedTo(insuranceClaimDTO.getAssignedTo());
					claim.setInsurance(insurance);
				
					InsuredQuestionnaire insuredQuestionnaire=new InsuredQuestionnaire();
//					insuredQuestionnaire.setId(insuranceClaimDTO.getInsuredQuestionaireId());
					insuredQuestionnaire.setId(0);
					insuredQuestionnaire.setClaim(claim);
					
					FamilyDoctorQuestionnaire doctorQuestionnaire=new FamilyDoctorQuestionnaire();
					doctorQuestionnaire.setId(0);
					doctorQuestionnaire.setClaim(claim);
					
					TreatingDrQuestionnaire treatingDrQuestionnaire=new TreatingDrQuestionnaire();
					treatingDrQuestionnaire.setId(0);
					treatingDrQuestionnaire.setClaim(claim);

					// Save both Insurance and Claim entities to the database
					// (You'll need to inject your repository or service classes here)
					insuranceService.save(insurance);
					claimService.save(claim);
					insuredQuestionnaireService.save(insuredQuestionnaire);
					familyDoctorServices.save(doctorQuestionnaire);
					treatingDrQuestionnaireServices.save(treatingDrQuestionnaire);
					model.addAttribute("message","Insurance Claim added successfully!");
//						return "redirect:/insuranceclaim/show";
//						return "message";
					return "create-insurance-claim";
                }
			}
		}catch (Exception e) {

			model.addAttribute("message","Error : "+ e.getMessage());

			//Use below for redirect to page
			//				return "redirect:/insuranceclaim/show";
			
			//Use below for showing message in to new HTML page
			//				return "message";

			//Use below if you want to generate popup.
			return "create-insurance-claim";
		}
	}
		
	@GetMapping("/show/all")
    public String showInsuranceAndClaim(Model model) {
		List<Insurance> insurances = insuranceService.findAll();
		List<Claim> claims = claimService.findAll();
		
		// Merge insurance and claim data into a single list
		List<InsuranceAndClaim> combinedData = mergeInsuranceAndClaimData(insurances, claims);
		model.addAttribute("data", combinedData);
        
		return "insurance";
    }

	private List<InsuranceAndClaim> mergeInsuranceAndClaimData(List<Insurance> insurances, List<Claim> claims) {
		
		// Merge insurance and claim data based on your business logic
        // For example, by policy number or insurance ID
        List<InsuranceAndClaim> combinedData = new ArrayList<>();

        for (Insurance insurance : insurances) {
            InsuranceAndClaim insuranceAndClaim = new InsuranceAndClaim();
            insuranceAndClaim.setInsuranceId(insurance.getInsuranceId());
            insuranceAndClaim.setInsuredName(insurance.getInsuredName());
            insuranceAndClaim.setPolicyNumber(insurance.getPolicyNumber());
            insuranceAndClaim.setInsuranceType(insurance.getInsuranceType());
            insuranceAndClaim.setInsuranceCompany(insurance.getInsuranceCompany());
            insuranceAndClaim.setPremiumAmount(insurance.getPremiumAmount());
            insuranceAndClaim.setPolicyDate(insurance.getPolicyDate());

            // Find related claims for this insurance
            List<Claim> relatedClaims = claims.stream()
                .filter(claim -> claim.getInsurance().equals(insurance))
                .collect(Collectors.toList());

            insuranceAndClaim.setClaims(relatedClaims);

            combinedData.add(insuranceAndClaim);
        }

        return combinedData;
    }
}
