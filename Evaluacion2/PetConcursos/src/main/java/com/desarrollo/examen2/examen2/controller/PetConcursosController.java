package com.desarrollo.examen2.examen2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.examen2.examen2.lib.Concurso;
import com.desarrollo.examen2.examen2.lib.Pet;
import com.desarrollo.examen2.examen2.lib.PetOwner;
import com.desarrollo.examen2.examen2.lib.ResponseWrapper;
import com.desarrollo.examen2.examen2.service.PetConcursoService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
@RequestMapping("concursos")
public class PetConcursosController {
    @Autowired
    private PetConcursoService petConcursoService;

    @GetMapping("concursos")
    public ResponseEntity<?> getConcursos() {
        log.info("Obteniendo todos los concursos");
        List<Concurso> concursos = petConcursoService.obtenerConcursos();
        if (concursos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron concursos");
        }

        return ResponseEntity.ok(new ResponseWrapper<>("OK", concursos.size(), concursos));
    }

    @GetMapping("/concurso/{idConcurso}")
    public Concurso getConcurso(@PathVariable int idConcurso) {
        log.info("Obteniendo el concurso con id: " + idConcurso);
        return petConcursoService.obtenerConcurso(idConcurso);
    }

    @PostMapping("/concurso")
    public ResponseEntity<ResponseWrapper<Concurso>> addConcurso(@RequestBody Concurso concurso) {
        log.info("Agregando el concurso: " + concurso);
        Concurso nuevoConcurso = petConcursoService.crearConcurso(concurso);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<>("OK", 1, List.of(nuevoConcurso)));
    }

    @PostMapping("/concursos")
    public ResponseEntity<?> addConcursos(@RequestBody List<Concurso> concursos) {
        log.info("Agregando los concursos: " + concursos);
        
        List<Concurso> nuevosConcurso = petConcursoService.crearConcursos(concursos);

        if(nuevosConcurso == null)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                   .body("No se encontraron concursos");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<>("OK", nuevosConcurso.size(), nuevosConcurso));
    }

    @DeleteMapping("/concurso/{idConcurso}")
    public ResponseEntity<?> deleteConcurso(@PathVariable int idConcurso) {
        log.info("Eliminando el concurso con id: " + idConcurso);
        petConcursoService.eliminarConcurso(idConcurso);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Concurso eliminado");
    }

    @PutMapping("/concurso/{idConcurso}")
    public ResponseEntity<?> updateConcurso(@PathVariable int idConcurso, @RequestBody Concurso concurso) {
        log.info("Actualizando el concurso con id: " + idConcurso);
        Concurso concursoActualizado = petConcursoService.actualizarConcurso(idConcurso, concurso);
        return ResponseEntity.ok(new ResponseWrapper<>("OK", 1, List.of(concursoActualizado)));
    }

    @GetMapping("/owners")
    public ResponseEntity<?> getOwners() {
        log.info("Obteniendo todos los dueños");
        List<PetOwner> owners = petConcursoService.obtenerOwners();
        if (owners.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron dueños");
        }
        return ResponseEntity.ok(new ResponseWrapper<>("OK", owners.size(), owners));
    }

    @GetMapping("/owner/{idOwner}")
    public PetOwner getOwner(@PathVariable int idOwner) {
        log.info("Obteniendo el dueño con id: " + idOwner);
        return petConcursoService.obtenerOwner(idOwner);
    }

    @PostMapping("/owner")
    public ResponseEntity<ResponseWrapper<PetOwner>> addOwner(@RequestBody PetOwner owner) {
        log.info("Agregando el dueño: " + owner);
        PetOwner nuevoOwner = petConcursoService.crearOwner(owner);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<>("OK", 1, List.of(nuevoOwner)));
    }

    @DeleteMapping("/owner/{idOwner}")
    public ResponseEntity<?> deleteOwner(@PathVariable int idOwner) {
        log.info("Eliminando el dueño con id: " + idOwner);
        petConcursoService.eliminarOwner(idOwner);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Dueño eliminado");
    }

    @PutMapping("/owner/{idOwner}")
    public ResponseEntity<?> updateOwner(@PathVariable int idOwner, @RequestBody PetOwner owner) {
        log.info("Actualizando el dueño con id: " + idOwner);
        PetOwner ownerActualizado = petConcursoService.actualizarOwner(idOwner, owner);
        return ResponseEntity.ok(new ResponseWrapper<>("OK", 1, List.of(ownerActualizado)));
    }

    @GetMapping("/mascotas")
    public ResponseEntity<?> getMascotas() {
        log.info("Obteniendo todas las mascotas");
        List<Pet> mascotas = petConcursoService.obtenerMascotas();
        if (mascotas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron mascotas");
        }
        return ResponseEntity.ok(new ResponseWrapper<>("OK", mascotas.size(), mascotas));
    }

    @GetMapping("/mascota/{idMascota}")
    public Pet getMascota(@PathVariable int idMascota) {
        log.info("Obteniendo la mascota con id: " + idMascota);
        return petConcursoService.obtenerMascota(idMascota);
    }

    @PostMapping("/mascota")
    public ResponseEntity<ResponseWrapper<Pet>> addMascota(@RequestBody Pet mascota) {
        log.info("Agregando la mascota: " + mascota);
        Pet nuevaMascota = petConcursoService.crearMascota(mascota);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<>("OK", 1, List.of(nuevaMascota)));
    }

    @DeleteMapping("/mascota/{idMascota}")
    public ResponseEntity<?> deleteMascota(@PathVariable int idMascota) {
        log.info("Eliminando la mascota con id: " + idMascota);
        petConcursoService.eliminarMascota(idMascota);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Mascota eliminada");
    }

    @PutMapping("/mascota/{idMascota}")
    public ResponseEntity<?> updateMascota(@PathVariable int idMascota, @RequestBody Pet mascota) {
        log.info("Actualizando la mascota con id: " + idMascota);
        Pet mascotaActualizada = petConcursoService.actualizarMascota(idMascota, mascota);
        return ResponseEntity.ok(new ResponseWrapper<>("OK", 1, List.of(mascotaActualizada)));
    }

    @PostMapping("/owners")
    public ResponseEntity<?> addOwners(@RequestBody List<PetOwner> owners) {
        log.info("Agregando los dueños: " + owners);
        List<PetOwner> ownersCreados = petConcursoService.crearOwners(owners);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<>("OK", ownersCreados.size(), ownersCreados));
    }

    @PostMapping("/mascotas")
    public ResponseEntity<?> addMascotas(@RequestBody List<Pet> mascotas) {
        log.info("Agregando las mascotas: " + mascotas);
        List<Pet> mascotasCreadas = petConcursoService.crearMascotas(mascotas);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<>("OK", mascotasCreadas.size(), mascotasCreadas));
    }

    

}
