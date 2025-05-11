package com.desarrollo.examen2.examen2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.LocalTime;

import com.desarrollo.examen2.examen2.service.PetTravelService;
import com.desarrollo.examen2.examen2.repository.PetRepository;
import com.desarrollo.examen2.examen2.repository.TravelRepository;
import com.desarrollo.examen2.examen2.repository.PetOwnerRepository;
import com.desarrollo.examen2.examen2.exception.TravelNotFoundException;
import com.desarrollo.examen2.examen2.lib.Travel;
import com.desarrollo.examen2.examen2.repository.ConductorTransporteMascotaRepository;

public class PetTravelServiceTest {

    private PetTravelService petTravelService;

    private PetRepository petRepository;
    private TravelRepository travelRepository;
    private PetOwnerRepository petOwnerRepository;
    private ConductorTransporteMascotaRepository conductorTransporteMascotaRepository;

    @BeforeEach
    public void setUp() {
        petRepository = mock(PetRepository.class);
        travelRepository = mock(TravelRepository.class);
        petOwnerRepository = mock(PetOwnerRepository.class);
        conductorTransporteMascotaRepository = mock(ConductorTransporteMascotaRepository.class);
        petTravelService = new PetTravelService(petRepository, travelRepository, petOwnerRepository,
                conductorTransporteMascotaRepository);
    }

    @Test
    public void testObtenerTravels() {
        Travel travel1 = new Travel(1, 1, 1, LocalDate.now(), LocalTime.now(),
                "Santiago", "Valparaíso", "PENDIENTE", 15000.0);
        Travel travel2 = new Travel(2, 2, 1, LocalDate.now(), LocalTime.now(), "Concepción", "Temuco", "EN_PROGRESO",
                25000.0);
        List<Travel> concursosMock = Arrays.asList(travel1, travel2);
        when(travelRepository.findAll()).thenReturn(concursosMock);
        List<Travel> viajes = petTravelService.obtenerViajes();
        assertNotNull(viajes);
        assertEquals(2, viajes.size(), "El numero de viajes es incorrecto");
        assertEquals(travel1, viajes.get(0), "El viaje 1 es incorrecto");
        assertEquals(travel2, viajes.get(1), "El viaje 2 es incorrecto");
    }

    @Test
    public void testObtenerTravelsListaVacia() {
        when(travelRepository.findAll()).thenReturn(new ArrayList<>());
        List<Travel> viajes = petTravelService.obtenerViajes();
        assertNotNull(viajes);
        assertTrue(viajes.isEmpty(), "La lista debería estar vacía");
    }

    @Test
    public void testObtenerTravel() {
        Travel travel = new Travel(1, 1, 1, LocalDate.now(), LocalTime.now(), "Santiago", "Valparaíso", "PENDIENTE", 15000.0);
        when(travelRepository.findById(1)).thenReturn(Optional.of(travel));
        Travel viaje = petTravelService.obtenerViaje(1);
        assertNotNull(viaje);
        assertEquals(travel, viaje);
    }

    @Test
    public void testObtenerTravelNoExistente() {
        when(travelRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(TravelNotFoundException.class, () -> petTravelService.obtenerViaje(1));
    }

    @Test
    public void testCrearTravel() {
        Travel travel = new Travel(1, 1, 1, LocalDate.now(), LocalTime.now(), "Santiago", "Valparaíso", "PENDIENTE", 15000.0);
        when(travelRepository.save(travel)).thenReturn(travel);
        Travel viajeCreado = petTravelService.crearViaje(travel);
        assertNotNull(viajeCreado);
        assertEquals(travel, viajeCreado);
    }

    @Test
    public void testCrearTravelExistente() {
        Travel travel = new Travel(1, 1, 1, LocalDate.now(), LocalTime.now(), "Santiago", "Valparaíso", "PENDIENTE", 15000.0);
        when(travelRepository.existsById(1)).thenReturn(true);
        Travel viajeCreado = petTravelService.crearViaje(travel);
        assertNull(viajeCreado);
    }
}