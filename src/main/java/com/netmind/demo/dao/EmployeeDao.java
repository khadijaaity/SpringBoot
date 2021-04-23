package com.netmind.demo.dao;

import org.springframework.stereotype.Repository;

import com.netmind.demo.model.Employee;
import com.netmind.demo.model.Employees;

@Repository
public class EmployeeDao {
	private static Employees list = new Employees();

	static {
		list.getEmployeeList().add(
				new Employee(1, "Lokesh", "Gupta", "howdoinjava@netmind.com"));
		list.getEmployeeList()
				.add(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
		list.getEmployeeList()
				.add(new Employee(3, "David", "Kameron", "titatic@gmail.com"));
		list.getEmployeeList()
				.add(new Employee(4, "Carmen", "Kameron", "mnc@gmail.com"));
	}

	public Employees getAllEmployees() {
		return list;
	}

	public void addEmployee(Employee employee) {
		list.getEmployeeList().add(employee);
	}

}
