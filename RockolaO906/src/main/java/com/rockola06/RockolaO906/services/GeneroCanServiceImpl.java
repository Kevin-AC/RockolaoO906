package com.rockola06.RockolaO906.services;

import com.rockola06.RockolaO906.services.repositories.GeneroCanDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rockola06.RockolaO906.models.Genero;
import com.rockola06.RockolaO906.interfaces.GeneroCanService;

@Service
public class GeneroCanServiceImpl implements GeneroCanService {

    @Autowired
    private GeneroCanDAO generocandao;

    @Override
    @Transactional(readOnly = false)
    public Genero save(Genero genero) {
        return generocandao.save(genero);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        generocandao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Genero findById(Integer id) {
        return generocandao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Genero> findAll() {
        return (List<Genero>) generocandao.findAll();
    }
}