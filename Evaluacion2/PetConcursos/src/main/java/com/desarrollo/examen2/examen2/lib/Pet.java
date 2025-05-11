package com.desarrollo.examen2.examen2.lib;

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
@Table(name = "mascota")
public class Pet 
{
    @Id
    @Positive 
    @NotNull
    private int idMascota;
    private int idOwner;
    private String nombreMascota;
    private String tipoMascota;
    private String razaMascota;
}
