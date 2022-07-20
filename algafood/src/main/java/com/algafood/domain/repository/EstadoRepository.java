package com.algafood.domain.repository;

import java.util.List;

import com.algafood.domain.model.Estado;

public interface EstadoRepository {
	
	List<Estado> buscarTodos();
	Estado buscaPorId(Long id);
	Estado adicionar(Estado estado);
	void remover(Estado estado);

}
