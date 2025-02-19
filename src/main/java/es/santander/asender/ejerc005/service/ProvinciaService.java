package es.santander.asender.ejerc005.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.santander.asender.ejerc005.model.Provincia;
import es.santander.asender.ejerc005.repository.ProvinciaRepository;
 

 

    @Service
public class ProvinciaService {

    @Autowired
    private ProvinciaRepository repository;

    

    // CREATE
    public Provincia create(Provincia provincia) {

        if (provincia.getId() != null) {
            throw new CrudSecurityException("Han tratado de modificar un registro provincia",
                    CRUDOperation.CREATE,
                    provincia.getId());
        } else {
            return repository.save(provincia);
        }

    }

    // Leer uno
    public Provincia read(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Listar
    public List<Provincia> list() {
        return repository.findAll();
    }

    // UPDATE
    public Provincia update(Provincia provincia) {
        if (provincia.getId() == null) {
            throw new CrudSecurityException("Han tratado de crear un registro provincia utilizando modificar",
                    CRUDOperation.UPDATE,
                    null);
        }
        return repository.save(provincia);
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }

}

 
