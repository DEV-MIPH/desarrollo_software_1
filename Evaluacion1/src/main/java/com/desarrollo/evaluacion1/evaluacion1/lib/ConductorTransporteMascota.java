package com.desarrollo.evaluacion1.evaluacion1.lib;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor 
public class ConductorTransporteMascota {
    private int idConductor;
    private String nombreConductor;
    private String apellidoConductor;
    private String telefonoConductor;
}
