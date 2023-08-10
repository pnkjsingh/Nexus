/*
 * package com.app.nexus.controller.rest;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.*;
 * 
 * import com.app.nexus.entity.User; import com.app.nexus.services.UserService;
 * 
 * @RestController public class UserController {
 * 
 * private UserService userService;
 * 
 * @Autowired public UserController(UserService userService) { this.userService
 * = userService; }
 * 
 * @PostMapping("/login") public ResponseEntity<?> login(@RequestBody User user)
 * { User dbUser = userService.getUserByUsername(user.getUsername());
 * 
 * if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) { //
 * Generate and return a token (You can use JWT or any other token mechanism)
 * String token = generateToken(dbUser); return ResponseEntity.ok(token); } else
 * { return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); } }
 * 
 * private String generateToken(User user) { // Generate and return a token here
 * return "your_generated_token_here"; } }
 */