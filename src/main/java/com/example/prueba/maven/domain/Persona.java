package com.example.prueba.maven.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;


@Data
@Entity
@Table(name= "persona") //para que no haya problema con mayusculas o minusculas en nombre de tablas
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    private String Nombre;
    private String Apellido;
    private String Email;
    private String Telefono;
}
