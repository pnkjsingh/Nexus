package com.app.nexus.controller;

import java.util.List;
import java.util.logging.Logger;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.nexus.entity.User;
import com.app.nexus.services.EmailService;
import com.app.nexus.services.UserService;
import com.app.nexus.services.UsersService;
import com.app.nexus.user.WebUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	private Logger logger = Logger.getLogger(getClass().getName());

    private UserService userService;
    private UsersService usersService;
    private EmailService emailService;

	@Autowired
	public RegistrationController(UserService userService, UsersService usersService, EmailService emailService) {
		this.userService = userService;
		this.usersService=usersService;
		this.emailService=emailService;
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	
	@GetMapping("/showRegistrationForm")
	public String showMyLoginPage(Model theModel) {
		
		theModel.addAttribute("webUser", new WebUser());
		
		return "register/registration-form";
	}

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(
			@Valid @ModelAttribute("webUser") WebUser theWebUser,
			BindingResult theBindingResult,
			HttpSession session, Model theModel) {

		String userName = theWebUser.getUserName();
		logger.info("Processing registration form for: " + userName);
		
		// form validation
		 if (theBindingResult.hasErrors()){
			 return "register/registration-form";
		 }

		// check the database if user already exists
        User existing = userService.findByUserName(userName);
        if (existing != null){
        	theModel.addAttribute("webUser", new WebUser());
			theModel.addAttribute("registrationError", "User name already exists.");

			logger.warning("User name already exists.");
        	return "register/registration-form";
        }
        
        // create user account and store in the database
        userService.save(theWebUser);
        
     // Send registration confirmation email
        sendRegistrationConfirmationEmail(theWebUser);
        
        logger.info("Successfully created user: " + userName);
		// place user in the web http session for later use
		session.setAttribute("user", theWebUser);

        return "register/registration-confirmation";
	}

	private void sendRegistrationConfirmationEmail(@Valid WebUser theWebUser) {
		String to = theWebUser.getEmail();
		String subject = "Registration Confirmation";
		String body = "Thank you for registering!";
		
		emailService.sendEmail(to, subject, body);
	}

	@GetMapping("/show/all")
	public String showInsuranceAndClaim(Model model) {
		List<User> users = usersService.findAll();
		model.addAttribute("users", users);
		logger.info("Showing all users");
		return "user";
    }

	@GetMapping("/enabled")
    public String getAllEnabledUsers(Model model) {
		List<User> users = usersService.findAllEnabledUser();
		model.addAttribute("users", users);
		logger.info("Showing all enabled users");
		return "user";
}

    @GetMapping("/disabled")
    public String getAllDisabledUsers(Model model) {
        List<User> users = usersService.findAllDisabledUser();
        model.addAttribute("users", users);
		logger.info("Showing all disabled users");
        return "user";
    }
}