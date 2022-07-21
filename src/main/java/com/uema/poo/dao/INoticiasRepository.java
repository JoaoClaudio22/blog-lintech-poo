package com.uema.poo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uema.poo.model.Noticias;

//Padrão de projeto DAO ( Data Access Object ) - Utilizado para fazer a persistencia de dados no banco

//Interface que herda métodos que fazem a parte de CRUD do sistema na classe Noticias
@Repository
public interface INoticiasRepository extends JpaRepository<Noticias, Long> {

}
