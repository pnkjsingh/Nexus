package com.app.nexus.entity.dto;

import java.sql.Date;

public class InsuranceClaimDTO {
	
	private String policyNumber;
	
	private String claimNumber;
	
	private String insuranceType;
	
	private String insuredName;
	
	private String insuranceCompany;
	
	private double premiumAmount;
	
	private double claimAmount;
	
	private Date claimDate;

	private Date policyDate;

	public String getPolicyNumber() {
		return policyNumber;
	}
	public String getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
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
	public Date getPolicyDate() {
		return policyDate;
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
	public void setPolicyDate(Date policyDate) {
		this.policyDate = policyDate;
	}
}
