package com.uema.poo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uema.poo.model.Usuarios;

//Padrão de projeto DAO ( Data Access Object ) - Utilizado para fazer a persistencia de dados no banco


//Interface que herda métodos que fazem a parte de CRUD do sistema na classe Usuarios
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuarios, Long> {
	Usuarios findByUsername(String username);
}
