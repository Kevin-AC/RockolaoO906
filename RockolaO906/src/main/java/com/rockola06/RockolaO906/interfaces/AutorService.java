
package com.rockola06.RockolaO906.interfaces;

import com.rockola06.RockolaO906.models.Autor;
import java.util.List;


public interface AutorService {
    public Autor save(Autor autor);
    public void delete(Integer id);
    public Autor findById(Integer id);
    public List<Autor> findAll();    
}