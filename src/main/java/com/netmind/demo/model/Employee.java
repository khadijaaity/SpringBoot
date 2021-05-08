package com.netmind.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
public class Employee {

	/*
	 * When the target argument fails to pass the validation, Spring Boot throws
	 * a MethodArgumentNotValidException exception.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "firstName")
	@NotNull(message = "The firstName is mandatory")
	@NotBlank(message = "The firstname should not be blank")
	private String firstName;

	@Column(name = "lastName")
	@NotNull(message = "The lastName is mandatory")
	@NotBlank(message = "The lastname should not be blank")
	private String lastName;

	@Column(name = "email")
	@NotNull(message = "The email is mandatory")
	@NotBlank(message = "The email should not be blank")
	@Email(message = "The email is not correct")
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee() {

	}

	public Employee(Integer id, String firstName, String lastName,
			String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ",lastName="
				+ lastName + ", email=" + email + "]";
	}
}
