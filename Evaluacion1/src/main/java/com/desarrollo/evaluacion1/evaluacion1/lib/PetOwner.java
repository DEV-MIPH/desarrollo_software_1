package com.desarrollo.evaluacion1.evaluacion1.lib;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetOwner {
    private int idPropietario;
    private String nombrePropietario;
    private String apellidoPropietario;
    private String telefonoPropietario;
}
