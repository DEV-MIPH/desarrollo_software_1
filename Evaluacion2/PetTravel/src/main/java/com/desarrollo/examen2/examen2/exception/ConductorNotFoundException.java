package com.desarrollo.examen2.examen2.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ConductorNotFoundException extends RuntimeException {
    public ConductorNotFoundException(int id) {
        super("No se encontro el conductor con el id: " + id);
    }
}
