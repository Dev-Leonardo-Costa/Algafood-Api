package com.algafood.domain.repository;

import java.util.List;

import com.algafood.domain.model.Cozinha;

public interface CozinhaRepository {
	
	List<Cozinha> buscarTodas();
	List<Cozinha> consultarPorNome(String nome);
	Cozinha buscarPorId(Long id);
    Cozinha adicionar(Cozinha cozinha);
	void remover(Long cozinhaId);

}
