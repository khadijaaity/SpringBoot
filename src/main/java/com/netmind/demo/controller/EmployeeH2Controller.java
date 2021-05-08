package com.netmind.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netmind.demo.model.Employee;
import com.netmind.demo.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/employeeh2")
public class EmployeeH2Controller {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(path = "/employees", produces = "application/json")
	public ResponseEntity<List<Employee>> getEmployees() {
		return ResponseEntity.ok(employeeService.getEmployees());
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(
			@Valid @RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.createEmployee(employee));
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id,
			@RequestBody Employee employee) {
		Employee employeeFromDb = employeeService.getEmployeeById(id);

		employeeFromDb.setFirstName(employee.getFirstName());
		employeeFromDb.setLastName(employee.getLastName());
		employeeFromDb.setEmail(employee.getEmail());

		return ResponseEntity.ok(employeeService.createEmployee(employee));
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok().build();
	}

}
