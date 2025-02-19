package es.santander.asender.ejerc005.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.asender.ejerc005.model.Pais;
import es.santander.asender.ejerc005.model.Persona;
import es.santander.asender.ejerc005.repository.PaisRepository;

@Transactional
@Service
public class PaisService {

     @Autowired
    private PaisRepository repository;

    // CREATE
    public Pais create(Pais pais) {

        if (pais.getId() != null) {
            throw new CrudSecurityException("Han tratado de modificar un registro pais",
                    CRUDOperation.CREATE,
                    pais.getId());
        } else {
            return repository.save(pais);
        }

    }

     // Leer un registro por id
     public Pais read(Long id) {
        return repository.findById(id).orElse(null);
    }

       
    // Listar
    public List<Pais> list() {
        return repository.findAll();
    } 

     // UPDATE-->modificar registro
     public Pais update(Pais pais) {
        if (pais.getId() == null) {
            throw new CrudSecurityException("Han tratado de crear un registro pais utilizando modificar",
                    CRUDOperation.UPDATE,
                    null);
        }
        return repository.save(pais);
    }

     // DELETE
     public void delete(Long id) {
        repository.deleteById(id);
    }

}
