package com.desarrollo.evaluacion2.evaluacion2.lib;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor 
@Entity 
@Table(name = "viaje")
public class Travel 
{
    @Id
    @Positive
    @NotNull
    private int idViaje;
    private String idMascota;
    private String idConductor;
    private String fechaViaje;
    private String horaViaje;
    private String lugarRecogida;
    private String lugarDestino;
    private String estadoViaje;
    private double costoViaje;
}
