package cl.usm.hdd.certamen1.services;

import cl.usm.hdd.certamen1.entities.Pelicula;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeliculaServicesImpl implements PeliculaServices{
    private static List<Pelicula> peliculas = new ArrayList<>();

    @Override
    public List<Pelicula> obtener() {
        return peliculas;
    }

    @Override
    public Pelicula crear(Pelicula p) {
        peliculas.add(p);
        return p;
    }

    @Override
    public Pelicula filtrar(String limite) {
        return peliculas.stream()
                .filter(s->s.getLimite()
                        .equalsIgnoreCase(limite))
                .findFirst()
                .orElse(null);
    }
}
