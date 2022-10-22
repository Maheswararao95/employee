package com.imageinnovate.employee.service;

import com.imageinnovate.employee.pojo.CreateEmployeeRequest;
import com.imageinnovate.employee.pojo.EmployeeResponse;

public interface EmployeeService {
	public EmployeeResponse createEmployee(CreateEmployeeRequest createEmployeeRequest) throws Exception;
}
