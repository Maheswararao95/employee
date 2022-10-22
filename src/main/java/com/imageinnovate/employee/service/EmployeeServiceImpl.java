package com.imageinnovate.employee.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imageinnovate.employee.entity.Employee;
import com.imageinnovate.employee.entity.EmployeeContact;
import com.imageinnovate.employee.exception.RequestFailedException;
import com.imageinnovate.employee.pojo.CreateEmployeeRequest;
import com.imageinnovate.employee.pojo.EmployeeResponse;
import com.imageinnovate.employee.pojo.EmployeeSalDetails;
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
	public EmployeeResponse createEmployee(CreateEmployeeRequest createEmployeeRequest) {
		Employee employee = populateEmployee(createEmployeeRequest);
		employeeRepository.save(employee);
		List<EmployeeContact> employeeContacts = populatEmployeeContacts(createEmployeeRequest, employee);
		employeeContactRepository.saveAll(employeeContacts);
		employee.setPhoneContacts(employeeContacts);
		return prepareEmployeeResponse(employee);
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
	
	private EmployeeResponse prepareEmployeeResponse(Employee employee) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setEmployeeId(employee.getEmployeeId());
		employeeResponse.setFirstName(employee.getFirstName());
		employeeResponse.setLastName(employee.getLastName());
		employeeResponse.setEmail(employee.getEmail());
		employeeResponse.setDateOfJoining(employee.getDateOfJoining().toString());
		List<Long> phonesList = new ArrayList<>();
		for (EmployeeContact phone: employee.getPhoneContacts()) {
			phonesList.add(phone.getPhoneNumber());
		}
		employeeResponse.setPhoneNumbers(phonesList);
		return employeeResponse;
	}

	/**
	 * Method to find the employee details and return the sal details.
	 */
	@Override
	public EmployeeSalDetails getSalDetails(Integer employeeId) throws RequestFailedException {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RequestFailedException("Invalid employee id."));
		EmployeeSalDetails employeeSalDetails = populateEmployeeSalDetails(employee);
		return employeeSalDetails;
	}
	
	/**
	 * Method to calculate the salary and tax details.
	 * @param employee
	 * @return
	 */
	private EmployeeSalDetails populateEmployeeSalDetails(Employee employee) {
		EmployeeSalDetails salDetails = new EmployeeSalDetails();
		salDetails.setEmployeeId(employee.getEmployeeId());
		salDetails.setFirstName(employee.getFirstName());
		salDetails.setLastName(employee.getLastName());
		
		// Calculate the total salary.
		int salPerYear = employee.getSalaryPerMonth()*12;
		salDetails.setSalPerYear(salPerYear);
		int totalSalary = calculateTotalSalary(employee);
		salDetails.setTotalSalary(totalSalary);
		int taxAmount = getTaxAmount(salPerYear, totalSalary);
		salDetails.setTaxAmount(taxAmount);
		int cess = (salPerYear > 2500000)? totalSalary*(2/100) : 0;
		salDetails.setCessAmount(cess);
		
		return salDetails;
	}
	
	private Integer calculateTotalSalary(Employee employee) {
		LocalDate dateOfJoining = employee.getDateOfJoining();
		int joinDate = dateOfJoining.getDayOfMonth();
		
		// To Calculate loss of pay.
		// Get the num of days in  month by passing whether leap year or not.
		int totalNumOfDaysInJoinedMonth = dateOfJoining.getMonth().length(dateOfJoining.getYear() % 4 == 0); 
		int daysEligibleForLOP = totalNumOfDaysInJoinedMonth - joinDate;
		int lopPerDay = Math.round(employee.getSalaryPerMonth()/30);
		int totalLOP = lopPerDay * daysEligibleForLOP;
		
		int numOfMonthsWorked = LocalDate.now().getMonthValue() - dateOfJoining.getMonthValue();
		int totalSal = numOfMonthsWorked * employee.getSalaryPerMonth();
		int totalSalAfterLOP = totalSal - totalLOP;
		return totalSalAfterLOP;
	}
	
	private Integer getTaxAmount(int salPerYear, int totalSal) {
		/* 
		 * EX: 8.5 00 000
		 * 0 %
		 * 2.5 - 5 -> 5%
		 * 5-10 -> 10%
		 */
		int totalTaxAmount = 0;
		if (salPerYear <= 250000) {
			totalTaxAmount = 0; // 0%
		}
		if (250000<salPerYear && salPerYear<=500000) {
			totalTaxAmount = 250000*(5/100); // 5%
		}
		if (500000<salPerYear && salPerYear<=1000000) {
			totalTaxAmount = totalTaxAmount+(500000*10/100); // 10%
		}
		if (salPerYear > 1000000) {
			totalTaxAmount = totalTaxAmount+((totalSal-1000000)*20/100); // 20% on remaining.
		}
		
		return totalTaxAmount;
	}
}
