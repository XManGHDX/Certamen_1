package cl.usm.hdd.certamen1.controllers;

import cl.usm.hdd.certamen1.entities.Pelicula;
import cl.usm.hdd.certamen1.services.PeliculaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.security.mscapi.PRNG;

import java.util.List;


@RestController
public class PeliculasControllers  {
    @Autowired
    private PeliculaServices peliculaServices;

    @GetMapping("/verPeliculas")
    public ResponseEntity<List<Pelicula>> obtener(){
        try{
            return ResponseEntity.ok(this.peliculaServices.obtener());
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/crearPelicula")
    public ResponseEntity<Pelicula> crear(@RequestBody Pelicula pelicula){
        try{
            Pelicula peliculaNuevo = peliculaServices.crear(pelicula);
            return ResponseEntity.ok(peliculaNuevo);
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/peliculas/{limite}")
    public ResponseEntity<Pelicula> filtrar(@PathVariable String limite){
        try{
            Pelicula pelicula = peliculaServices.filtrar(limite);
            return ResponseEntity.ok(pelicula);

        }catch (Exception ex){
            return ResponseEntity.internalServerError().body(null);
        }
    }

}
