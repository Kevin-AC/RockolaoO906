
package com.rockola06.RockolaO906.interfaces;

import com.rockola06.RockolaO906.models.Cancion;
import java.util.List;


public interface CancionService {
    public Cancion save(Cancion cancion);
    public void delete (Integer id);
    public Cancion findById(Integer id);
    public List<Cancion> findAll ();    
}
