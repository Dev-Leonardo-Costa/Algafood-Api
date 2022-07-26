package com.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algafood.domain.model.Estado;
import com.algafood.domain.repository.EstadoRepository;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Estado> buscarTodos() {
		return manager.createQuery("from Estado", Estado.class).getResultList();
	}

	@Override
	public Estado buscaPorId(Long id) {
		return manager.find(Estado.class, id);
	}


	@Transactional
	@Override
	public Estado adicionar(Estado estado) {
		return manager.merge(estado);
	}

	@Transactional
	@Override
	public void remover(Estado estado) {
		estado = buscaPorId(estado.getId());
		manager.remove(estado);
	}
}