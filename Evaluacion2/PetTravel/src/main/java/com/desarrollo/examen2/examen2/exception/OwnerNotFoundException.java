package com.desarrollo.examen2.examen2.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OwnerNotFoundException extends RuntimeException {
    public OwnerNotFoundException(int id) {
        super("No se encontro el dueño con el id: " + id);
    }
} 