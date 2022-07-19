package com.algafood.domain.repository;

import java.util.List;

import com.algafood.domain.model.Cozinha;

public interface CozinhaRepository {
	
	List<Cozinha> buscarTodas();
	Cozinha buscarPorId(Long id);
    Cozinha adicionar(Cozinha cozinha);
	void remover(Cozinha cozinha);

}
