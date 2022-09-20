package com.algafood.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algafood.domain.exception.EntidadeEmUsoException;
import com.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algafood.domain.model.Estado;
import com.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {
	public static final String MSG_ESTADO_NAO_ENCONTRADO
			= "Não existe um cadastro de estado com código %d";
	public static final String MSG_ESTADO_ENCONTRA_SE_EM_USO
			= "Estado %d não pode ser removido: Encontra-se em uso";
	@Autowired
	private EstadoRepository estadoRepository;

	public List<Estado> buscarTodos() {
		return estadoRepository.findAll();
	}

	public Optional<Estado> buscarPorId(Long estadoId) {
		return estadoRepository.findById(estadoId);
	}

	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);
	}

	public void excluir(Long estadoId) {
		try {
			estadoRepository.deleteById(estadoId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format(MSG_ESTADO_NAO_ENCONTRADO, estadoId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_ESTADO_ENCONTRA_SE_EM_USO, estadoId));
		}
	}
	public Estado buscarEstadoOuFalhar(Long estadoId){
		return estadoRepository.findById(estadoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format(MSG_ESTADO_NAO_ENCONTRADO, estadoId)));
	}
}
