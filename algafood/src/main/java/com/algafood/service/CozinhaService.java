package com.algafood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algafood.model.Cozinha;
import com.algafood.repository.CozinhaRepository;

@Service
public class CozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;
    
    public List<Cozinha> listar(){
        return cozinhaRepository.findAll();
    }
}
