package com.desarrollo.actividad1.actividad1;

import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.desarrollo.actividad1.actividad1.lib.Pelicula;

@RestController
@RequestMapping("/peliculas")
public class PeliculasController 
{
    List<Pelicula> peliculas = new ArrayList<>();

    public PeliculasController()
    {
        peliculas.add(new Pelicula(1, "El Padrino", "Francis Ford Coppola", "Drama", 1972, "Breve sinopsis de la película El Padrino"));
        peliculas.add(new Pelicula(2, "La era del hielo", "Chris Wedge", "Animación", 2002, "Breve sinopsis de la película La era del hielo"));
        peliculas.add(new Pelicula(3, "El Señor de los Anillos", "Peter Jackson", "Fantasía", 2001, "Breve sinopsis de la película El Señor de los Anillos"));
        peliculas.add(new Pelicula(4, "Titanic", "James Cameron", "Romance", 1997, "Breve sinopsis de la película Titanic"));
        peliculas.add(new Pelicula(5, "El Rey León", "Roger Allers", "Animación", 1994, "Breve sinopsis de la película El Rey León"));
        peliculas.add(new Pelicula(6, "El Exorcista", "William Friedkin", "Terror", 1973, "Breve sinopsis de la película El Exorcista"));
        peliculas.add(new Pelicula(7, "La lista de Schindler", "Steven Spielberg", "Drama", 1993, "Breve sinopsis de la película La lista de Schindler"));
    }

    @GetMapping("/{id}")
    public Pelicula getPelicula(@PathVariable int id) 
    {
        for(Pelicula pelicula : peliculas)
        {
            if(pelicula.getId() == id)
            {
                return pelicula;
            }
        }

        return null;
    }

    @GetMapping("")
    public List<Pelicula> getPeliculas() 
    {
        return peliculas;
    }

    
}
