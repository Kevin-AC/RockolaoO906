package com.rockola06.RockolaO906.services;

import com.rockola06.RockolaO906.services.repositories.GeneroDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rockola06.RockolaO906.models.Genero;
import com.rockola06.RockolaO906.interfaces.GeneroCanService;

@Service
public class GeneroCanServiceImpl implements GeneroCanService {

    @Autowired
    private GeneroDAO generodao;

    @Override
    @Transactional(readOnly = false)
    public Genero save(Genero genero) {
        return generodao.save(genero);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        generodao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Genero findById(Integer id) {
        return generodao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Genero> findAll() {
        return (List<Genero>) generodao.findAll();
    }
}