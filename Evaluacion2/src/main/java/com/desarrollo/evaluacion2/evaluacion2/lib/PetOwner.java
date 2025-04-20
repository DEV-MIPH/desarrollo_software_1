package com.desarrollo.evaluacion2.evaluacion2.lib;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
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
