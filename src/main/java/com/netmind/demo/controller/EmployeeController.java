package com.netmind.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netmind.demo.dao.EmployeeDao;
import com.netmind.demo.model.Employee;
import com.netmind.demo.model.Employees;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@GetMapping(path = "/employees", produces = "application/json")
	public ResponseEntity<Employees> getEmployees() {
		return ResponseEntity.ok(employeeDao.getAllEmployees());
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(
			@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeDao.addEmployee(employee));
	}

}
