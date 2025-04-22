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
import oracle.jdbc.proxy.annotation.Post;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
@RequestMapping("viajes")
public class PetTravelController {
    @Autowired
    private PetTravelService petTravelService;

    @GetMapping("")
    public ResponseEntity<?> getViajes() {
        log.info("Obteniendo todos los viajes");
        List<Travel> viajes = petTravelService.obtenerViajes();
        if (viajes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron viajes");
        }

        return ResponseEntity.ok(new ResponseWrapper<>("OK", viajes.size(), viajes));
    }

    @GetMapping("/viaje/{idViaje}")
    public Travel getViaje(@PathVariable int idViaje) {
        log.info("Obteniendo el viaje con id: " + idViaje);
        return petTravelService.obtenerViaje(idViaje);
    }

    @PostMapping("/viaje")
    public ResponseEntity<ResponseWrapper<Travel>> addViaje(@RequestBody Travel viaje) {
        log.info("Agregando el viaje: " + viaje);
        Travel nuevoViaje = petTravelService.crearViaje(viaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<>("OK", 1, List.of(nuevoViaje)));
    }

    @PostMapping("/viajes")
    public ResponseEntity<?> addViajes(@RequestBody List<Travel> viajes) {
        log.info("Agregando los viajes: " + viajes);
        List<Travel> nuevosViajes = petTravelService.crearViajes(viajes);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<>("OK", nuevosViajes.size(), nuevosViajes));
    }

    @DeleteMapping("/viaje/{idViaje}")
    public ResponseEntity<?> deleteViaje(@PathVariable int idViaje) {
        log.info("Eliminando el viaje con id: " + idViaje);
        petTravelService.eliminarViaje(idViaje);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Viaje eliminado");
    }

    @PutMapping("/viaje/{idViaje}")
    public ResponseEntity<?> updateViaje(@PathVariable int idViaje, @RequestBody Travel viaje) {
        log.info("Actualizando el viaje con id: " + idViaje);
        Travel viajeActualizado = petTravelService.actualizarViaje(idViaje, viaje);
        return ResponseEntity.ok(new ResponseWrapper<>("OK", 1, List.of(viajeActualizado)));
    }

    @GetMapping("/owners")
    public ResponseEntity<?> getOwners() {
        log.info("Obteniendo todos los dueños");
        List<PetOwner> owners = petTravelService.obtenerOwners();
        if (owners.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron dueños");
        }
        return ResponseEntity.ok(new ResponseWrapper<>("OK", owners.size(), owners));
    }

    @GetMapping("/owner/{idOwner}")
    public PetOwner getOwner(@PathVariable int idOwner) {
        log.info("Obteniendo el dueño con id: " + idOwner);
        return petTravelService.obtenerOwner(idOwner);
    }

    @PostMapping("/owner")
    public ResponseEntity<ResponseWrapper<PetOwner>> addOwner(@RequestBody PetOwner owner) {
        log.info("Agregando el dueño: " + owner);
        PetOwner nuevoOwner = petTravelService.crearOwner(owner);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<>("OK", 1, List.of(nuevoOwner)));
    }

    @DeleteMapping("/owner/{idOwner}")
    public ResponseEntity<?> deleteOwner(@PathVariable int idOwner) {
        log.info("Eliminando el dueño con id: " + idOwner);
        petTravelService.eliminarOwner(idOwner);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Dueño eliminado");
    }

    @PutMapping("/owner/{idOwner}")
    public ResponseEntity<?> updateOwner(@PathVariable int idOwner, @RequestBody PetOwner owner) {
        log.info("Actualizando el dueño con id: " + idOwner);
        PetOwner ownerActualizado = petTravelService.actualizarOwner(idOwner, owner);
        return ResponseEntity.ok(new ResponseWrapper<>("OK", 1, List.of(ownerActualizado)));
    }

    @GetMapping("/mascotas")
    public ResponseEntity<?> getMascotas() {
        log.info("Obteniendo todas las mascotas");
        List<Pet> mascotas = petTravelService.obtenerMascotas();
        if (mascotas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron mascotas");
        }
        return ResponseEntity.ok(new ResponseWrapper<>("OK", mascotas.size(), mascotas));
    }

    @GetMapping("/mascota/{idMascota}")
    public Pet getMascota(@PathVariable int idMascota) {
        log.info("Obteniendo la mascota con id: " + idMascota);
        return petTravelService.obtenerMascota(idMascota);
    }

    @PostMapping("/mascota")
    public ResponseEntity<ResponseWrapper<Pet>> addMascota(@RequestBody Pet mascota) {
        log.info("Agregando la mascota: " + mascota);
        Pet nuevaMascota = petTravelService.crearMascota(mascota);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<>("OK", 1, List.of(nuevaMascota)));
    }

    @DeleteMapping("/mascota/{idMascota}")
    public ResponseEntity<?> deleteMascota(@PathVariable int idMascota) {
        log.info("Eliminando la mascota con id: " + idMascota);
        petTravelService.eliminarMascota(idMascota);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Mascota eliminada");
    }

    @PutMapping("/mascota/{idMascota}")
    public ResponseEntity<?> updateMascota(@PathVariable int idMascota, @RequestBody Pet mascota) {
        log.info("Actualizando la mascota con id: " + idMascota);
        Pet mascotaActualizada = petTravelService.actualizarMascota(idMascota, mascota);
        return ResponseEntity.ok(new ResponseWrapper<>("OK", 1, List.of(mascotaActualizada)));
    }

    @GetMapping("/conductores")
    public ResponseEntity<?> getConductores() {
        log.info("Obteniendo todos los conductores");
        List<ConductorTransporteMascota> conductores = petTravelService.obtenerConductores();
        if (conductores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron conductores");
        }
        return ResponseEntity.ok(new ResponseWrapper<>("OK", conductores.size(), conductores));
    }

    @GetMapping("/conductor/{idConductor}")
    public ConductorTransporteMascota getConductor(@PathVariable int idConductor) {
        log.info("Obteniendo el conductor con id: " + idConductor);
        return petTravelService.obtenerConductor(idConductor);
    }

    @PostMapping("/conductor")
    public ResponseEntity<ResponseWrapper<ConductorTransporteMascota>> addConductor(
            @RequestBody ConductorTransporteMascota conductor) {
        log.info("Agregando el conductor: " + conductor);
        ConductorTransporteMascota nuevoConductor = petTravelService.crearConductor(conductor);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<>("OK", 1, List.of(nuevoConductor)));
    }

    @DeleteMapping("/conductor/{idConductor}")
    public ResponseEntity<?> deleteConductor(@PathVariable int idConductor) {
        log.info("Eliminando el conductor con id: " + idConductor);
        if (petTravelService.eliminarConductor(idConductor) == false) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el conductor");
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Conductor eliminado");
    }

    @PutMapping("/conductor/{idConductor}")
    public ResponseEntity<?> updateConductor(@PathVariable int idConductor,
            @RequestBody ConductorTransporteMascota conductor) {
        log.info("Actualizando el conductor con id: " + idConductor);
        ConductorTransporteMascota conductorActualizado = petTravelService.actualizarConductor(idConductor, conductor);
        return ResponseEntity.ok(new ResponseWrapper<>("OK", 1, List.of(conductorActualizado)));
    }

    @PostMapping("/conductores")
    public ResponseEntity<?> addConductores(@RequestBody List<ConductorTransporteMascota> conductores) {
        log.info("Agregando los conductores: " + conductores);
        List<ConductorTransporteMascota> conductoresCreados = petTravelService.crearConductores(conductores);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<>("OK", conductoresCreados.size(), conductoresCreados));
    }

    @PostMapping("/owners")
    public ResponseEntity<?> addOwners(@RequestBody List<PetOwner> owners) {
        log.info("Agregando los dueños: " + owners);
        List<PetOwner> ownersCreados = petTravelService.crearOwners(owners);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<>("OK", ownersCreados.size(), ownersCreados));
    }

    @PostMapping("/mascotas")
    public ResponseEntity<?> addMascotas(@RequestBody List<Pet> mascotas) {
        log.info("Agregando las mascotas: " + mascotas);
        List<Pet> mascotasCreadas = petTravelService.crearMascotas(mascotas);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<>("OK", mascotasCreadas.size(), mascotasCreadas));
    }

    

}
