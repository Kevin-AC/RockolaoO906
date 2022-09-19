package com.rockola06.RockolaO906.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cancion")
public class Cancion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCancion")
    private Integer idCancion;
    
    @Column(name = "nombreCancion")
    private String nombreCancion;
    
    @ManyToOne
    @JoinColumn(name = "idAutor") // foranea
    private Autor autor;
    
    @ManyToOne
    @JoinColumn(name = "idGenero") // foranea
    private Genero genero;
    
    @Column(name = "fechaPublicacion")
    private String fechaPublicacion;

    public Cancion() {
    }

    public Cancion(Integer idCancion, String nombreCancion, Autor autor, Genero genero, String fechaPublicacion) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.autor = autor;
        this.genero = genero;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Integer getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}