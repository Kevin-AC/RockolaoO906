
package com.rockola06.RockolaO906.controllers;

import com.rockola06.RockolaO906.interfaces.GeneroCanService;
import com.rockola06.RockolaO906.models.Genero;
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
@RequestMapping("/generocancion")
public class GeneroCanController {
    
    @Autowired
    private GeneroCanService generoCanService;

    @PostMapping(value = "/")
    public ResponseEntity<Genero> agregar(@RequestBody Genero genero) {
        Genero obj = generoCanService.save(genero);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/list/{id}")
    public ResponseEntity<Genero> eliminar(@PathVariable Integer id) {
        Genero obj = generoCanService.findById(id);
            if(obj != null) {
                generoCanService.delete(id);
            }
            else {
                return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/list/{id}")
    public ResponseEntity<Genero> editar(@RequestBody Genero genero) {
        Genero obj = generoCanService.findById(genero.getIdGenero());
            if(obj != null) {
                obj.setGenero(genero.getGenero());
                generoCanService.save(obj);
            }
            else {
                return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Genero> consultarTodo() {
        return generoCanService.findAll();
    }

    @GetMapping("/list/{id}")
    public Genero consultaPorId(@PathVariable Integer id) {
        return generoCanService.findById(id);
    }
}