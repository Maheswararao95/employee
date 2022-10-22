package com.imageinnovate.employee.pojo;

import java.util.List;

public class EmployeeResponse {
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String dateOfJoining;
	private String email;
	private Integer salPerMonth;
	private List<Long> phoneNumbers;
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
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getSalPerMonth() {
		return salPerMonth;
	}
	public void setSalPerMonth(Integer salPerMonth) {
		this.salPerMonth = salPerMonth;
	}
	public List<Long> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<Long> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
}
