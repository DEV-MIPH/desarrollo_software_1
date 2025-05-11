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
@Table(name = "pet_owner")
public class PetOwner 
{
    @NotNull
    @Positive
    @Id
    private int idPropietario;
    private String nombrePropietario;
    private String apellidoPropietario;
    private String telefonoPropietario;
}
