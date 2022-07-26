package com.algafood.domain.repository;

import java.util.List;

import com.algafood.domain.model.Restaurante;

public interface RestauranteRepository {

	List<Restaurante> buscarTodos();
	Restaurante buscarPorId(Long restauranteId);
	Restaurante adicionar(Restaurante restaurante);
//	void remover(Long restauranteId);
}
