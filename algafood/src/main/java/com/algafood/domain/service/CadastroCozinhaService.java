package com.algafood.domain.service;

import com.algafood.domain.exception.CozinhaNaoEncontradoException;
import com.algafood.domain.exception.EntidadeEmUsoException;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.repository.CozinhaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
			throw new CozinhaNaoEncontradoException(
					String.format(MSG_COZINHA_NAO_ENCONTRADA, cozinhaId));
		}
	}
	public Cozinha buscarOuFalhar(Long cozinhaId){
		return cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new CozinhaNaoEncontradoException(
						String.format(MSG_COZINHA_NAO_ENCONTRADA, cozinhaId)));
	}
}
