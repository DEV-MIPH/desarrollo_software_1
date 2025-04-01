package com.desarrollo.evaluacion1.evaluacion1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.evaluacion1.evaluacion1.lib.ConductorTransporteMascota;
import com.desarrollo.evaluacion1.evaluacion1.lib.Pet;
import com.desarrollo.evaluacion1.evaluacion1.lib.PetOwner;
import com.desarrollo.evaluacion1.evaluacion1.lib.Travel;
import com.desarrollo.evaluacion1.evaluacion1.service.PetTravelService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("viajes")
public class PetTravelController 
{
    @Autowired
    private PetTravelService petTravelService;


    @GetMapping("/viajes")
    public List<Travel> getViajes() 
    {
        return petTravelService.getViajes();
    }

    @GetMapping("/viaje/{idViaje}")
    public Travel getViaje(@PathVariable int idViaje) 
    {
        return petTravelService.getViaje(idViaje);
    }

    @GetMapping("/mascotas")
    public List<Pet> getViajesMascotas() 
    {
        return petTravelService.getMascotas();
    }

    @GetMapping("/mascota/{idMascota}")
    public Pet getMascota(@PathVariable int idMascota) 
    {
        return petTravelService.getMascota(idMascota);
    }

    @GetMapping("/propietarios")
    public List<PetOwner> getPropietarios() 
    {
        return petTravelService.getPetOwners();
    }

    @GetMapping("/propietario/{idPropietario}")
    public PetOwner getPropietario(@PathVariable int idPropietario) 
    {
        return petTravelService.getPropietario(idPropietario);
    }

    @GetMapping("/conductores")
    public List<ConductorTransporteMascota> getConductores() 
    {
        return petTravelService.getConductores();
    }

    @GetMapping("/conductor/{idConductor}")
    public ConductorTransporteMascota getConductor(@PathVariable int idConductor) 
    {
        return petTravelService.getConductor(idConductor);
    }

    @PostMapping("viaje")
    public boolean crearViaje(@RequestBody Travel viaje) 
    {
        return petTravelService.crearViaje(viaje);
    }

    @PostMapping("mascota")
    public boolean crearMascota(@RequestBody Pet mascota) 
    {
        return petTravelService.crearMascota(mascota);
    }

    @PostMapping("propietario")
    public boolean crearPropietario(@RequestBody PetOwner propietario) 
    {
        return petTravelService.crearPropietario(propietario);
    }

    @PostMapping("conductor")
    public boolean crearConductor(@RequestBody ConductorTransporteMascota conductor) 
    {
        return petTravelService.crearConductor(conductor);
    }

    @PostMapping("asignarConductor/{idViaje}/{idConductor}")
    public boolean asignarConductor(@PathVariable int idViaje, @PathVariable int idConductor) 
    {
        return petTravelService.asignarConductorViaje(idViaje, idConductor);
    }

    @PostMapping("asignarMascota/{idViaje}/{idMascota}")
    public boolean asignarMascota(@PathVariable int idViaje, @PathVariable int idMascota) 
    {
        return petTravelService.agregarMascotaViaje(idMascota, idViaje);
    }

    @DeleteMapping("viaje/{idViaje}")
    public boolean eliminarViaje(@PathVariable int idViaje) 
    {
        return petTravelService.eliminarViaje(idViaje);
    }

    @DeleteMapping("mascota/{idMascota}")
    public boolean eliminarMascota(@PathVariable int idMascota) 
    {
        return petTravelService.eliminarMascota(idMascota);
    }

    @DeleteMapping("propietario/{idPropietario}")
    public boolean eliminarPropietario(@PathVariable int idPropietario) 
    {
        return petTravelService.eliminarPropietario(idPropietario);
    }

    @DeleteMapping("conductor/{idConductor}")
    public boolean eliminarConductor(@PathVariable int idConductor) 
    {
        return petTravelService.eliminarConductor(idConductor);
    }
    



    
}
