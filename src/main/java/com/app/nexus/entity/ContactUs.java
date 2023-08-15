package com.app.nexus.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContactUs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private long mobile; 
    private String email;
    private String messages;
    
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public long getMobile() {
		return mobile;
	}
	public String getEmail() {
		return email;
	}
	public String getMessages() {
		return messages;
	}
	public void setId(int i) {
		this.id = i;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	public ContactUs(int id, String firstName, String lastName, long mobile, String email, String messages) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.messages = messages;
	}
	public ContactUs() {
		super();
	}

	@Override
	public String toString() {
		return "ContactUs [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile
				+ ", email=" + email + ", messages=" + messages + "]";
	}
}