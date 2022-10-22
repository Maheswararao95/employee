package com.imageinnovate.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imageinnovate.employee.entity.EmployeeContact;

public interface EmployeeContactRepository extends JpaRepository<EmployeeContact, Integer> {

}
