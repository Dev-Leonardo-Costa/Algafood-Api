package com.algafood.domain.service;

import java.util.List;

import com.algafood.domain.exception.RestauranteNaoEncontradoException;
import com.algafood.domain.model.Cidade;
import com.algafood.domain.model.FormaPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algafood.domain.exception.EntidadeEmUsoException;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.model.Restaurante;
import com.algafood.domain.repository.RestauranteRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroRestauranteService {

	public static final String MSG_RESTAURANTE_ENCONTRA_SE_EM_USO
			= "Restaurante %d não pode ser removido: Encontra-se em uso";
	@Autowired
	private RestauranteRepository restauranteRepository;
	@Autowired
	private CadastroCozinhaService cadastroCozinha;

	@Autowired
	private CadastroFormaPagamentoService cadastroFormaPagamento;

	@Autowired
	private CadastroCidadeService cadastroCidade;
//	@Transactional
//	public Optional<Restaurante> buscarPorId(Long restauranteId) {
//		return restauranteRepository.findById(restauranteId);
//	}
	@Transactional
	public List<Restaurante> buscarTodos() {
		return restauranteRepository.findAll();
	}
	@Transactional
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Long cidadeId = restaurante.getEndereco().getCidade().getId();

		Cozinha cozinha = cadastroCozinha.buscarOuFalhar(cozinhaId);
		Cidade cidade = cadastroCidade.buscarCidadeOuFalhar(cidadeId);

		restaurante.setCozinha(cozinha);
		restaurante.getEndereco().setCidade(cidade);

		return restauranteRepository.save(restaurante);
	}

	@Transactional
	public void ativar(Long restauranteId){
		Restaurante restauranteAtual = buscarRestauranteOuFalhar(restauranteId);
		restauranteAtual.setAtivo(true);
	}

	@Transactional
	public void inativar(Long restauranteId) {
		Restaurante restauranteAtual = buscarRestauranteOuFalhar(restauranteId);
		restauranteAtual.setAtivo(false);
	}

	@Transactional
	public void excluir(Long restauranteId) {
		try {
			restauranteRepository.deleteById(restauranteId);
			restauranteRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new RestauranteNaoEncontradoException(restauranteId);

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_RESTAURANTE_ENCONTRA_SE_EM_USO, restauranteId));
		}
	}

	@Transactional
	public void dessasociarFormaPagamento(Long restauranteId, Long formaPagamentoId){

		Restaurante restaurante = buscarRestauranteOuFalhar(restauranteId);
		FormaPagamento formaPagamento = cadastroFormaPagamento.buscarFormaPagamentoOuFalhar(formaPagamentoId);

		restaurante.removerFormaPagamento(formaPagamento);
	}
	@Transactional
	public void associarFormaPagamento(Long restauranteId, Long formaPagamentoId){

		Restaurante restaurante = buscarRestauranteOuFalhar(restauranteId);
		FormaPagamento formaPagamento = cadastroFormaPagamento.buscarFormaPagamentoOuFalhar(formaPagamentoId);

		restaurante.adicionarFormaPagamento(formaPagamento);
	}

	public Restaurante buscarRestauranteOuFalhar(Long restauranteId) {
		return restauranteRepository.findById(restauranteId)
				.orElseThrow(() -> new RestauranteNaoEncontradoException(restauranteId));
	}
}