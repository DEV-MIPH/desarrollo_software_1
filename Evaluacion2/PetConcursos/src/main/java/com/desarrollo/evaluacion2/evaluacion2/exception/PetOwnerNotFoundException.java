package com.desarrollo.evaluacion2.evaluacion2.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PetOwnerNotFoundException extends RuntimeException {
    public PetOwnerNotFoundException(int id) {
        super("No se encontro el propietario de la mascota con el id: " + id + "");
    }
}
