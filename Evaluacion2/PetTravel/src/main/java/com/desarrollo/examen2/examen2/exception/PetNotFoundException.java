package com.desarrollo.examen2.examen2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class PetNotFoundException extends RuntimeException {
    public PetNotFoundException(int id ) {
        super("No se encontro la mascota con el id: " + id + "");
    }

}
