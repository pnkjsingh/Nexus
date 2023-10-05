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

@Entity
@Table(name = "Claim")
public class Claim {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claim_id")
    private Long claimId;

    @Column(name = "claim_amount")
    private double claimAmount;

    @Column(name = "claim_date")
    private Date claimDate;

	// Define the many-to-one relationship with Insurance
    @ManyToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

	public Long getClaimId() {
		return claimId;
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

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
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

	public Claim(Long claimId, double claimAmount, Date claimDate, Insurance insurance) {
		super();
		this.claimId = claimId;
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
		return "Claim [claimId=" + claimId + ", claimAmount=" + claimAmount + ", claimDate=" + claimDate
				+ ", insurance=" + insurance + "]";
	}

}