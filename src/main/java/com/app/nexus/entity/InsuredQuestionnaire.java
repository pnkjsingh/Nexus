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
@Table(name = "insured_questionnaire")
public class InsuredQuestionnaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "hospital_name")
	private String hospitalName;
	
	@Column(name = "chief_complained_at_time_of_admission")
	private String chiefComplained;
	@Column(name = "exact_duration_of_complaints")
	private String complaintsDuration;
	
	@Column(name = "diagnosis_as_per_doctor")
	private String diagnosisAsPerDoctor;
	@Column(name = "tests_undergone_before/during_hospitalization")
	private String testsBeforeOrDuringHospitalization;
	
	@Column(name = "date_time_of_admission")
	private String admissionDateTime;
	@Column(name = "date_time_of_discharge")
	private String dischargeDateTime;
	
	@Column(name = "room_rent_per_day")
	private Float roomRentPerDay;
	@Column(name = "type_of_room")
	private String roomType;
	
	@Column(name = "identity_proof")
	private String identityProof;
	@Column(name = "estimated_hospital_bill")
	private Float estimatedHospitalBill;

	@Column(name = "high_blood_pressure")
	private Boolean highBloodPressure;
	@Column(name = "hbp_drug_name")
	private String hbpDrugName;
	@Column(name = "hbp_duration")
	private String hbpDuration;

	@Column(name = "diabetes_mellitus")
	private Boolean diabetesMellitus;
	@Column(name = "dm_drug_name")
	private String dmDrugName;
	@Column(name = "dm_duration")
	private String dmDuration;

	@Column(name = "any_heart_disease")
	private Boolean anyHeartDisease;
	@Column(name = "hd_drug_name")
	private String hdDrugName;
	@Column(name = "hd_duration")
	private String hdDuration;

	@Column(name = "any_liver_disease")
	private Boolean anyLiverDisease;
	@Column(name = "liver_disease_drug_name")
	private String liverDiseaseDrugName;
	@Column(name = "liver_disease_duration")
	private String liverDiseaseDuration;

	@Column(name = "any_kidney_disease")
	private Boolean kidneyDisease;
	@Column(name = "kidney_drug_name")
	private String kidneyDrugName;
	@Column(name = "kd_duration")
	private String kdDuration;

	@Column(name = "neurological_disease")
	private Boolean neurologicalDisease;
	@Column(name = "neurological_disease_drug_name")
	private String neurologicalDiseaseDrugName;
	@Column(name = "neurological_disease_duration")
	private String neurologicalDiseaseDuration;

	@Column(name = "cancer")
	private Boolean cancer;
	@Column(name = "cancer_drug_name")
	private String cancerDrugName;
	@Column(name = "cancer_duration")
	private String cancerDuration;

	@Column(name = "respiratory_illness")
	private Boolean respiratoryIllness;
	@Column(name = "respiratory_illness_drug_name")
	private String respiratoryIllnessDrugName;
	@Column(name = "respiratory_illness_duration")
	private String respiratoryIllnessDuration;

	@Column(name = "arthritis")
	private Boolean arthritis;
	@Column(name = "arthritis_drug_name")
	private String arthritisDrugName;
	@Column(name = "arthritis_duration")
	private String arthritisDuration;

	@Column(name = "any_major_disease")
	private Boolean anyMajorDisease;
	@Column(name = "disease_drug_name")
	private String diseaseDrugName;
	@Column(name = "disease_duration")
	private String diseaseDuration;

	@Column(name = "job_details")
	private String jobDetails;
	@Column(name = "alcohol_smoking_tobacco")
	private String alcoholSmokingTobacco;
	@Column(name = "description")
	private String description;

	@Column(name = "questionnaire_date")
	private String questionnaireDate;
	
	// Define the one-to-one relationship with Claim
    @OneToOne
    @JoinColumn(name = "claim", referencedColumnName = "claim_number")
    private Claim claim;

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	public int getId() {
		return id;
	}

