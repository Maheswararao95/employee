package com.imageinnovate.employee.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_contact")
public class EmployeeContact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_contact_id")
	private Integer empContactId;
	
	@Column(name = "employee_id", nullable = false)
	private Employee employee;
	
	@Column(name = "country_code", nullable = false)
	private Integer countryCode;
	
	@Column(name = "phone", nullable = false)
	private Long phoneNumber;
	
	@Column(name = "is_primary")
	private Boolean isPrimary = false;
	
	@Column(name = "created_ts", nullable = false)
	private Timestamp createdTimestamp;
	
	@Column(name = "updated_ts")
	private Timestamp updatedTimestamp;

	public Integer getEmpContactId() {
		return empContactId;
	}

	public void setEmpContactId(Integer empContactId) {
		this.empContactId = empContactId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public Timestamp getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Timestamp createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Timestamp getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(Timestamp updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}
}
