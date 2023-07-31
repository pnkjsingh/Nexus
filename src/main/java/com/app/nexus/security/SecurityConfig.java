package com.app.nexus.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
public class SecurityConfig {
	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails john= User.builder()
				.username("john")
				.password("{noop}test123")
				.roles("EMPLOYEE")
				.build();

		UserDetails mary= User.builder()
				.username("mary")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER")
				.build();

		UserDetails susan= User.builder()
				.username("susan")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN")
				.build();

		return new InMemoryUserDetailsManager(john, mary, susan);
	}
	
	
	//Costume Login Form
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http,HandlerMappingIntrospector introspector) throws Exception {
		MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
		http.authorizeHttpRequests(configurer -> 
			configurer
//				.requestMatchers("/", "/home", "/services", "/about").permitAll()
				.requestMatchers(mvcMatcherBuilder.pattern("/familyDoctor/show")).hasRole("USER")
				.requestMatchers(mvcMatcherBuilder.pattern("")).hasRole("ADMIN")
				.requestMatchers(mvcMatcherBuilder.pattern("/**")).permitAll()
				.anyRequest().authenticated()
			)
			.formLogin(form ->
					form
						.loginPage("/login")
						.loginProcessingUrl("/authenticateTheUser")
						.permitAll()
			).logout(logout->logout.permitAll())
			.exceptionHandling(configurer-> configurer.accessDeniedPage("/access-denied")
		);
		return http.build();
	}
}