package com.example.prueba.maven.Servicio;

import com.example.prueba.maven.domain.Persona;
import com.example.prueba.maven.Dao.iPersonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private iPersonaDao personaDao;
    @Override
    @Transactional(readOnly = true)
    public List<Persona> ListarPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void Guardar(Persona persona) {
            personaDao.save(persona);
    }

    @Override
    @Transactional
    public void Eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona EncontrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
}
