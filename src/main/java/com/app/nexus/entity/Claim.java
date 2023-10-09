package com.app.nexus.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

	// Define the many-to-one relationship with Insurance
    @NotNull
    @ManyToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

//	public Long getId() {
//		return id;
//	}

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

//	public void setId(Long id) {
//		this.id = id;
//	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
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

	public Claim(/* Long id, */ String claimNumber, double claimAmount, Date claimDate, Insurance insurance) {
		super();
//		this.id = id;
		this.claimNumber = claimNumber;
		this.claimAmount = claimAmount;
		this.claimDate = claimDate;
		this.insurance = insurance;
	}

	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Claim [claimNumber=" + claimNumber + ", claimAmount=" + claimAmount + ", claimDate=" + claimDate
				+ ", insurance=" + insurance + "]";
	}

}