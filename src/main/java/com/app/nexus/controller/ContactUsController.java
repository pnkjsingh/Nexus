package com.app.nexus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.nexus.entity.ContactUs;
import com.app.nexus.repository.ContactUsRepository;

@Controller
@RequestMapping("/contactUs")
public class ContactUsController {

	@Autowired
	private ContactUsRepository contactUsRepository;
	
	@GetMapping("/form")
    public String contactUs(Model model) {
		ContactUs contactUs=new ContactUs();
		model.addAttribute("contactUs",contactUs);
        return "contact";
    }

	@PostMapping("/add")
//	public ResponseEntity<String> addClient(@RequestBody("contact") ContactUs contactUs) {	}
	public String addClient(@ModelAttribute("contact") ContactUs contactUs, Model model) {
		try {
			contactUs.setId(0);
			//save the employee
			contactUsRepository.save(contactUs);
			model.addAttribute("message","Contact added successfully!");
//			return ResponseEntity.ok("Client added successfully!");
		} catch (Exception e) {
			model.addAttribute("message","Error adding Contact");
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding client");
		}
		return "Home";
	}
}
