package es.santander.asender.ejerc005.model;

import jakarta.persistence.Entity;
 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 
import jakarta.persistence.Table;

@Entity
@Table(name = "PERSONA")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    private String apellido;
 
    private Long provincia_id;

    // Constructores
    public Persona() {}

   

    public Persona(Long id, String nombre, String apellido, Long provincia_id) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.provincia_id = provincia_id;
    }



    // Getters y Setters
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }



    public Long getProvincia_id() {
        return provincia_id;
    }



    public void setProvincia_id(Long provincia_id) {
        this.provincia_id = provincia_id;
    }

    
}
