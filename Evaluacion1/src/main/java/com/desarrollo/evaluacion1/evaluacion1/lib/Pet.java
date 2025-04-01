package com.desarrollo.evaluacion1.evaluacion1.lib;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private int idMascota;
    private PetOwner owner;
    private String nombreMascota;
    private String tipoMascota;
    private String razaMascota;

}
