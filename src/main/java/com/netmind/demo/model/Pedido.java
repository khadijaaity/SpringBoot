package com.netmind.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	private Long id;

	@ManyToOne
	@JoinColumn(name = "CLIENTE_ID")
	private Cliente cliente;

	@Column(name = "price")
	private float price;

	@Column(name = "details")
	private String details;

}
