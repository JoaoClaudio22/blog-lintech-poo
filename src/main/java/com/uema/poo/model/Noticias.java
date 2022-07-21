package com.uema.poo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Entidades do banco de dados - Noticias

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Noticias {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String tituloNoticia;
	
	@Lob
	private String conteudo;
//	
//	@JsonIgnoreProperties({"noticias"})
	@ManyToOne()
	@JoinColumn(name = "id_autor_fk")
	private Usuarios autor;
	
}
