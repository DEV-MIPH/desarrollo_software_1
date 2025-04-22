package com.desarrollo.evaluacion2.evaluacion2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrollo.evaluacion2.evaluacion2.lib.Concurso;
import com.desarrollo.evaluacion2.evaluacion2.lib.Pet;
import com.desarrollo.evaluacion2.evaluacion2.lib.PetOwner;
import com.desarrollo.evaluacion2.evaluacion2.repository.ConcursoRepository;
import com.desarrollo.evaluacion2.evaluacion2.repository.PetOwnerRepository;
import com.desarrollo.evaluacion2.evaluacion2.repository.PetRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PetConcursoService {
    @Autowired
    private PetRepository petRepo;

    @Autowired
    private ConcursoRepository concursoRepository;

    @Autowired
    private PetOwnerRepository petOwnerRepo;

    public List<Pet> obtenerMascotas() {
        log.info("Obteniendo mascotas");
        List<Pet> mascotas = petRepo.findAll();
        return mascotas;
    }

    public Pet obtenerMascota(int idMascota) {
        log.info("Obteniendo mascota");
        Pet mascota = petRepo.findById(idMascota).orElse(null);
        return mascota;
    }

    public Pet crearMascota(Pet mascota) {
        log.info("Creando mascota");
        if (petRepo.existsById(mascota.getIdMascota())) {
            return null;
        }
        return petRepo.save(mascota);
    }

    public Pet actualizarMascota(int idPet, Pet mascota) {
        log.info("Actualizando mascota");
        if (!petRepo.existsById(idPet)) {
            return null;
        }
        Pet mascotaActual = petRepo.findById(idPet).orElse(null);
        mascotaActual.setIdOwner(mascota.getIdOwner());
        mascotaActual.setNombreMascota(mascota.getNombreMascota());
        mascotaActual.setRazaMascota(mascota.getRazaMascota());
        mascotaActual.setTipoMascota(mascota.getTipoMascota());
        return petRepo.save(mascotaActual);
    }

    public boolean eliminarMascota(int idMascota) {
        log.info("Eliminando mascota");
        if (!petRepo.existsById(idMascota)) {
            return false;
        }
        petRepo.deleteById(idMascota);
        return true;
    }

    public List<Concurso> obtenerConcursos() {
        log.info("Obteniendo concursos");
        List<Concurso> concursos = concursoRepository.findAll();
        return concursos;
    }

    public Concurso obtenerConcurso(int idConcurso) {
        log.info("Obteniendo Concurso");
        Concurso Concurso = concursoRepository.findById(idConcurso).orElse(null);
        return Concurso;
    }

    public Concurso crearConcurso(Concurso concurso) {
        log.info("Creando Concurso");
        if (concursoRepository.existsById(concurso.getId())) {
            return null;
        }

        if(!petRepo.existsById(concurso.getIdMascota())){
            log.info("Mascota no existe");
            return null;
        }

        if(!petOwnerRepo.existsById(concurso.getIdPropietario()))
        {
            log.info("No existe propietario");
            return null;
        }

        return concursoRepository.save(concurso);
    }
    public List<Concurso> crearConcursos(List<Concurso> concursos) {
        log.info("Creando concursos");
        List<Concurso> concursosCreados = new ArrayList<>();
        
        for (Concurso concurso : concursos) {
            if (!concursoRepository.existsById(concurso.getId()) && 
                    petOwnerRepo.existsById(concurso.getIdPropietario()) &&
                    petRepo.existsById(concurso.getIdMascota()))
                {
                    concursosCreados.add(concursoRepository.save(concurso));
                }
            else{
                log.error("Error al crear concursos");
                return null;
            }
        }
        return concursosCreados;
    }

    public List<Pet> crearMascotas(List<Pet> mascotas) {
        log.info("Creando mascotas");
        List<Pet> mascotasCreadas = new ArrayList<>();
        
        for (Pet mascota : mascotas) {
            if (!petRepo.existsById(mascota.getIdMascota())) {
                mascotasCreadas.add(petRepo.save(mascota));
            }
        }
        return mascotasCreadas;
    }

    public List<PetOwner> crearOwners(List<PetOwner> owners) {
        log.info("Creando propietarios");
        List<PetOwner> ownersCreados = new ArrayList<>();
        
        for (PetOwner owner : owners) {
            if (!petOwnerRepo.existsById(owner.getIdPropietario())) {
                ownersCreados.add(petOwnerRepo.save(owner));
            }
        }
        return ownersCreados;
    }

    public Concurso actualizarConcurso(int idConcurso, Concurso Concurso) {
        log.info("Actualizando Concurso");
        if (!concursoRepository.existsById(idConcurso)) {
            return null;
        }
        Concurso concursoActual = concursoRepository.findById(Concurso.getId()).orElse(null);
        
        concursoActual.setIdMascota(Concurso.getIdMascota());
        concursoActual.setPrecio(Concurso.getPrecio());
        concursoActual.setNombre(Concurso.getNombre());
        concursoActual.setDescripcion(Concurso.getDescripcion());
        concursoActual.setFecha(Concurso.getFecha());
        concursoActual.setUbicacion(Concurso.getUbicacion());
        concursoActual.setEstado(Concurso.getEstado());
        
        return concursoRepository.save(concursoActual);
    }

    public boolean eliminarConcurso(int idConcurso) {
        log.info("Eliminando Concurso");
        if (!concursoRepository.existsById(idConcurso)) {
            return false;
        }
        concursoRepository.deleteById(idConcurso);
        return true;
    }

    public List<PetOwner> obtenerOwners() {
        log.info("Obteniendo dueños");
        List<PetOwner> dueños = petOwnerRepo.findAll();
        return dueños;
    }

    public PetOwner obtenerOwner(int idOwner) {
        log.info("Obteniendo dueño");
        PetOwner owner = petOwnerRepo.findById(idOwner).orElse(null);
        return owner;
    }

    public PetOwner crearOwner(PetOwner owner) {
        log.info("Creando dueño");
        if (petOwnerRepo.existsById(owner.getIdPropietario())) {
            return null;
        }
        return petOwnerRepo.save(owner);
    }

    public PetOwner actualizarOwner(int idOwner, PetOwner owner) {
        log.info("Actualizando dueño");
        if (!petOwnerRepo.existsById(idOwner)) {
            return null;
        }
        PetOwner ownerActual = petOwnerRepo.findById(owner.getIdPropietario()).orElse(null);
        ownerActual.setApellidoPropietario(owner.getApellidoPropietario());
        ownerActual.setNombrePropietario(owner.getNombrePropietario());
        ownerActual.setTelefonoPropietario(owner.getTelefonoPropietario());

        return petOwnerRepo.save(ownerActual);
    }

    public boolean eliminarOwner(int idOwner) {
        log.info("Eliminando dueño");
        if (!petOwnerRepo.existsById(idOwner)) {
            return false;
        }
        petOwnerRepo.deleteById(idOwner);
        return true;
    }

}
