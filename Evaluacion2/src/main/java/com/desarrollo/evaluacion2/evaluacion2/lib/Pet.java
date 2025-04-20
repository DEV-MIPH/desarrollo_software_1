package com.desarrollo.evaluacion2.evaluacion2.lib;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
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
    private String idOwner;
    private String nombreMascota;
    private String tipoMascota;
    private String razaMascota;
}
