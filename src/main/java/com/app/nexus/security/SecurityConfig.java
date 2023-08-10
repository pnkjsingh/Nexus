package com.app.nexus.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.app.nexus.services.UserService;

@Configuration
public class SecurityConfig {
	
	  //bcrypt bean definition
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //authenticationProvider bean definition
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService); //set the custom user details service
        auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
        return auth;
    }
	
	//Costume Login Form
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http,HandlerMappingIntrospector introspector) throws Exception {
		MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
		http.authorizeHttpRequests(configurer -> 
			configurer
//				.requestMatchers("/", "/home", "/services", "/about").permitAll()
				.requestMatchers(mvcMatcherBuilder.pattern("/familyDoctor/show")).hasRole("EMPLOYEE")
				.requestMatchers(mvcMatcherBuilder.pattern("")).hasRole("ADMIN")
				.requestMatchers(mvcMatcherBuilder.pattern("/**")).permitAll()
				.anyRequest().authenticated()
			)
			.formLogin(form ->
					form
						.loginPage("/showMyLoginPage")
						.loginProcessingUrl("/authenticateTheUser")
						.permitAll()
			).logout(logout->logout.permitAll())
			.exceptionHandling(configurer-> configurer.accessDeniedPage("/access-denied")
		);
		return http.build();
	}
	
	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	 * Exception { http.authorizeHttpRequests(configurer -> configurer
	 * .requestMatchers("/familyDoctor/show").hasRole("EMPLOYEE")
	 * .requestMatchers("/leaders/**").hasRole("MANAGER")
	 * .requestMatchers("/systems/**").hasRole("ADMIN")
	 * .requestMatchers("/register/**").permitAll() .anyRequest().authenticated() )
	 * .formLogin(form -> form .loginPage("/showMyLoginPage")
	 * .loginProcessingUrl("/authenticateTheUser") .permitAll() ) .logout(logout ->
	 * logout.permitAll() ) .exceptionHandling(configurer ->
	 * configurer.accessDeniedPage("/access-denied") );
	 * 
	 * return http.build(); }
	 */
}