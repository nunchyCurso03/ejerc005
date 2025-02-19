package es.santander.asender.ejerc005.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.asender.ejerc005.model.Persona;

 

@SpringBootTest
public class PersonaRepositoryTest {

    @Autowired
    private PersonaRepository personaRepository;

    private Persona persona;

    @BeforeEach
    public void setUp() {

        persona = new Persona(null, "Nunchy", "Pradanos", 39l);
    }

    @Test
    public void testList() {

        personaRepository.save(persona);

        // Listar
        Iterable<Persona> listaPersonas = personaRepository.findAll();

        // Comprueba que no es nulo y que persona se guardó en la lista
        assertNotNull(listaPersonas);
    }

    @Test
    public void testNoExiste() {
        // ID que no exista
        Optional<Persona> resultado = personaRepository.findById(202L);

        assertTrue(resultado.isEmpty());
    }

    @Test
    public void testLeerUnId() {

        Persona personaALeer = new Persona(null, "Tyler", "Durden", 39l);
        personaRepository.save(personaALeer);

        Optional<Persona> resultado = personaRepository.findById(personaALeer.getId());

        // Comprobamos que  existe
        assertFalse(resultado.isEmpty());
        assertEquals(personaALeer.getId(), resultado.get().getId());
    }

    @Test
    public void testGuardarPersona() {

        Persona personaAGuardar = new Persona(null, "Nunchy", "Pradanos", 39l);

        Persona personaGuardada = personaRepository.save(personaAGuardar);

        assertNotNull(personaGuardada.getId());
        assertEquals(personaAGuardar.getNombre(), personaGuardada.getNombre());
        assertEquals(personaAGuardar.getApellido(), personaGuardada.getApellido());
    }

    @Test
    public void testUpdatePersona() {

        Persona personaAGuardar = new Persona(null, "Severiano", "Ballesteros", 39L);
        Persona personaAModificar = personaRepository.save(personaAGuardar);

        personaAModificar.setNombre("Seve");
        personaAModificar.setApellido("Ballesteros");

        Persona personaActualizada = personaRepository.save(personaAModificar);

        assertEquals("Seve", personaActualizada.getNombre());
        assertEquals("Ballesteros", personaActualizada.getApellido());
    }

    @Test
    public void testBorrarPersona() {

        Persona personaAGuardar = new Persona(null, "Tyler", "Durden", 100L);
        Persona personaGuardada = personaRepository.save(personaAGuardar);

        personaRepository.deleteById(personaGuardada.getId());

        Optional<Persona> personaEliminada = personaRepository.findById(personaGuardada.getId());
        assertFalse(personaEliminada.isPresent());
    }

}
