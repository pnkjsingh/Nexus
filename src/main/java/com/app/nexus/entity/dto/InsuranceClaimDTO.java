package com.app.nexus.entity.dto;

import java.sql.Date;

public class InsuranceClaimDTO {
	
	private String policyNumber;
	
	private String insuranceType;
	
	private String insuredName;
	
	private String insuranceCompany;
	
	private double premiumAmount;
	
	private double claimAmount;
	
	private Date claimDate;
	
	public String getPolicyNumber() {
		return policyNumber;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public String getInsuranceCompany() {
		return insuranceCompany;
	}
	public double getPremiumAmount() {
		return premiumAmount;
	}
	public double getClaimAmount() {
		return claimAmount;
	}
	public Date getClaimDate() {
		return claimDate;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}
	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}
	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}
}
