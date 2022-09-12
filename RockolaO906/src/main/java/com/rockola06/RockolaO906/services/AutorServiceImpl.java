package com.rockola06.RockolaO906.services;

import com.rockola06.RockolaO906.interfaces.AutorService;
import com.rockola06.RockolaO906.models.Autor;
import com.rockola06.RockolaO906.services.repositories.AutorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AutorServiceImpl implements AutorService {
    
    @Autowired
    private AutorDAO autordao;

    @Override
    @Transactional(readOnly = false)
    public Autor save(Autor autor) {
        return autordao.save(autor);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        autordao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Autor findById(Integer id) {
        return autordao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Autor> findAll() {
        return (List<Autor>) autordao.findAll();
    }

}
