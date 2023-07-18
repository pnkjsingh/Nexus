package com.app.nexus.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="family_doctor")
public class FamilyDoctorQuestionnaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	int id;

	@Column(name="Claim_No")
	String claimNo;
	
	@Column(name="Name_of_Insured")
	String insuredPersonName;
	
	@Column(name="Name_of_Insured_Company")
	String insuredCompanyName;
	
	@Column(name="High_Blood_pressure")
	boolean highBloodPressure;
	@Column(name="HBP_Since")
	String hbpSince;
	@Column(name="HBP_Rx")
	String hbpRx;
	
	@Column(name="Diabetes Mellitus")
	boolean diabetesMellitus;
	@Column(name="DM_Since")
	String diabetesSince;
	@Column(name="DM_Rx")
	String diabetesRx;
	
	@Column(name="Any_Respiratory_illness")
	boolean respiratoryIllness;
	@Column(name="RI_Since")
	String riSince;
	@Column(name="Ri_Rx")
	String riRx;
	
	@Column(name="Chronic Heart Disease/Thyroid illness")
	String heartDisease;
	
	@Column(name="Questionnaire_Date")
	String queDate;
	
	@Column(name="Doctor_Name")
	String doctorName;
	
	@Column(name="case_type")
	String caseType;

	public FamilyDoctorQuestionnaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FamilyDoctorQuestionnaire(int id, String claimNo, String insuredPersonName, String insuredCompanyName,
			boolean highBloodPressure, String hbpSince, String hbpRx, boolean diabetesMellitus, String diabetesSince,
			String diabetesRx, boolean respiratoryIllness, String riSince, String riRx, String heartDisease,
			String queDate, String doctorName, String caseType) {
		super();
		this.id = id;
		this.claimNo = claimNo;
		this.insuredPersonName = insuredPersonName;
		this.insuredCompanyName = insuredCompanyName;
		this.highBloodPressure = highBloodPressure;
		this.hbpSince = hbpSince;
		this.hbpRx = hbpRx;
		this.diabetesMellitus = diabetesMellitus;
		this.diabetesSince = diabetesSince;
		this.diabetesRx = diabetesRx;
		this.respiratoryIllness = respiratoryIllness;
		this.riSince = riSince;
		this.riRx = riRx;
		this.heartDisease = heartDisease;
		this.queDate = queDate;
		this.doctorName = doctorName;
		this.caseType = caseType;
	}

	public int getId() {
		return id;
	}

	public String getClaimNo() {
		return claimNo;
	}

	public String getInsuredPersonName() {
		return insuredPersonName;
	}

	public String getInsuredCompanyName() {
		return insuredCompanyName;
	}

	public boolean isHighBloodPressure() {
		return highBloodPressure;
	}

	public String getHbpSince() {
		return hbpSince;
	}

	public String getHbpRx() {
		return hbpRx;
	}

	public boolean isDiabetesMellitus() {
		return diabetesMellitus;
	}

	public String getDiabetesSince() {
		return diabetesSince;
	}

	public String getDiabetesRx() {
		return diabetesRx;
	}

	public boolean isRespiratoryIllness() {
		return respiratoryIllness;
	}

	public String getRiSince() {
		return riSince;
	}

	public String getRiRx() {
		return riRx;
	}

	public String getHeartDisease() {
		return heartDisease;
	}

	public String getQueDate() {
		return queDate;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public String getCaseType() {
		return caseType;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public void setInsuredPersonName(String insuredPersonName) {
		this.insuredPersonName = insuredPersonName;
	}

	public void setInsuredCompanyName(String insuredCompanyName) {
		this.insuredCompanyName = insuredCompanyName;
	}

	public void setHighBloodPressure(boolean highBloodPressure) {
		this.highBloodPressure = highBloodPressure;
	}

	public void setHbpSince(String hbpSince) {
		this.hbpSince = hbpSince;
	}

	public void setHbpRx(String hbpRx) {
		this.hbpRx = hbpRx;
	}

	public void setDiabetesMellitus(boolean diabetesMellitus) {
		this.diabetesMellitus = diabetesMellitus;
	}

	public void setDiabetesSince(String diabetesSince) {
		this.diabetesSince = diabetesSince;
	}

	public void setDiabetesRx(String diabetesRx) {
		this.diabetesRx = diabetesRx;
	}

	public void setRespiratoryIllness(boolean respiratoryIllness) {
		this.respiratoryIllness = respiratoryIllness;
	}

	public void setRiSince(String riSince) {
		this.riSince = riSince;
	}

	public void setRiRx(String riRx) {
		this.riRx = riRx;
	}

	public void setHeartDisease(String heartDisease) {
		this.heartDisease = heartDisease;
	}

	public void setQueDate(String queDate) {
		this.queDate = queDate;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	@Override
	public String toString() {
		return "FamilyDoctorQuestionnior [id=" + id + ", claimNo=" + claimNo + ", insuredPersonName="
				+ insuredPersonName + ", insuredCompanyName=" + insuredCompanyName + ", highBloodPressure="
				+ highBloodPressure + ", hbpSince=" + hbpSince + ", hbpRx=" + hbpRx + ", diabetesMellitus="
				+ diabetesMellitus + ", diabetesSince=" + diabetesSince + ", diabetesRx=" + diabetesRx
				+ ", respiratoryIllness=" + respiratoryIllness + ", riSince=" + riSince + ", riRx=" + riRx
				+ ", heartDisease=" + heartDisease + ", queDate=" + queDate + ", doctorName=" + doctorName
				+ ", caseType=" + caseType + "]";
	}
}