package com.desarrollo.evaluacion2.evaluacion2.lib;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

@Data 
@AllArgsConstructor
@NoArgsConstructor 
@Entity 
@Table(name = "conductor_transporte_mascota")
public class ConductorTransporteMascota 
{
    @NotNull
    @Positive
    @Id
    private int idConductor;
    private String nombreConductor;
    private String apellidoConductor;
    private String telefonoConductor;
}
