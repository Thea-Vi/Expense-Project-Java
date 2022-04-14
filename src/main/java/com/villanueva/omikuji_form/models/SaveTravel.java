package com.villanueva.omikuji_form.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "safetravels")

public class SaveTravel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 3, max = 30, message = "Expense name must be at least 3-30 characters")
	private String name;

	@NotNull
	@Size(min = 3, max = 30, message = "Vendor name must be at least 3-30 characters")
	private String vendor;

	@NotNull
	@Min(value = 0, message = "Amount name must be at least 0")
	private Double amount;

	@NotNull
	@Size(min = 3, max = 250, message = "Description must be at least 3-250 characters")
	private String description;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

// lets Java to automatically generate the time stamps
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public SaveTravel() {

	}

//	to generate --> source --> generate constructor using fields
// loaded constructor
	public SaveTravel(String name, String vendor, Double amount, String description) {
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}

//	GENERATE GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAtDate() {
		return createdAt;
	}

	public void setCreatedAtDate(Date createdAtDate) {
		this.createdAt = createdAtDate;
	}

	public Date getUpdatedAtDate() {
		return updatedAt;
	}

	public void setUpdatedAtDate(Date updatedAtDate) {
		this.updatedAt = updatedAtDate;
	}

}
