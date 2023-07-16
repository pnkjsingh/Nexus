package com.app.nexus.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="family_doctor's_questionnaire")
public class FamilyDoctorQuestionnior {
	
	@Id
	@Column(name="Id")
	int id;

	@Column(name="Claim_No")
	String claimNo;
	
	@Column(name="Name_of_Insured")
	String insuredPersonName;
	
	@Column(name="Name_of_Insured_Company")
	String insuredCompanyName;
	
	@Column(name="High_Blood_pressure")
	String highBloodPressure;
	@Column(name="HBP_Since")
	String hbpSince;
	@Column(name="HBP_Rx")
	String hbpRx;
	
	@Column(name="Diabetes Mellitus")
	String diabetesMellitus;
	
	@Column(name="DM_Since")
	String diabetesSince;
	
	@Column(name="DM_Rx")
	String diabetesRx;
	
	@Column(name="Any_Respiratory_illness")
	String respiratoryIllness;
	
	@Column(name="RI_Since")
	String riSince;
	
	@Column(name="Chronic Heart Disease/Thyroid illness")
	String heartDisease;
	
	@Column(name="Questionnaire_Date")
	String doctorName;
	
	@Column(name="Case")
	String caseType;

	public FamilyDoctorQuestionnior() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FamilyDoctorQuestionnior(int id, String claimNo, String insuredPersonName, String insuredCompanyName,
			String highBloodPressure, String hbpSince, String hbpRx, String diabetesMellitus, String diabetesSince,
			String diabetesRx, String respiratoryIllness, String riSince, String heartDisease, String doctorName,
			String caseType) {
		super();
		this.id=id;
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
		this.heartDisease = heartDisease;
		this.doctorName = doctorName;
		this.caseType = caseType;
	}

	public int getId() {
		return id;
	}

	public String getInsuredPersonName() {
		return insuredPersonName;
	}

	public String getInsuredCompanyName() {
		return insuredCompanyName;
	}

	public String getHighBloodPressure() {
		return highBloodPressure;
	}

	public String getHbpSince() {
		return hbpSince;
	}

	public String getHbpRx() {
		return hbpRx;
	}

	public String getDiabetesMellitus() {
		return diabetesMellitus;
	}

	public String getDiabetesSince() {
		return diabetesSince;
	}

	public String getDiabetesRx() {
		return diabetesRx;
	}

	public String getRespiratoryIllness() {
		return respiratoryIllness;
	}

	public String getRiSince() {
		return riSince;
	}

	public String getHeartDisease() {
		return heartDisease;
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

	public void setHighBloodPressure(String highBloodPressure) {
		this.highBloodPressure = highBloodPressure;
	}

	public void setHbpSince(String hbpSince) {
		this.hbpSince = hbpSince;
	}

	public void setHbpRx(String hbpRx) {
		this.hbpRx = hbpRx;
	}

	public void setDiabetesMellitus(String diabetesMellitus) {
		this.diabetesMellitus = diabetesMellitus;
	}

	public void setDiabetesSince(String diabetesSince) {
		this.diabetesSince = diabetesSince;
	}

	public void setDiabetesRx(String diabetesRx) {
		this.diabetesRx = diabetesRx;
	}

	public void setRespiratoryIllness(String respiratoryIllness) {
		this.respiratoryIllness = respiratoryIllness;
	}

	public void setRiSince(String riSince) {
		this.riSince = riSince;
	}

	public void setHeartDisease(String heartDisease) {
		this.heartDisease = heartDisease;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	@Override
	public String toString() {
		return "Family_Doctor_Questionnior [id=" + id + "claimNo=" + claimNo + ", insuredPersonName=" + insuredPersonName
				+ ", insuredCompanyName=" + insuredCompanyName + ", highBloodPressure=" + highBloodPressure
				+ ", hbpSince=" + hbpSince + ", hbpRx=" + hbpRx + ", diabetesMellitus=" + diabetesMellitus
				+ ", diabetesSince=" + diabetesSince + ", diabetesRx=" + diabetesRx + ", respiratoryIllness="
				+ respiratoryIllness + ", riSince=" + riSince + ", heartDisease=" + heartDisease + ", doctorName="
				+ doctorName + ", caseType=" + caseType + "]";
	}
	
}