package com.algafood.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algafood.domain.exception.EntidadeEmUsoException;
import com.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algafood.domain.model.Cidade;
import com.algafood.domain.model.Estado;
import com.algafood.domain.repository.CidadeRepository;
import com.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {
	public static final String MSG_CIDADE_NAO_ENCONTRADA
			= "Não existe cadastro de cidade com esse código %d ";
	public static final String MSG_CIDADE_ENCONTRA_SE_EM_uso
			= "Cidade %d não pode ser removida: Encontra-se em uso";
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private CadastroEstadoService cadastroEstado;

	public List<Cidade> buscarTodas() {
		return cidadeRepository.findAll();
	}

	public Optional<Cidade> buscarPorId(Long cidadeId) {
		return cidadeRepository.findById(cidadeId);
	}
	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = cadastroEstado.buscarEstadoOuFalhar(estadoId);
		cidade.setEstado(estado);
		return cidadeRepository.save(cidade);
	}

	public void excluir(Long cidadeId) {
		try {
			cidadeRepository.deleteById(cidadeId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format(MSG_CIDADE_NAO_ENCONTRADA, cidadeId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_CIDADE_ENCONTRA_SE_EM_uso, cidadeId));
		}
	}
	public Cidade buscarCidadeOuFalhar(Long cidadeId){
		return  cidadeRepository.findById(cidadeId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format(MSG_CIDADE_NAO_ENCONTRADA, cidadeId)));
	}

}
