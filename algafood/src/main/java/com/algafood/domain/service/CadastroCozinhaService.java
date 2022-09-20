package com.algafood.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.algafood.domain.exception.EntidadeEmUsoException;
import com.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.repository.CozinhaRepository;


@Service
public class CadastroCozinhaService {
	public static final String MSG_COZINHA_NAO_ENCONTRADA
			= "Não existe um cadastro de cozinha com código %d";
	public static final String MSG_COZINHA_ENCONTRA_SE_EM_USO
			= "Cozinha %d não pode ser removido: Encontra-se em uso";
	@Autowired
	private CozinhaRepository cozinhaRepository;

	public List<Cozinha> buscarTodas() {
		return cozinhaRepository.findAll();
	}

	public Optional<Cozinha> buscarPorId(Long cozinhaId) {
		return cozinhaRepository.findById(cozinhaId);
	}

	
	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}

	public void excluir(Long cozinhaId) {

		try {
			cozinhaRepository.deleteById(cozinhaId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_COZINHA_ENCONTRA_SE_EM_USO, cozinhaId ));

		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format(MSG_COZINHA_NAO_ENCONTRADA, cozinhaId));
		}
	}
	public Cozinha buscarOuFalhar(Long cozinhaId){
		return cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format(MSG_COZINHA_NAO_ENCONTRADA, cozinhaId)));
	}
}
