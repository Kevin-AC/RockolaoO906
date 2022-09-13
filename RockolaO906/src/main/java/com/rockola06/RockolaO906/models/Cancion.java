package com.rockola06.RockolaO906.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "cancion")
public class Cancion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCancion")
    private Integer idCancion;
    @Column(name = "nombreCancion")
    private Integer nombreCancion;
    @ManyToOne
    @JoinColumn(name = "idAutor") // foarenea
    private Autor autor;
    @JoinColumn(name = "idGenero") // foraena}
    private Genero genero;
    @Column(name = "fechaPublicacion")
    private Integer fechaPublicacion;

    public Integer getIdCancion() {
        return idCancion;
    }
    
    public Cancion() {
    }

    public Cancion(Integer idCancion, Integer nombreCancion, Autor autor, Genero genero, Integer fechaPublicacion) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.autor = autor;
        this.genero = genero;
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public Integer getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(Integer nombreCancion) {
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

    public Integer getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Integer fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}