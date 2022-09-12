
package com.rockola06.RockolaO906.controllers;

import com.rockola06.RockolaO906.interfaces.AutorService;
import com.rockola06.RockolaO906.models.Autor;
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
@RequestMapping("/autor")
public class AutorController {
    
    @Autowired
    private AutorService autorService;

    @PostMapping(value = "/")
    public ResponseEntity<Autor> agregar(@RequestBody Autor autor) {
        Autor obj = autorService.save(autor);
        System.out.println("add autor controller " + autor.getNombreAutor());
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/list/{id}")
    public ResponseEntity<Autor> eliminar(@PathVariable Integer id) {
        Autor obj = autorService.findById(id);
            if(obj != null) {
                autorService.delete(id);
            }
            else {
                System.out.println("autor no eliminado " + obj);
                return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        System.out.println("autor eliminado " + obj);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/list/{id}")
    public ResponseEntity<Autor> editar(@RequestBody Autor autor) {
        Autor obj = autorService.findById(autor.getIdAutor());
        System.out.println("autor id " + obj);
            if(obj != null) {
                obj.setNombreAutor(autor.getNombreAutor());
                obj.setApellidoAutor(autor.getApellidoAutor());
                autorService.save(obj);
            }
            else {
                System.out.println("autor NO actualizado " + obj);
                return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        System.out.println("autor actualizado " + obj);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Autor> consultarTodo() {
        return autorService.findAll();
    }

    @GetMapping("/list/{id}")
    public Autor consultaPorId(@PathVariable Integer id) { 
        System.out.println("consulta id autor controller " + autorService.findById(id));
        return autorService.findById(id);
    }
}