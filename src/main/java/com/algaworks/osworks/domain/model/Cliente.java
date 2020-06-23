package com.algaworks.osworks.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"nome", "email", "telefone"})
public class Cliente {
	
	@Id   // define a chave primaria da entidade
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //auto increment
	private Long id;
	private String nome;
	private String email;
	private String telefone;

}
