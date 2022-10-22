package com.imageinnovate.employee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imageinnovate.employee.constants.UriConstants;
import com.imageinnovate.employee.exception.InvalidRequestParameterException;
import com.imageinnovate.employee.pojo.CreateEmployeeRequest;
import com.imageinnovate.employee.pojo.EmployeeResponse;
import com.imageinnovate.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(UriConstants.CREATE_NEW_EMPLOYEE)
	public EmployeeResponse createNewEmployee(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest, BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			throw new InvalidRequestParameterException("VALIDATION FAILED.", bindingResult);
		}
		return employeeService.createEmployee(createEmployeeRequest);
	}
}
