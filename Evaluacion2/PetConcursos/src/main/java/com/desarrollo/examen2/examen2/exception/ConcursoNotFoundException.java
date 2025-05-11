package com.desarrollo.examen2.examen2.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ConcursoNotFoundException 
{
    public ConcursoNotFoundException(int id) {
        throw new RuntimeException("No se encontro el concurso con el id: " + id + "");
    }
}
