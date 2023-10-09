package com.app.nexus.entity;

import java.sql.Date;
import java.util.List;

public class InsuranceAndClaim {
	
	private Long insuranceId;
	private String policyNumber;
	private String insuredName;
	private String insuranceType;
	private double premiumAmount;
	private String insuranceCompany;
	private Date policyDate;
	private List<Claim> claims;
	public Long getInsuranceId() {
		return insuranceId;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public double getPremiumAmount() {
		return premiumAmount;
	}
	public String getInsuranceCompany() {
		return insuranceCompany;
	}
	public Date getPolicyDate() {
		return policyDate;
	}
	public List<Claim> getClaims() {
		return claims;
	}
	public void setInsuranceId(Long insuranceId) {
		this.insuranceId = insuranceId;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}
	public void setPolicyDate(Date policyDate) {
		this.policyDate = policyDate;
	}
	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}
	
	// Getters and setters
}
