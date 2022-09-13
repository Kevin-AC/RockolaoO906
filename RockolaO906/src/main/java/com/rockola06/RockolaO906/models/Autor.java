package com.rockola06.RockolaO906.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAutor")
    private Integer idAutor;
    @Column(name = "nombreAutor")
    private String nombreAutor;
    @Column(name = "apellidoAutor")
    private String apellidoAutor;

    public Integer getIdAutor() {
        return idAutor;
    }
    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }
    public String getNombreAutor() {
        return nombreAutor;
    }
    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }
    public String getApellidoAutor() {
        return apellidoAutor;
    }
    public void setApellidoAutor(String apellidoAutor) {
        this.apellidoAutor = apellidoAutor;
    }
}