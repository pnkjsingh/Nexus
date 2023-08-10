package com.app.nexus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/")
    public String showHome() {

        return "home";
    }
	
	@GetMapping("/home")
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/service")
	public String servicesProvided() {
		return "services";
	}
	
	@GetMapping("/about")
	public String aboutUs() {
		return "about-us";
	}
	
	@GetMapping("/contect")
	public String contactForm() {
		return "contect-me";
	}
	
	@GetMapping("/drQuestionnior")
	public String drQForm() {
		return "dr_questionnare";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        return "fancy-login";
    }
	
	@GetMapping("/upload")
    public String showDocUpload() {

        return "uploadDoc";
    }

    // add request mapping for /access-denied

    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";
    }
}