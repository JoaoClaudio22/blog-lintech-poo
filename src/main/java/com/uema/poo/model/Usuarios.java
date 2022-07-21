package com.uema.poo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Entidades do banco de dados - Usuarios

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String username;
	
	private String email;
	
	private String password;

	private String role;
	
	
	
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
	private List<Noticias> noticia;


}
