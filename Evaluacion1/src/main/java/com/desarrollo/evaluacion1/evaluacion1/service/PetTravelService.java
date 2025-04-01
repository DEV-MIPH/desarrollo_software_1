package com.desarrollo.evaluacion1.evaluacion1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.desarrollo.evaluacion1.evaluacion1.lib.ConductorTransporteMascota;
import com.desarrollo.evaluacion1.evaluacion1.lib.Pet;
import com.desarrollo.evaluacion1.evaluacion1.lib.PetOwner;
import com.desarrollo.evaluacion1.evaluacion1.lib.Travel;

import jakarta.annotation.PostConstruct;

@Service
public class PetTravelService 
{
    private List<PetOwner> petOwners = new ArrayList<>();
    private List<ConductorTransporteMascota> conductores = new ArrayList<>();
    private List<Travel> viajes = new ArrayList<>();
    private List<Pet> mascotas = new ArrayList<>();

    
    @PostConstruct
    public void init() {
        // Inicializar los datos de prueba aquí
        PetOwner owner1 = new PetOwner(1, "Juan", "Pérez", "123456789");
        PetOwner owner2 = new PetOwner(2, "Ana", "Gómez", "987654321");
        PetOwner owner3 = new PetOwner(3, "Luis", "Martínez", "456789123");

        petOwners.add(owner1);
        petOwners.add(owner2);
        petOwners.add(owner3);

        Pet pet1 = new Pet(1, owner1, "Firulais", "Perro", "Labrador");
        Pet pet2 = new Pet(2, owner1, "Miau", "Gato", "Siames");
        Pet pet3 = new Pet(3, owner3, "Tortuga", "Reptil", "Acuatica");
        Pet pet4 = new Pet(4, owner3, "Pajarito", "Ave", "Canario");

        mascotas.add(pet1);
        mascotas.add(pet2);
        mascotas.add(pet3);
        mascotas.add(pet4);


        
        ConductorTransporteMascota driver1 = new ConductorTransporteMascota(1, "Pedro", "Gómez", "987654321");
        ConductorTransporteMascota driver2 = new ConductorTransporteMascota(2, "María", "López", "456789123");
        ConductorTransporteMascota driver3 = new ConductorTransporteMascota(3, "Luis", "Jara", "321654987");

        conductores.add(driver1);
        conductores.add(driver2);
        conductores.add(driver3);


        Travel travel1 = new Travel(1, null, "2023-10-01", "10:00", "Casa", "Veterinaria", "Pendiente", 2000.0, null);
        travel1.addMascotaViaje(pet1);
        travel1.asignarConductor(driver1);

        Travel travel2 = new Travel(2, null, "2023-10-02", "11:00", "Casa", "Parque", "Pendiente", 1500.0, null);
        travel2.addMascotaViaje(pet2);
        travel2.asignarConductor(driver2);

        Travel travel3 = new Travel(3, null, "2023-10-03", "12:00", "Casa", "Playa", "Pendiente", 3000.0, null);
        travel3.addMascotaViaje(pet3);
        travel3.addMascotaViaje(pet4);
        travel3.asignarConductor(driver3);

        viajes.add(travel1);
        viajes.add(travel2);
        viajes.add(travel3);
        
    }

    
    public boolean crearViaje(Travel viaje) 
    {
        try {
            viajes.add(viaje);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean asignarConductorViaje(int idViaje, int idConductor) 
    {
        try {
            Travel viaje = viajes.stream().filter(v -> v.getIdViaje() == idViaje).findFirst().orElse(null);
            ConductorTransporteMascota conductor = conductores.stream().filter(c -> c.getIdConductor() == idConductor).findFirst().orElse(null);

            if (viaje != null && conductor != null) {
                viaje.asignarConductor(conductor);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean agregarMascotaViaje(int idViaje, int idMascota) 
    {
        try {
            Travel viaje = viajes.stream().filter(v -> v.getIdViaje() == idViaje).findFirst().orElse(null);
            Pet mascota = mascotas.stream().filter(m -> m.getIdMascota() == idMascota).findFirst().orElse(null);

            if (viaje != null) {
                viaje.addMascotaViaje(mascota);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminarMascotaViaje(int idViaje, Pet mascota) 
    {
        try {
            Travel viaje = viajes.stream().filter(v -> v.getIdViaje() == idViaje).findFirst().orElse(null);

            if (viaje != null) {
                viaje.getMascotasViaje().remove(mascota);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminarViaje(int idViaje) 
    {
        try {
            Travel viaje = viajes.stream().filter(v -> v.getIdViaje() == idViaje).findFirst().orElse(null);

            if (viaje != null) {
                viajes.remove(viaje);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean crearMascota(Pet mascota) 
    {
        try {
            mascotas.add(mascota);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminarMascota(int idMascota) 
    {
        try {
            Pet mascota = mascotas.stream().filter(m -> m.getIdMascota() == idMascota).findFirst().orElse(null);

            if (mascota != null) {
                mascotas.remove(mascota);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean crearPropietario(PetOwner propietario) 
    {
        try {
            petOwners.add(propietario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminarPropietario(int idPropietario) 
    {
        try {
            PetOwner propietario = petOwners.stream().filter(p -> p.getIdPropietario() == idPropietario).findFirst().orElse(null);

            if (propietario != null) {
                petOwners.remove(propietario);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean crearConductor(ConductorTransporteMascota conductor) 
    {
        try {
            conductores.add(conductor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminarConductor(int idConductor) 
    {
        try {
            ConductorTransporteMascota conductor = conductores.stream().filter(c -> c.getIdConductor() == idConductor).findFirst().orElse(null);

            if (conductor != null) {
                conductores.remove(conductor);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }


    public Travel getViaje(int idViaje) 
    {
        return viajes.stream().filter(v -> v.getIdViaje() == idViaje).findFirst().orElse(null);
    }

    public PetOwner getPropietario(int idPropietario) 
    {
        return petOwners.stream().filter(p -> p.getIdPropietario() == idPropietario).findFirst().orElse(null);
    }

    public ConductorTransporteMascota getConductor(int idConductor) 
    {
        return conductores.stream().filter(c -> c.getIdConductor() == idConductor).findFirst().orElse(null);
    }

    public Pet getMascota(int idMascota) 
    {
        return mascotas.stream().filter(m -> m.getIdMascota() == idMascota).findFirst().orElse(null);
    }

    public List<Travel> getViajesPorConductor(int idConductor) 
    {
        return viajes.stream().filter(v -> v.getConductor().getIdConductor() == idConductor).toList();
    }


    public List<PetOwner> getPetOwners() {
        return petOwners;
    }
    public List<ConductorTransporteMascota> getConductores() {
        return conductores;
    }
    public List<Travel> getViajes() {
        return viajes;
    }
    public List<Pet> getMascotas() {
        return mascotas;
    }
    
}
