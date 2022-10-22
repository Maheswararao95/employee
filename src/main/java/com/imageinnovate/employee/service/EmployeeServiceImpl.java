package com.imageinnovate.employee.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imageinnovate.employee.entity.Employee;
import com.imageinnovate.employee.entity.EmployeeContact;
import com.imageinnovate.employee.pojo.CreateEmployeeRequest;
import com.imageinnovate.employee.repo.EmployeeContactRepository;
import com.imageinnovate.employee.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeContactRepository employeeContactRepository;
	
	@Override
	@Transactional
	/**
	 * Method to save employee details.
	 */
	public Employee createEmployee(CreateEmployeeRequest createEmployeeRequest) throws Exception {
		Employee employee = populateEmployee(createEmployeeRequest);
		employeeRepository.save(employee);
		List<EmployeeContact> employeeContacts = populatEmployeeContacts(createEmployeeRequest, employee);
		employeeContactRepository.saveAll(employeeContacts);
		employee.setPhoneContacts(employeeContacts);
		return employee;
	}
	
	/**
	 * Method to populate the employee object.
	 * @param createEmployeeRequest
	 * @return
	 */
	private Employee populateEmployee(CreateEmployeeRequest createEmployeeRequest) {
		Employee employee = new Employee();
		employee.setEmail(createEmployeeRequest.getEmail());
		employee.setDateOfJoining(createEmployeeRequest.getDateOfJoining());
		employee.setFirstName(createEmployeeRequest.getFirstName());
		employee.setLastName(createEmployeeRequest.getLastName());
		employee.setSalaryPerMonth(createEmployeeRequest.getSalaryPerMonth());
		employee.setCreatedTimestamp(new Timestamp(System.currentTimeMillis()));
		return employee;
	}
	
	/**
	 * Method to populate the employee contact objects.
	 * @param createEmployeeRequest
	 * @param employee
	 * @return
	 */
	private List<EmployeeContact> populatEmployeeContacts(CreateEmployeeRequest createEmployeeRequest, Employee employee) {
		List<EmployeeContact> employeeContacts = new ArrayList<>();
		for (Long phone: createEmployeeRequest.getPhoneContacts()) {
			EmployeeContact contact = new EmployeeContact();
			contact.setPhoneNumber(phone);
			contact.setEmployee(employee);
			contact.setCountryCode(91);
			contact.setIsPrimary(false);
			contact.setCreatedTimestamp(new Timestamp(System.currentTimeMillis()));
			
			employeeContacts.add(contact);
		}
		return employeeContacts;
	}
	
}
