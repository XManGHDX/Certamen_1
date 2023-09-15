package cl.usm.hdd.certamen1.services;

import cl.usm.hdd.certamen1.entities.Pelicula;

import java.util.List;

public interface PeliculaServices {

    List<Pelicula> obtener();
    Pelicula crear(Pelicula p);

    Pelicula filtrar(String limite);
}
