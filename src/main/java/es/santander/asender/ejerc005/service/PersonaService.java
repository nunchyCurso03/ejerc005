package es.santander.asender.ejerc005.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.asender.ejerc005.model.Persona;
import es.santander.asender.ejerc005.repository.PersonaRepository;
 
@Transactional
@Service
public class PersonaService {

    @Autowired
    private PersonaRepository repository;

 

    // CREATE
    public Persona create(Persona persona) {

        if (persona.getId() != null) {
            throw new CrudSecurityException("Han tratado de modificar un registro persona",
                    CRUDOperation.CREATE,
                    persona.getId());
        } else {
            return repository.save(persona);
        }

    }

    // Leer un registro por id
    public Persona read(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Listar
    public List<Persona> list() {
        return repository.findAll();
    }

    // UPDATE
    public Persona update(Persona persona) {
        if (persona.getId() == null) {
            throw new CrudSecurityException("Han tratado de crear un registro persona utilizando modificar",
                    CRUDOperation.UPDATE,
                    null);
        }
        return repository.save(persona);
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }

}