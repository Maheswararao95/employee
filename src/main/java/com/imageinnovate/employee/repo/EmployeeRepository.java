package com.imageinnovate.employee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imageinnovate.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
