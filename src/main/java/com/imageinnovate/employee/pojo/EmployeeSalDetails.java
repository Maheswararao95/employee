package com.imageinnovate.employee.pojo;

public class EmployeeSalDetails {
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private Integer salPerYear;
	private Integer totalSalary;
	private Integer taxAmount;
	private Integer cessAmount;

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

	public Integer getSalPerYear() {
		return salPerYear;
	}

	public void setSalPerYear(Integer salPerYear) {
		this.salPerYear = salPerYear;
	}

	public Integer getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Integer taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Integer getCessAmount() {
		return cessAmount;
	}

	public void setCessAmount(Integer cessAmount) {
		this.cessAmount = cessAmount;
	}

	public Integer getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(Integer totalSalary) {
		this.totalSalary = totalSalary;
	}

}
