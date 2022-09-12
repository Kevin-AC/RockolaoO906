package com.rockola06.RockolaO906.services;

import com.rockola06.RockolaO906.interfaces.CancionService;
import com.rockola06.RockolaO906.services.repositories.CancionDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rockola06.RockolaO906.models.Cancion;

@Service
public class CancionServiceImpl implements CancionService {

@Autowired
private CancionDAO canciondao;

@Override
@Transactional (readOnly=false)
public Cancion save(Cancion cancion){
return canciondao.save(cancion); 
}

@Override
@Transactional(readOnly=false)
public void delete(Integer id){
canciondao.deleteById(id);
}

@Override
@Transactional(readOnly=true)
public Cancion findById(Integer id){
return canciondao.findById(id).orElse(null);
}

@Override
@Transactional(readOnly=true)
public List<Cancion> findAll(){
return (List<Cancion>) canciondao.findAll();
}
}