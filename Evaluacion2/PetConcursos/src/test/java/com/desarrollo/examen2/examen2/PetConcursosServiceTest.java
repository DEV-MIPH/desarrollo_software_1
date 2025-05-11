package com.desarrollo.examen2.examen2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.desarrollo.examen2.examen2.lib.Concurso;
import com.desarrollo.examen2.examen2.repository.ConcursoRepository;
import com.desarrollo.examen2.examen2.repository.PetOwnerRepository;
import com.desarrollo.examen2.examen2.repository.PetRepository;
import com.desarrollo.examen2.examen2.service.PetConcursoService;

public class PetConcursosServiceTest {

    private PetConcursoService petConcursoService;

    private PetRepository petRepo;
    private PetOwnerRepository petOwnerRepo;
    private ConcursoRepository concursoRepository;

    @BeforeEach
    public void setUp() {
        concursoRepository = mock(ConcursoRepository.class);
        petRepo = mock(PetRepository.class);
        petOwnerRepo = mock(PetOwnerRepository.class);
        petConcursoService = new PetConcursoService(concursoRepository, petRepo, petOwnerRepo);
    }

    @Test
    public void testObtenerConcursos() {
        Concurso concurso1 = new Concurso();
        concurso1.setId(1);
        concurso1.setIdMascota(1);
        concurso1.setIdPropietario(1);
        concurso1.setPrecio(1000);
        concurso1.setNombre("Concurso 1");
        concurso1.setDescripcion("Descripción del concurso 1");
        concurso1.setFecha("2023-01-01");
        concurso1.setUbicacion("Ubicación 1");
        concurso1.setEstado("Activo");

        Concurso concurso2 = new Concurso();
        concurso2.setId(2);
        concurso2.setIdMascota(2);
        concurso2.setIdPropietario(2);
        concurso2.setPrecio(2000);
        concurso2.setNombre("Concurso 2");
        concurso2.setDescripcion("Descripción del concurso 2");
        concurso2.setFecha("2023-02-01");
        concurso2.setUbicacion("Ubicación 2");
        concurso2.setEstado("Inactivo");
        List<Concurso> concursosMock = Arrays.asList(concurso1, concurso2);
        when(concursoRepository.findAll()).thenReturn(concursosMock);
        List<Concurso> concursos = petConcursoService.obtenerConcursos();
        assertEquals(2, concursos.size(), "Debería devolver exactamente 2 concursos");
        assertEquals("Concurso 1", concursos.get(0).getNombre());
        assertEquals("Concurso 2", concursos.get(1).getNombre());
    }
    
    @Test
    public void testObtenerConcursoPorId() {
        Concurso concurso = new Concurso();
        concurso.setId(1);
        concurso.setIdMascota(1);
        concurso.setIdPropietario(1);
        concurso.setPrecio(1000);
        concurso.setNombre("Concurso Test");
        concurso.setDescripcion("Descripción del concurso test");
        concurso.setFecha("2023-01-01");
        concurso.setUbicacion("Ubicación Test");
        concurso.setEstado("Activo");
        
        when(concursoRepository.findById(1)).thenReturn(java.util.Optional.of(concurso));
        
        Concurso resultado = petConcursoService.obtenerConcurso(1);
        
        assertNotNull(resultado, "El concurso no debería ser nulo");
        assertEquals(1, resultado.getId(), "El ID del concurso debería ser 1");
        assertEquals("Concurso Test", resultado.getNombre(), "El nombre del concurso no coincide");
    }
    
    @Test
    public void testCrearConcurso() {
        Concurso concursoNuevo = new Concurso();
        concursoNuevo.setIdMascota(3);
        concursoNuevo.setIdPropietario(3);
        concursoNuevo.setPrecio(3000);
        concursoNuevo.setNombre("Concurso Nuevo");
        concursoNuevo.setDescripcion("Descripción del concurso nuevo");
        concursoNuevo.setFecha("2023-03-01");
        concursoNuevo.setUbicacion("Ubicación Nueva");
        concursoNuevo.setEstado("Activo");
        
        Concurso concursoGuardado = new Concurso();
        concursoGuardado.setId(3);
        concursoGuardado.setIdMascota(3);
        concursoGuardado.setIdPropietario(3);
        concursoGuardado.setPrecio(3000);
        concursoGuardado.setNombre("Concurso Nuevo");
        concursoGuardado.setDescripcion("Descripción del concurso nuevo");
        concursoGuardado.setFecha("2023-03-01");
        concursoGuardado.setUbicacion("Ubicación Nueva");
        concursoGuardado.setEstado("Activo");
        
        when(petRepo.existsById(3)).thenReturn(true);
        when(petOwnerRepo.existsById(3)).thenReturn(true);
        when(concursoRepository.existsById(3)).thenReturn(false);
        when(concursoRepository.save(any(Concurso.class))).thenReturn(concursoGuardado);
        
        Concurso resultado = petConcursoService.crearConcurso(concursoNuevo);
        
        assertNotNull(resultado, "El concurso creado no debería ser nulo");
        assertEquals(3, resultado.getId(), "El ID del concurso debería ser 3");
        assertEquals("Concurso Nuevo", resultado.getNombre(), "El nombre del concurso no coincide");
    }
    
    @Test
    public void testActualizarConcurso() {
        Concurso concursoExistente = new Concurso();
        concursoExistente.setId(1);
        concursoExistente.setIdMascota(1);
        concursoExistente.setIdPropietario(1);
        concursoExistente.setPrecio(1000);
        concursoExistente.setNombre("Concurso Original");
        concursoExistente.setDescripcion("Descripción original");
        concursoExistente.setFecha("2023-01-01");
        concursoExistente.setUbicacion("Ubicación Original");
        concursoExistente.setEstado("Activo");
        
        Concurso concursoActualizado = new Concurso();
        concursoActualizado.setId(1);
        concursoActualizado.setIdMascota(1);
        concursoActualizado.setIdPropietario(1);
        concursoActualizado.setPrecio(1500);
        concursoActualizado.setNombre("Concurso Actualizado");
        concursoActualizado.setDescripcion("Descripción actualizada");
        concursoActualizado.setFecha("2023-01-15");
        concursoActualizado.setUbicacion("Ubicación Actualizada");
        concursoActualizado.setEstado("Activo");
        
        when(concursoRepository.existsById(1)).thenReturn(true);
        when(concursoRepository.findById(1)).thenReturn(java.util.Optional.of(concursoExistente));
        when(concursoRepository.save(any(Concurso.class))).thenReturn(concursoActualizado);
        
        Concurso resultado = petConcursoService.actualizarConcurso(1, concursoActualizado);
        
        assertNotNull(resultado, "El concurso actualizado no debería ser nulo");
        assertEquals("Concurso Actualizado", resultado.getNombre(), "El nombre actualizado no coincide");
        assertEquals(1500, resultado.getPrecio(), "El precio actualizado no coincide");
    }
    
    @Test
    public void testEliminarConcurso() {
        when(concursoRepository.existsById(1)).thenReturn(true);
        doNothing().when(concursoRepository).deleteById(1);
        
        boolean resultado = petConcursoService.eliminarConcurso(1);
        
        assertTrue(resultado, "La eliminación debería ser exitosa");
    }
    
}
