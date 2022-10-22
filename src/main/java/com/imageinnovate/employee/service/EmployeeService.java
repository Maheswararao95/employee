package com.imageinnovate.employee.service;

import com.imageinnovate.employee.exception.RequestFailedException;
import com.imageinnovate.employee.pojo.CreateEmployeeRequest;
import com.imageinnovate.employee.pojo.EmployeeResponse;
import com.imageinnovate.employee.pojo.EmployeeSalDetails;

public interface EmployeeService {
	public EmployeeResponse createEmployee(CreateEmployeeRequest createEmployeeRequest);
	public EmployeeSalDetails getSalDetails(Integer employeeId) throws RequestFailedException;
}
