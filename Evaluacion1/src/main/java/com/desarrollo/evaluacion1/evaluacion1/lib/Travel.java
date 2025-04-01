package com.desarrollo.evaluacion1.evaluacion1.lib;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor 
public class Travel 
{
    private int idViaje;
    private ConductorTransporteMascota conductor;
    private String fechaViaje;
    private String horaViaje;
    private String lugarRecogida;
    private String lugarDestino;
    private String estadoViaje;
    private double costoViaje;
    private List<Pet> mascotasViaje;

    public boolean addMascotaViaje(Pet mascota) 
    {
        try {
            if(mascotasViaje == null) {
                this.mascotasViaje = new ArrayList<>();
            }
            this.mascotasViaje.add(mascota);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean asignarConductor(ConductorTransporteMascota conductor) 
    {
        try {
            this.conductor = conductor;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
