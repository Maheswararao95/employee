package com.imageinnovate.employee.service;

import com.imageinnovate.employee.entity.Employee;
import com.imageinnovate.employee.pojo.CreateEmployeeRequest;

public interface EmployeeService {
	public Employee createEmployee(CreateEmployeeRequest createEmployeeRequest) throws Exception;
}
