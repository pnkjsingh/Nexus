package com.app.nexus.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="family_doctor")
public class FamilyDoctorQuestionnaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	int id;

//	@Column(name="Claim_No")
//	String claimNo;
    @OneToOne
    @JoinColumn(name = "claim", referencedColumnName = "claim_number")
    private Claim claim;
	
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
	
	@Column(name="chronic heart disease/thyroid illness")
	boolean heartDisease;
	@Column(name="chronic_heart_disease_since")
	String heartDiseaseSince;
	@Column(name="chronic_heart_disease_rx")
	String heartDiseaseRx;
	
	@Column(name="Questionnaire_Date")
	String queDate;
	
	@Column(name="Doctor_Name")
	String doctorName;
	
	public int getId() {
		return id;
	}

	public Claim getClaim() {
		return claim;
	}

	public boolean getHighBloodPressure() {
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

	public boolean isHeartDisease() {
		return heartDisease;
	}

	public String getHeartDiseaseSince() {
		return heartDiseaseSince;
	}

	public String getHeartDiseaseRx() {
		return heartDiseaseRx;
	}

	public String getQueDate() {
		return queDate;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
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

	public void setHeartDisease(boolean heartDisease) {
		this.heartDisease = heartDisease;
	}

	public void setHeartDiseaseSince(String heartDiseaseSince) {
		this.heartDiseaseSince = heartDiseaseSince;
	}

	public void setHeartDiseaseRx(String heartDiseaseRx) {
		this.heartDiseaseRx = heartDiseaseRx;
	}

	public void setQueDate(String queDate) {
		this.queDate = queDate;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public FamilyDoctorQuestionnaire(int id, Claim claim, 
			boolean highBloodPressure, String hbpSince, String hbpRx, boolean diabetesMellitus, String diabetesSince,
			String diabetesRx, boolean respiratoryIllness, String riSince, String riRx, boolean heartDisease,
			String heartDiseaseSince, String heartDiseaseRx, String queDate, String doctorName) {
		super();
		this.id = id;
		this.claim = claim;
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
		this.heartDiseaseSince = heartDiseaseSince;
		this.heartDiseaseRx = heartDiseaseRx;
		this.queDate = queDate;
		this.doctorName = doctorName;
	}

	public FamilyDoctorQuestionnaire() {
		super();
	}

	@Override
	public String toString() {
		return "FamilyDoctorQuestionnaire [id=" + id + ", claim=" + claim + ", highBloodPressure="
				+ highBloodPressure + ", hbpSince=" + hbpSince + ", hbpRx=" + hbpRx + ", diabetesMellitus="
				+ diabetesMellitus + ", diabetesSince=" + diabetesSince + ", diabetesRx=" + diabetesRx
				+ ", respiratoryIllness=" + respiratoryIllness + ", riSince=" + riSince + ", riRx=" + riRx
				+ ", heartDisease=" + heartDisease + ", heartDiseaseSince=" + heartDiseaseSince + ", heartDiseaseRx="
				+ heartDiseaseRx + ", queDate=" + queDate + ", doctorName=" + doctorName + "]";
	}
}