package com.desarrollo.evaluacion2.evaluacion2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.evaluacion2.evaluacion2.lib.ConductorTransporteMascota;
import com.desarrollo.evaluacion2.evaluacion2.lib.Pet;
import com.desarrollo.evaluacion2.evaluacion2.lib.PetOwner;
import com.desarrollo.evaluacion2.evaluacion2.lib.ResponseWrapper;
import com.desarrollo.evaluacion2.evaluacion2.lib.Travel;
import com.desarrollo.evaluacion2.evaluacion2.service.PetTravelService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j 
@RestController
@RequestMapping("viajes")
public class PetTravelController 
{
    @Autowired
    private PetTravelService petTravelService;


    @GetMapping("/viajes")
    public ResponseEntity<?> getViajes() 
    {
        log.info("Obteniendo todos los viajes");
        List<Travel> viajes = petTravelService.obtenerViajes();
        if(viajes.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No se encontraron viajes");
        }

        return ResponseEntity.ok(new ResponseWrapper<>("OK", viajes.size(), viajes));
    }

    @GetMapping("/viaje/{idViaje}")
    public Travel getViaje(@PathVariable int idViaje) 
    {
        log.info("Obteniendo el viaje con id: " + idViaje);
        return petTravelService.obtenerViaje(idViaje);
    }

    @PostMapping("/viaje")
    public ResponseEntity<ResponseWrapper<Travel>> addViaje(@RequestBody Travel viaje)
    {
        log.info("Agregando el viaje: " + viaje);
        Travel nuevoViaje = petTravelService.crearViaje(viaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<>("OK", 1, List.of(nuevoViaje)));
    }

    @DeleteMapping("/viaje/{idViaje}")
    public ResponseEntity<?> deleteViaje(@PathVariable int idViaje)
    {
        log.info("Eliminando el viaje con id: " + idViaje);
        petTravelService.eliminarViaje(idViaje);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Viaje eliminado");
    }

    

}
