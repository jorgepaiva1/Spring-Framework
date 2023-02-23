package com.example.prueba.maven.Dao;


import com.example.prueba.maven.domain.Persona;
import org.springframework.data.repository.CrudRepository;

public interface iPersonaDao extends CrudRepository<Persona, Long /*el tipo de valor de la llave primaria*/> {



}
