package com.algafood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algafood.model.Estado;
import com.algafood.repository.EstadoRepository;

@Service
public class EstadoService {
    
    @Autowired
    private EstadoRepository repository;

    public List<Estado>listar(){
        return repository.findAll();
    }
}
