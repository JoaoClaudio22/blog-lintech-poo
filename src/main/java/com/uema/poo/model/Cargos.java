package com.uema.poo.model;


//ENUM de cargos que o user pode escolher
public enum Cargos {
	LEITOR("LEITOR"),
	EDITOR("EDITOR");
	
	private String nome;
	
	private Cargos(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
}
