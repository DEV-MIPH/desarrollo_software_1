package com.desarrollo.examen2.examen2.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TravelNotFoundException extends RuntimeException {
    public TravelNotFoundException(int id) {
        super("No se encontro el viaje con el id: " + id);
    }
}
