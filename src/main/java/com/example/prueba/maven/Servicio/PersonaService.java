package com.example.prueba.maven.Servicio;

import com.example.prueba.maven.domain.Persona;
import java.util.List;

public interface PersonaService {

    public List<Persona> ListarPersonas();

    public void Guardar(Persona persona);

    public void Eliminar (Persona persona);

    public Persona EncontrarPersona (Persona persona);
}
