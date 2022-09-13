
package com.rockola06.RockolaO906.interfaces;

import com.rockola06.RockolaO906.models.Genero;
import java.util.List;

public interface GeneroCanService {
    public Genero save(Genero genero);
    public void delete(Integer id);
    public Genero findById(Integer id);
    public List<Genero> findAll(); 
}