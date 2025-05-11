package com.desarrollo.examen2.examen2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrollo.examen2.examen2.lib.ConductorTransporteMascota;
import com.desarrollo.examen2.examen2.lib.Pet;
import com.desarrollo.examen2.examen2.lib.PetOwner;
import com.desarrollo.examen2.examen2.lib.Travel;
import com.desarrollo.examen2.examen2.repository.ConductorTransporteMascotaRepository;
import com.desarrollo.examen2.examen2.repository.PetOwnerRepository;
import com.desarrollo.examen2.examen2.repository.PetRepository;
import com.desarrollo.examen2.examen2.repository.TravelRepository;
import com.desarrollo.examen2.examen2.exception.PetNotFoundException;
import com.desarrollo.examen2.examen2.exception.TravelNotFoundException;
import com.desarrollo.examen2.examen2.exception.ConductorNotFoundException;
import com.desarrollo.examen2.examen2.exception.OwnerNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PetTravelService {
    @Autowired
    private PetRepository petRepo;

    @Autowired
    private TravelRepository traveRepo;

    @Autowired
    private PetOwnerRepository petOwnerRepo;

    @Autowired
    private ConductorTransporteMascotaRepository conductorRepo;

    public PetTravelService(PetRepository petRepo, TravelRepository traveRepo, PetOwnerRepository petOwnerRepo, ConductorTransporteMascotaRepository conductorRepo) {
        this.petRepo = petRepo;
        this.traveRepo = traveRepo;
        this.petOwnerRepo = petOwnerRepo;
        this.conductorRepo = conductorRepo;
    }

    public List<Pet> obtenerMascotas() {
        log.info("Obteniendo mascotas");
        List<Pet> mascotas = petRepo.findAll();
        return mascotas;
    }

    public Pet obtenerMascota(int idMascota) {
        log.info("Obteniendo mascota");
        return petRepo.findById(idMascota)
            .orElseThrow(() -> new PetNotFoundException(idMascota));
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
        Pet mascotaActual = petRepo.findById(idPet)
            .orElseThrow(() -> new PetNotFoundException(idPet));
        mascotaActual.setIdOwner(mascota.getIdOwner());
        mascotaActual.setNombreMascota(mascota.getNombreMascota());
        mascotaActual.setRazaMascota(mascota.getRazaMascota());
        mascotaActual.setTipoMascota(mascota.getTipoMascota());
        return petRepo.save(mascotaActual);
    }

    public boolean eliminarMascota(int idMascota) {
        log.info("Eliminando mascota");
        if (!petRepo.existsById(idMascota)) {
            throw new PetNotFoundException(idMascota);
        }
        petRepo.deleteById(idMascota);
        return true;
    }

    public List<Travel> obtenerViajes() {
        log.info("Obteniendo viajes");
        List<Travel> viajes = traveRepo.findAll();
        return viajes;
    }

    public Travel obtenerViaje(int idViaje) {
        log.info("Obteniendo viaje");
        return traveRepo.findById(idViaje)
            .orElseThrow(() -> new TravelNotFoundException(idViaje));
    }

    public Travel crearViaje(Travel viaje) {
        log.info("Creando viaje");
        if (traveRepo.existsById(viaje.getId())) {
            return null;
        }
        traveRepo.save(viaje);
        return viaje;
    }
    public List<Travel> crearViajes(List<Travel> viajes) {
        log.info("Creando viajes");
        List<Travel> viajesCreados = new ArrayList<>();
        
        for (Travel viaje : viajes) {
            if (!traveRepo.existsById(viaje.getId())) {
                viajesCreados.add(traveRepo.save(viaje));
            }
        }
        return viajesCreados;
    }

    public List<Pet> crearMascotas(List<Pet> mascotas) {
        log.info("Creando pets");
        List<Pet> mascotasCreadas = new ArrayList<>();
        
        for (Pet mascota : mascotas) {
            if (!petRepo.existsById(mascota.getIdMascota())) {
                mascotasCreadas.add(petRepo.save(mascota));
            }
        }
        return mascotasCreadas;
    }

    public List<PetOwner> crearOwners(List<PetOwner> owners) {
        log.info("Creando nuevos owners");
        List<PetOwner> ownersCreados = new ArrayList<>();
        
        for (PetOwner owner : owners) {
            if (!petOwnerRepo.existsById(owner.getIdPropietario())) {
                ownersCreados.add(petOwnerRepo.save(owner));
            }
        }
        return ownersCreados;
    }

    public List<ConductorTransporteMascota> crearConductores(List<ConductorTransporteMascota> conductores) {
        log.info("Creando conductores");
        List<ConductorTransporteMascota> conductoresCreados = new ArrayList<>();
        
        for (ConductorTransporteMascota conductor : conductores) {
            if (!conductorRepo.existsById(conductor.getIdConductor())) {
                conductoresCreados.add(conductorRepo.save(conductor));
            }
        }
        return conductoresCreados;
    }

    public Travel actualizarViaje(int idViaje, Travel viaje) {
        log.info("Actualizando viaje");
        Travel viajeActual = traveRepo.findById(idViaje)
            .orElseThrow(() -> new TravelNotFoundException(idViaje));
        viajeActual.setIdMascota(viaje.getIdMascota());
        viajeActual.setIdConductor(viaje.getIdConductor());
        viajeActual.setFechaViaje(viaje.getFechaViaje());
        viajeActual.setHoraViaje(viaje.getHoraViaje());
        viajeActual.setLugarRecogida(viaje.getLugarRecogida());
        viajeActual.setLugarDestino(viaje.getLugarDestino());
        viajeActual.setEstadoViaje(viaje.getEstadoViaje());
        viajeActual.setCostoViaje(viaje.getCostoViaje());

        return traveRepo.save(viajeActual);
    }

    public boolean eliminarViaje(int idViaje) {
        log.info("Eliminando viaje");
        if (!traveRepo.existsById(idViaje)) {
            throw new TravelNotFoundException(idViaje);
        }
        traveRepo.deleteById(idViaje);
        return true;
    }

    public List<PetOwner> obtenerOwners() {
        log.info("Obteniendo dueños");
        List<PetOwner> dueños = petOwnerRepo.findAll();
        return dueños;
    }

    public PetOwner obtenerOwner(int idOwner) {
        log.info("Obteniendo dueño");
        return petOwnerRepo.findById(idOwner)
            .orElseThrow(() -> new OwnerNotFoundException(idOwner));
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
        PetOwner ownerActual = petOwnerRepo.findById(idOwner)
            .orElseThrow(() -> new OwnerNotFoundException(idOwner));
        ownerActual.setApellidoPropietario(owner.getApellidoPropietario());
        ownerActual.setNombrePropietario(owner.getNombrePropietario());
        ownerActual.setTelefonoPropietario(owner.getTelefonoPropietario());

        return petOwnerRepo.save(ownerActual);
    }

    public boolean eliminarOwner(int idOwner) {
        log.info("Eliminando dueño");
        if (!petOwnerRepo.existsById(idOwner)) {
            throw new OwnerNotFoundException(idOwner);
        }
        petOwnerRepo.deleteById(idOwner);
        return true;
    }

    public List<ConductorTransporteMascota> obtenerConductores() {
        log.info("Obteniendo conductores");
        List<ConductorTransporteMascota> conductores = conductorRepo.findAll();
        return conductores;
    }

    public ConductorTransporteMascota obtenerConductor(int idConductor) {
        log.info("Obteniendo conductor");
        return conductorRepo.findById(idConductor)
            .orElseThrow(() -> new ConductorNotFoundException(idConductor));
    }

    public ConductorTransporteMascota crearConductor(ConductorTransporteMascota conductor) {
        log.info("Creando conductor");
        if (conductorRepo.existsById(conductor.getIdConductor())) {
            return null;
        }
        return conductorRepo.save(conductor);
    }

    public boolean eliminarConductor(int idConductor) {
        log.info("Eliminando conductor");
        if (!conductorRepo.existsById(idConductor)) {
            throw new ConductorNotFoundException(idConductor);
        }
        conductorRepo.deleteById(idConductor);
        return true;
    }

    public ConductorTransporteMascota actualizarConductor(int idConductor, ConductorTransporteMascota conductor) {
        log.info("Actualizando conductor {}", idConductor);
        ConductorTransporteMascota conductorActual = conductorRepo.findById(idConductor)
            .orElseThrow(() -> new ConductorNotFoundException(idConductor));
        conductorActual.setApellidoConductor(conductor.getApellidoConductor());
        conductorActual.setNombreConductor(conductor.getNombreConductor());
        conductorActual.setTelefonoConductor(conductor.getTelefonoConductor());
        
        return conductorRepo.save(conductorActual);
    }

}
