package com.app.nexus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout() {
        // You can perform any additional logic here if needed
        return "redirect:/showMyLoginPage?logout"; // Redirect to the login page after logout
    }
}
