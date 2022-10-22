package com.imageinnovate.employee.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateEmployeeRequest {
	@NotBlank
	@Size(min = 1, max = 10)
	private String firstName;
	
	@NotBlank
	@Size(min = 1, max = 10)
	private String lastName;
	
	@NotBlank
	@Email
	private String email;
	
	@NotNull
	@NotEmpty
	private List<Long> phoneContacts;

	@NotBlank
	private Date dateOfJoining;

	@Column(name = "sal_per_mon", nullable = false)
	private Integer salaryPerMonth;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Long> getPhoneContacts() {
		return phoneContacts;
	}

	public void setPhoneContacts(List<Long> phoneContacts) {
		this.phoneContacts = phoneContacts;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Integer getSalaryPerMonth() {
		return salaryPerMonth;
	}

	public void setSalaryPerMonth(Integer salaryPerMonth) {
		this.salaryPerMonth = salaryPerMonth;
	}
	
}
