package com.rockola06.RockolaO906.services.repositories;

import org.springframework.data.repository.CrudRepository;
import com.rockola06.RockolaO906.models.Cancion;

public interface CancionDAO extends CrudRepository<Cancion,Integer>  {
    
}