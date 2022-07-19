package com.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algafood.domain.model.Cozinha;
import com.algafood.domain.repository.CozinhaRepository;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Cozinha> buscarTodas() {
		return manager.createQuery("from Cozinha", Cozinha.class)
				.getResultList();
	}

	@Override
	public Cozinha buscarPorId(Long id) {
		return manager.find(Cozinha.class, id);
	}
	
	@Transactional
	@Override
	public Cozinha adicionar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}

	@Transactional
	@Override
	public void remover(Cozinha cozinha) {
		cozinha = buscarPorId(cozinha.getId());
		manager.remove(cozinha);
	}
}
