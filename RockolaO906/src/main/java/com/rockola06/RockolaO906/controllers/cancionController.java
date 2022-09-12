package com.rockola06.RockolaO906.controllers;

import com.rockola06.RockolaO906.interfaces.CancionService;
import com.rockola06.RockolaO906.models.Cancion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/cancion")
public class CancionController {
    
    @Autowired
    private CancionService cancionService;

    @PostMapping(value = "/")
    public ResponseEntity<Cancion> agregar(@RequestBody Cancion cancion) {
        Cancion obj = cancionService.save(cancion);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/list/{id}")
    public ResponseEntity<Cancion> eliminar(@PathVariable Integer id) {
        Cancion obj = cancionService.findById(id);
            if(obj != null) {
                cancionService.delete(id);
            }
            else {
                return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value = "/list/{id}")
    public ResponseEntity<Cancion> editar(@RequestBody Cancion cancion) {
        Cancion obj = cancionService.findById(cancion.getIdCancion());
            if(obj != null) {
                obj.setNombreCancion(cancion.getNombreCancion());
                obj.setAutor(cancion.getAutor());
                obj.setGenero(cancion.getGenero());
                obj.setFechaPublicacion(cancion.getFechaPublicacion());
                cancionService.save(obj);
            }
            else {
                return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Cancion> consultarTodo() {
        return cancionService.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Cancion consultaPorId(@PathVariable Integer id) {
        return cancionService.findById(id);
    }
}