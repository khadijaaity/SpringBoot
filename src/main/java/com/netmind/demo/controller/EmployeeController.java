package com.netmind.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netmind.demo.dao.EmployeeDao;
import com.netmind.demo.model.Employees;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@GetMapping(path = "/employees", produces = "application/json")
	public Employees getEmployees() {
		return employeeDao.getAllEmployees();
	}
}
