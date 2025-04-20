package com.desarrollo.evaluacion2.evaluacion2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrollo.evaluacion2.evaluacion2.lib.ConductorTransporteMascota;
import com.desarrollo.evaluacion2.evaluacion2.lib.Pet;
import com.desarrollo.evaluacion2.evaluacion2.lib.PetOwner;
import com.desarrollo.evaluacion2.evaluacion2.lib.Travel;
import com.desarrollo.evaluacion2.evaluacion2.repository.ConductorTransporteMascotaRepository;
import com.desarrollo.evaluacion2.evaluacion2.repository.PetOwnerRepository;
import com.desarrollo.evaluacion2.evaluacion2.repository.PetRepository;
import com.desarrollo.evaluacion2.evaluacion2.repository.TravelRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Service
public class PetTravelService 
{
    @Autowired
    private PetRepository petRepo;

    @Autowired
    private TravelRepository traveRepo;

    @Autowired
    private PetOwnerRepository petOwnerRepo;

    @Autowired
    private ConductorTransporteMascotaRepository conductorRepo;

    public List<Pet> obtenerMascotas()
    {
        log.info("Obteniendo mascotas");
        List<Pet> mascotas = petRepo.findAll();
        return mascotas;
    }

    public Pet obtenerMascota(int idMascota)
    {
        log.info("Obteniendo mascota");
        Pet mascota = petRepo.findById(idMascota).orElse(null);
        return mascota;
    }

    public boolean crearMascota(Pet mascota)
    {
        log.info("Creando mascota");
        if (petRepo.existsById(mascota.getIdMascota())) {
            return false;
        }
        petRepo.save(mascota);
        return true;
    }

    public boolean actualizarMascota(Pet mascota)
    {
        log.info("Actualizando mascota");
        if (!petRepo.existsById(mascota.getIdMascota())) {
            return false;
        }
        Pet mascotaActual = petRepo.findById(mascota.getIdMascota()).orElse(null);
        mascotaActual.setIdOwner(mascota.getIdOwner());
        mascotaActual.setNombreMascota(mascota.getNombreMascota());
        mascotaActual.setRazaMascota(mascota.getRazaMascota());
        mascotaActual.setTipoMascota(mascota.getTipoMascota());
        
        return true;
    }

    public boolean eliminarMascota(int idMascota)
    {
        log.info("Eliminando mascota");
        if (!petRepo.existsById(idMascota)) {
            return false;
        }
        petRepo.deleteById(idMascota);
        return true;
    }

    public List<Travel> obtenerViajes()
    {
        log.info("Obteniendo viajes");
        List<Travel> viajes = traveRepo.findAll();
        return viajes;
    }

    public Travel obtenerViaje(int idViaje)
    {
        log.info("Obteniendo viaje");
        Travel viaje = traveRepo.findById(idViaje).orElse(null);
        return viaje;
    }
    public Travel crearViaje(Travel viaje) 
    {
        log.info("Creando viaje");
        if (traveRepo.existsById(viaje.getIdViaje())) {
            return null;
        }
        traveRepo.save(viaje);
        return viaje;
    }

    public boolean actualizarViaje(Travel viaje)
    {
        log.info("Actualizando viaje");
        if (!traveRepo.existsById(viaje.getIdViaje())) {
            return false;
        }
        Travel viajeActual = traveRepo.findById(viaje.getIdViaje()).orElse(null);
        viajeActual.setIdMascota(viaje.getIdMascota());
        viajeActual.setIdConductor(viaje.getIdConductor());
        viajeActual.setFechaViaje(viaje.getFechaViaje());
        viajeActual.setHoraViaje(viaje.getHoraViaje());
        viajeActual.setLugarRecogida(viaje.getLugarRecogida());
        viajeActual.setLugarDestino(viaje.getLugarDestino());
        viajeActual.setEstadoViaje(viaje.getEstadoViaje());
        viajeActual.setCostoViaje(viaje.getCostoViaje());

        traveRepo.save(viajeActual);
        return true;
    }

    public boolean eliminarViaje(int idViaje)
    {
        log.info("Eliminando viaje");
        if (!traveRepo.existsById(idViaje)) {
            return false;
        }
        traveRepo.deleteById(idViaje);
        return true;  
    }

    public List<PetOwner> obtenerOwners()
    {
        log.info("Obteniendo dueños");
        List<PetOwner> dueños = petOwnerRepo.findAll();
        return dueños;
    }

    public PetOwner obtenerOwner(int idOwner)
    {
        log.info("Obteniendo dueño");
        PetOwner owner = petOwnerRepo.findById(idOwner).orElse(null);
        return owner;
    }

    public boolean crearOwner(PetOwner owner)
    {
        log.info("Creando dueño");
        if (petOwnerRepo.existsById(owner.getIdPropietario())) {
            return false;
        }
        petOwnerRepo.save(owner);
        return true;
    }

    public boolean actualizarOwner(PetOwner owner)
    {
        log.info("Actualizando dueño");
        if (!petOwnerRepo.existsById(owner.getIdPropietario())) {
            return false;
        }
        PetOwner ownerActual = petOwnerRepo.findById(owner.getIdPropietario()).orElse(null);
        ownerActual.setApellidoPropietario(owner.getApellidoPropietario());
        ownerActual.setNombrePropietario(owner.getNombrePropietario());
        ownerActual.setTelefonoPropietario(owner.getTelefonoPropietario());

        petOwnerRepo.save(ownerActual);
        return true;
    }

    public boolean eliminarOwner(int idOwner)
    {
        log.info("Eliminando dueño");
        if (!petOwnerRepo.existsById(idOwner)) {
            return false;
        }
        petOwnerRepo.deleteById(idOwner);
        return true;
    }

    public List<ConductorTransporteMascota> obtenerConductores()
    {
        log.info("Obteniendo conductores");
        List<ConductorTransporteMascota> conductores = conductorRepo.findAll();
        return conductores;  
    }

    public ConductorTransporteMascota obtenerConductor(int idConductor)
    {
        log.info("Obteniendo conductor");
        ConductorTransporteMascota conductor = conductorRepo.findById(idConductor).orElse(null);
        return conductor;
    }

    public boolean crearConductor(ConductorTransporteMascota conductor)
    {
        log.info("Creando conductor");
        if (conductorRepo.existsById(conductor.getIdConductor())) {
            return false;
        }
        conductorRepo.save(conductor);
        return true;
    }

    public boolean actualizarConductor(ConductorTransporteMascota conductor)
    {
        log.info("Actualizando conductor {}", conductor.getIdConductor());
        if (!conductorRepo.existsById(conductor.getIdConductor())) {
            return false;
        }  
        ConductorTransporteMascota conductorActual = conductorRepo.findById(conductor.getIdConductor()).orElse(null);
        conductorActual.setApellidoConductor(conductor.getApellidoConductor());
        conductorActual.setNombreConductor(conductor.getNombreConductor());
        conductorActual.setTelefonoConductor(conductor.getTelefonoConductor());

        conductorRepo.save(conductorActual);
        return true;
    }



   

    
}
