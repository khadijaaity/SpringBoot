package com.netmind.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull(message = "The id should not be null")
	@Positive(message = "The id should be greater than 0")
	@Column(name = "Client_ID")
	private Long id;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST)
	private List<Pedido> ordersList = new ArrayList<Pedido>();

	@Column(name = "firstName")
	@NotNull(message = "The firstName is mandatory")
	@NotBlank(message = "The firstName should not be blank")
	private String firtsName;

	@Column(name = "lastName")
	@NotNull(message = "The lastName is mandatory")
	@NotBlank(message = "The lastname should not be blank")
	private String lastName;
}
