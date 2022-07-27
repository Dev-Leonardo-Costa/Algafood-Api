package com.algafood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algafood.domain.exception.EntidadeEmUsoException;
import com.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public List<Cozinha> buscarTodas() {
		return cozinhaRepository.buscarTodas();
	}

	public Cozinha buscarPorId(Long cozinhaId) {
		return cozinhaRepository.buscarPorId(cozinhaId);
	}

	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.adicionar(cozinha);
	}

	public void excluir(Long cozinhaId) {
		try {
			cozinhaRepository.remover(cozinhaId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Estado não pode ser removido: possui associação com cidade %d", cozinhaId));
		}

		catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de estado com código %d", cozinhaId));
		}
	}
}
