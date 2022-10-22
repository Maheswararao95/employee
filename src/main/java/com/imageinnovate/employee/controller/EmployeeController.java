package com.imageinnovate.employee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imageinnovate.employee.constants.UriConstants;
import com.imageinnovate.employee.exception.InvalidRequestParameterException;
import com.imageinnovate.employee.exception.RequestFailedException;
import com.imageinnovate.employee.pojo.CreateEmployeeRequest;
import com.imageinnovate.employee.pojo.EmployeeResponse;
import com.imageinnovate.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(UriConstants.CREATE_NEW_EMPLOYEE)
	public EmployeeResponse createNewEmployee(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new InvalidRequestParameterException("VALIDATION FAILED.", bindingResult);
		}
		return employeeService.createEmployee(createEmployeeRequest);
	}
	
	@GetMapping(UriConstants.GET_EMP_SAL_DETAILS)
	public Object getEmployeeTaxDetails(@PathVariable Integer id) throws RequestFailedException {
		if (id == null) {
			throw new InvalidRequestParameterException("Employee id can not be null. Bad Request");
		}
		return employeeService.getSalDetails(id);
	}
}
