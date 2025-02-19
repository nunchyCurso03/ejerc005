package es.santander.asender.ejerc005.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAIS")
public class Pais {
    
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

     
    private  String nombre;
    private String descripcion;
    private String continente;

    
    public Pais() {
    }


    public Pais(Long id, String nombre, String descripcion, String continente) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.continente = continente;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getContinente() {
        return continente;
    }


    public void setContinente(String continente) {
        this.continente = continente;
    }

    

}
