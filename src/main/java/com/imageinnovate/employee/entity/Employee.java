package com.imageinnovate.employee.entity;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employeeId;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@ManyToOne
	private List<EmployeeContact> phoneContacts;

	@Column(name = "joined_date", nullable = false)
	private Date dateOfJoining;

	@Column(name = "sal_per_mon", nullable = false)
	private Integer salaryPerMonth;

	@Column(name = "created_ts", nullable = false)
	private Timestamp createdTimestamp;

	@Column(name = "updated_ts")
	private Timestamp updatedTimestamp;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

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

	public List<EmployeeContact> getPhoneContacts() {
		return phoneContacts;
	}

	public void setPhoneContacts(List<EmployeeContact> phoneContacts) {
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
