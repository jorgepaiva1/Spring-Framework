package com.example.prueba.maven.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "El nombre no puede estar Vacio")
    private String Nombre;
    @NotEmpty(message = "El Apellido no puede estar Vacio")
    private String Apellido;
    @NotEmpty(message = "El Email no puede estar Vacio")
    @Email(message = "no es un Email valido")
    private String Email;
    private String Telefono;
}
