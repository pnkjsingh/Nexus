package com.app.nexus.entity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Claim")
public class Claim {

//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claim_number")
    private String claimNumber;

	@NotNull
	@Column(name = "claim_amount")
    private double claimAmount;

	@NotNull
	@Column(name = "claim_date")
    private Date claimDate;

	@Column(name = "assigned_to")
    private String assignedTo;

	// Define the many-to-one relationship with Insurance
    @NotNull
    @ManyToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;
    
 // Define the one-to-one relationship with InsuredQuestionnaire
    @OneToOne(mappedBy = "claim", cascade = CascadeType.ALL)
    @JoinColumn(name="insuredQuestionnaire_id")
    private InsuredQuestionnaire insuredQuestionnaire;

    // Define the one-to-one relationship with Treating Doctor Questionnaire
    @OneToOne(mappedBy = "claim", cascade = CascadeType.ALL)
    @JoinColumn(name="FamilyDrQuestionnaire_id")
    private FamilyDoctorQuestionnaire familyDrQuestionnaire;

    // Define the one-to-one relationship with Treating Doctor Questionnaire
    @OneToOne(mappedBy = "claim", cascade = CascadeType.ALL)
    @JoinColumn(name="TreatingDrQuestionnaire_id")
    private TreatingDrQuestionnaire treatingDrQuestionnaire;
    
//	public Long getId() {
//		return id;
//	}

    public InsuredQuestionnaire getInsuredQuestionnaire() {
		return insuredQuestionnaire;
	}

	public void setInsuredQuestionnaire(InsuredQuestionnaire insuredQuestionnaire) {
		this.insuredQuestionnaire = insuredQuestionnaire;
	}

	public String getClaimNumber() {
		return claimNumber;
	}

    public double getClaimAmount() {
		return claimAmount;
	}

	public Date getClaimDate() {
		return claimDate;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

//	public void setId(Long id) {
//		this.id = id;
//	}
	
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	public FamilyDoctorQuestionnaire getFamilyDrQuestionnaire() {
		return familyDrQuestionnaire;
	}

	public void setFamilyDrQuestionnaire(FamilyDoctorQuestionnaire familyDrQuestionnaire) {
		this.familyDrQuestionnaire = familyDrQuestionnaire;
	}

	public TreatingDrQuestionnaire getTreatingDrQuestionnaire() {
		return treatingDrQuestionnaire;
	}
	public void setTreatingDrQuestionnaire(TreatingDrQuestionnaire treatingDrQuestionnaire) {
		this.treatingDrQuestionnaire = treatingDrQuestionnaire;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Claim(String claimNumber, @NotNull double claimAmount, @NotNull Date claimDate, String assignedTo,
			@NotNull Insurance insurance, InsuredQuestionnaire insuredQuestionnaire, FamilyDoctorQuestionnaire familyDrQuestionnaire, TreatingDrQuestionnaire treatingDrQuestionnaire) {
		super();
		this.claimNumber = claimNumber;
		this.claimAmount = claimAmount;
		this.claimDate = claimDate;
		this.assignedTo = assignedTo;
		this.insurance = insurance;
		this.insuredQuestionnaire = insuredQuestionnaire;
		this.familyDrQuestionnaire = familyDrQuestionnaire;
		this.treatingDrQuestionnaire = treatingDrQuestionnaire;
	}

	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Claim [claimNumber=" + claimNumber + ", claimAmount=" + claimAmount + ", claimDate=" + claimDate
				+ ", assignedTo=" + assignedTo + ", insurance=" + insurance + ", insuredQuestionnaire="
				+ insuredQuestionnaire + ", familyDrQuestionnaire=" + familyDrQuestionnaire
				+ ", treatingDrQuestionnaire=" + treatingDrQuestionnaire + "]";
	}

}