//	public String getInsuredName() {
//		return insuredName;
//	}
//
//	public String getClaimNumber() {
//		return claimNumber;
//	}

	public String getHospitalName() {
		return hospitalName;
	}

//	public String getInsuranceCompany() {
//		return insuranceCompany;
//	}

	public String getChiefComplained() {
		return chiefComplained;
	}

	public String getComplaintsDuration() {
		return complaintsDuration;
	}

	public String getDiagnosisAsPerDoctor() {
		return diagnosisAsPerDoctor;
	}

	public String getTestsBeforeOrDuringHospitalization() {
		return testsBeforeOrDuringHospitalization;
	}

	public String getAdmissionDateTime() {
		return admissionDateTime;
	}

	public String getDischargeDateTime() {
		return dischargeDateTime;
	}

	public Float getRoomRentPerDay() {
		return roomRentPerDay;
	}

	public String getRoomType() {
		return roomType;
	}

	public String getIdentityProof() {
		return identityProof;
	}

	public Float getEstimatedHospitalBill() {
		return estimatedHospitalBill;
	}

	public Boolean isHighBloodPressure() {
		return highBloodPressure;
	}

	public String getHbpDrugName() {
		return hbpDrugName;
	}

	public String getHbpDuration() {
		return hbpDuration;
	}

	public Boolean isDiabetesMellitus() {
		return diabetesMellitus;
	}

	public String getDmDrugName() {
		return dmDrugName;
	}

	public String getDmDuration() {
		return dmDuration;
	}

	public Boolean getAnyHeartDisease() {
		return anyHeartDisease;
	}

	public String getHdDrugName() {
		return hdDrugName;
	}

	public String getHdDuration() {
		return hdDuration;
	}

	public Boolean getAnyLiverDisease() {
		return anyLiverDisease;
	}

	public String getLiverDiseaseDrugName() {
		return liverDiseaseDrugName;
	}

	public String getLiverDiseaseDuration() {
		return liverDiseaseDuration;
	}

	public Boolean getKidneyDisease() {
		return kidneyDisease;
	}

	public String getKidneyDrugName() {
		return kidneyDrugName;
	}

	public String getKdDuration() {
		return kdDuration;
	}

	public Boolean getNeurologicalDisease() {
		return neurologicalDisease;
	}

	public String getNeurologicalDiseaseDrugName() {
		return neurologicalDiseaseDrugName;
	}

	public String getNeurologicalDiseaseDuration() {
		return neurologicalDiseaseDuration;
	}

	public Boolean getCancer() {
		return cancer;
	}

	public String getCancerDrugName() {
		return cancerDrugName;
	}

	public String getCancerDuration() {
		return cancerDuration;
	}

	public Boolean getRespiratoryIllness() {
		return respiratoryIllness;
	}

	public String getRespiratoryIllnessDrugName() {
		return respiratoryIllnessDrugName;
	}

	public String getRespiratoryIllnessDuration() {
		return respiratoryIllnessDuration;
	}

	public Boolean getArthritis() {
		return arthritis;
	}

	public String getArthritisDrugName() {
		return arthritisDrugName;
	}

	public String getArthritisDuration() {
		return arthritisDuration;
	}

	public Boolean getAnyMajorDisease() {
		return anyMajorDisease;
	}

	public String getDiseaseDrugName() {
		return diseaseDrugName;
	}

	public String getDiseaseDuration() {
		return diseaseDuration;
	}

	public String getJobDetails() {
		return jobDetails;
	}

	public String getAlcoholSmokingTobacco() {
		return alcoholSmokingTobacco;
	}

	public String getDescription() {
		return description;
	}

	public String getQuestionnaireDate() {
		return questionnaireDate;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public void setInsuredName(String insuredName) {
//		this.insuredName = insuredName;
//	}
//
//	public void setClaimNumber(String claimNumber) {
//		this.claimNumber = claimNumber;
//	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

//	public void setInsuranceCompany(String insuranceCompany) {
//		this.insuranceCompany = insuranceCompany;
//	}

	public void setChiefComplained(String chiefComplained) {
		this.chiefComplained = chiefComplained;
	}

	public void setComplaintsDuration(String complaintsDuration) {
		this.complaintsDuration = complaintsDuration;
	}

	public void setDiagnosisAsPerDoctor(String diagnosisAsPerDoctor) {
		this.diagnosisAsPerDoctor = diagnosisAsPerDoctor;
	}

	public void setTestsBeforeOrDuringHospitalization(String testsBeforeOrDuringHospitalization) {
		this.testsBeforeOrDuringHospitalization = testsBeforeOrDuringHospitalization;
	}

	public void setAdmissionDateTime(String admissionDateTime) {
		this.admissionDateTime = admissionDateTime;
	}

	public void setDischargeDateTime(String dischargeDateTime) {
		this.dischargeDateTime = dischargeDateTime;
	}

	public void setRoomRentPerDay(Float roomRentPerDay) {
		this.roomRentPerDay = roomRentPerDay;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void setIdentityProof(String identityProof) {
		this.identityProof = identityProof;
	}

	public void setEstimatedHospitalBill(Float estimatedHospitalBill) {
		this.estimatedHospitalBill = estimatedHospitalBill;
	}

	public void setHighBloodPressure(Boolean highBloodPressure) {
		this.highBloodPressure = highBloodPressure;
	}

	public void setHbpDrugName(String hbpDrugName) {
		this.hbpDrugName = hbpDrugName;
	}

	public void setHbpDuration(String hbpDuration) {
		this.hbpDuration = hbpDuration;
	}

	public void setDiabetesMellitus(Boolean diabetesMellitus) {
		this.diabetesMellitus = diabetesMellitus;
	}

	public void setDmDrugName(String dmDrugName) {
		this.dmDrugName = dmDrugName;
	}

	public void setDmDuration(String dmDuration) {
		this.dmDuration = dmDuration;
	}

	public void setAnyHeartDisease(Boolean anyHeartDisease) {
		this.anyHeartDisease = anyHeartDisease;
	}

	public void setHdDrugName(String hdDrugName) {
		this.hdDrugName = hdDrugName;
	}

	public void setHdDuration(String hdDuration) {
		this.hdDuration = hdDuration;
	}

	public void setAnyLiverDisease(Boolean anyLiverDisease) {
		this.anyLiverDisease = anyLiverDisease;
	}

	public void setLiverDiseaseDrugName(String liverDiseaseDrugName) {
		this.liverDiseaseDrugName = liverDiseaseDrugName;
	}

	public void setLiverDiseaseDuration(String liverDiseaseDuration) {
		this.liverDiseaseDuration = liverDiseaseDuration;
	}

	public void setKidneyDisease(Boolean kidneyDisease) {
		this.kidneyDisease = kidneyDisease;
	}

	public void setKidneyDrugName(String kidneyDrugName) {
		this.kidneyDrugName = kidneyDrugName;
	}

	public void setKdDuration(String kdDuration) {
		this.kdDuration = kdDuration;
	}

	public void setNeurologicalDisease(Boolean neurologicalDisease) {
		this.neurologicalDisease = neurologicalDisease;
	}

	public void setNeurologicalDiseaseDrugName(String neurologicalDiseaseDrugName) {
		this.neurologicalDiseaseDrugName = neurologicalDiseaseDrugName;
	}

	public void setNeurologicalDiseaseDuration(String neurologicalDiseaseDuration) {
		this.neurologicalDiseaseDuration = neurologicalDiseaseDuration;
	}

	public void setCancer(Boolean cancer) {
		this.cancer = cancer;
	}

	public void setCancerDrugName(String cancerDrugName) {
		this.cancerDrugName = cancerDrugName;
	}

	public void setCancerDuration(String cancerDuration) {
		this.cancerDuration = cancerDuration;
	}

	public void setRespiratoryIllness(Boolean respiratoryIllness) {
		this.respiratoryIllness = respiratoryIllness;
	}

	public void setRespiratoryIllnessDrugName(String respiratoryIllnessDrugName) {
		this.respiratoryIllnessDrugName = respiratoryIllnessDrugName;
	}

	public void setRespiratoryIllnessDuration(String respiratoryIllnessDuration) {
		this.respiratoryIllnessDuration = respiratoryIllnessDuration;
	}

	public void setArthritis(Boolean arthritis) {
		this.arthritis = arthritis;
	}

	public void setArthritisDrugName(String arthritisDrugName) {
		this.arthritisDrugName = arthritisDrugName;
	}

	public void setArthritisDuration(String arthritisDuration) {
		this.arthritisDuration = arthritisDuration;
	}

	public void setAnyMajorDisease(Boolean anyMajorDisease) {
		this.anyMajorDisease = anyMajorDisease;
	}

	public void setDiseaseDrugName(String diseaseDrugName) {
		this.diseaseDrugName = diseaseDrugName;
	}

	public void setDiseaseDuration(String diseaseDuration) {
		this.diseaseDuration = diseaseDuration;
	}

	public void setJobDetails(String jobDetails) {
		this.jobDetails = jobDetails;
	}

	public void setAlcoholSmokingTobacco(String alcoholSmokingTobacco) {
		this.alcoholSmokingTobacco = alcoholSmokingTobacco;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setQuestionnaireDate(String questionnaireDate) {
		this.questionnaireDate = questionnaireDate;
	}

	public InsuredQuestionnaire() {
		super();
	}

	public InsuredQuestionnaire(int id, String hospitalName, String chiefComplained, String complaintsDuration,
			String diagnosisAsPerDoctor, String testsBeforeOrDuringHospitalization, String admissionDateTime,
			String dischargeDateTime, Float roomRentPerDay, String roomType, String identityProof,
			Float estimatedHospitalBill, Boolean highBloodPressure, String hbpDrugName, String hbpDuration,
			Boolean diabetesMellitus, String dmDrugName, String dmDuration, Boolean anyHeartDisease, String hdDrugName,
			String hdDuration, Boolean anyLiverDisease, String liverDiseaseDrugName, String liverDiseaseDuration,
			Boolean kidneyDisease, String kidneyDrugName, String kdDuration, Boolean neurologicalDisease,
			String neurologicalDiseaseDrugName, String neurologicalDiseaseDuration, Boolean cancer,
			String cancerDrugName, String cancerDuration, Boolean respiratoryIllness, String respiratoryIllnessDrugName,
			String respiratoryIllnessDuration, Boolean arthritis, String arthritisDrugName, String arthritisDuration,
			Boolean anyMajorDisease, String diseaseDrugName, String diseaseDuration, String jobDetails,
			String alcoholSmokingTobacco, String description, String questionnaireDate, Claim claim) {
		super();
		this.id = id;
		this.hospitalName = hospitalName;
		this.chiefComplained = chiefComplained;
		this.complaintsDuration = complaintsDuration;
		this.diagnosisAsPerDoctor = diagnosisAsPerDoctor;
		this.testsBeforeOrDuringHospitalization = testsBeforeOrDuringHospitalization;
		this.admissionDateTime = admissionDateTime;
		this.dischargeDateTime = dischargeDateTime;
		this.roomRentPerDay = roomRentPerDay;
		this.roomType = roomType;
		this.identityProof = identityProof;
		this.estimatedHospitalBill = estimatedHospitalBill;
		this.highBloodPressure = highBloodPressure;
		this.hbpDrugName = hbpDrugName;
		this.hbpDuration = hbpDuration;
		this.diabetesMellitus = diabetesMellitus;
		this.dmDrugName = dmDrugName;
		this.dmDuration = dmDuration;
		this.anyHeartDisease = anyHeartDisease;
		this.hdDrugName = hdDrugName;
		this.hdDuration = hdDuration;
		this.anyLiverDisease = anyLiverDisease;
		this.liverDiseaseDrugName = liverDiseaseDrugName;
		this.liverDiseaseDuration = liverDiseaseDuration;
		this.kidneyDisease = kidneyDisease;
		this.kidneyDrugName = kidneyDrugName;
		this.kdDuration = kdDuration;
		this.neurologicalDisease = neurologicalDisease;
		this.neurologicalDiseaseDrugName = neurologicalDiseaseDrugName;
		this.neurologicalDiseaseDuration = neurologicalDiseaseDuration;
		this.cancer = cancer;
		this.cancerDrugName = cancerDrugName;
		this.cancerDuration = cancerDuration;
		this.respiratoryIllness = respiratoryIllness;
		this.respiratoryIllnessDrugName = respiratoryIllnessDrugName;
		this.respiratoryIllnessDuration = respiratoryIllnessDuration;
		this.arthritis = arthritis;
		this.arthritisDrugName = arthritisDrugName;
		this.arthritisDuration = arthritisDuration;
		this.anyMajorDisease = anyMajorDisease;
		this.diseaseDrugName = diseaseDrugName;
		this.diseaseDuration = diseaseDuration;
		this.jobDetails = jobDetails;
		this.alcoholSmokingTobacco = alcoholSmokingTobacco;
		this.description = description;
		this.questionnaireDate = questionnaireDate;
		this.claim = claim;
	}

	@Override
	public String toString() {
		return "InsuredQuestionnaire [id=" + id + ", hospitalName=" + hospitalName + ", chiefComplained="
				+ chiefComplained + ", complaintsDuration=" + complaintsDuration + ", diagnosisAsPerDoctor="
				+ diagnosisAsPerDoctor + ", testsBeforeOrDuringHospitalization=" + testsBeforeOrDuringHospitalization
				+ ", admissionDateTime=" + admissionDateTime + ", dischargeDateTime=" + dischargeDateTime
				+ ", roomRentPerDay=" + roomRentPerDay + ", roomType=" + roomType + ", identityProof=" + identityProof
				+ ", estimatedHospitalBill=" + estimatedHospitalBill + ", highBloodPressure=" + highBloodPressure
				+ ", hbpDrugName=" + hbpDrugName + ", hbpDuration=" + hbpDuration + ", diabetesMellitus="
				+ diabetesMellitus + ", dmDrugName=" + dmDrugName + ", dmDuration=" + dmDuration + ", anyHeartDisease="
				+ anyHeartDisease + ", hdDrugName=" + hdDrugName + ", hdDuration=" + hdDuration + ", anyLiverDisease="
				+ anyLiverDisease + ", liverDiseaseDrugName=" + liverDiseaseDrugName + ", liverDiseaseDuration="
				+ liverDiseaseDuration + ", kidneyDisease=" + kidneyDisease + ", kidneyDrugName=" + kidneyDrugName
				+ ", kdDuration=" + kdDuration + ", neurologicalDisease=" + neurologicalDisease
				+ ", neurologicalDiseaseDrugName=" + neurologicalDiseaseDrugName + ", neurologicalDiseaseDuration="
				+ neurologicalDiseaseDuration + ", cancer=" + cancer + ", cancerDrugName=" + cancerDrugName
				+ ", cancerDuration=" + cancerDuration + ", respiratoryIllness=" + respiratoryIllness
				+ ", respiratoryIllnessDrugName=" + respiratoryIllnessDrugName + ", respiratoryIllnessDuration="
				+ respiratoryIllnessDuration + ", arthritis=" + arthritis + ", arthritisDrugName=" + arthritisDrugName
				+ ", arthritisDuration=" + arthritisDuration + ", anyMajorDisease=" + anyMajorDisease
				+ ", diseaseDrugName=" + diseaseDrugName + ", diseaseDuration=" + diseaseDuration + ", jobDetails="
				+ jobDetails + ", alcoholSmokingTobacco=" + alcoholSmokingTobacco + ", description=" + description
				+ ", questionnaireDate=" + questionnaireDate + ", claim=" + claim + "]";
	}

}