package com.algafood.domain.service;

import java.util.List;

import com.algafood.domain.exception.RestauranteNaoEncontradoException;
import com.algafood.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algafood.domain.exception.EntidadeEmUsoException;
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

	@Autowired
	private CadastroUsuarioService cadastroUsuario;
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
	public void ativarEmMassa(List<Long> restauranteIds){
		restauranteIds.forEach(this::ativar);
	}

	@Transactional
	public void inativarEmMassa(List<Long> restauranteIds) {
		restauranteIds.forEach(this::inativar);
	}
	@Transactional
	public void abrir(Long restauranteId) {
		Restaurante restauranteAtual = buscarRestauranteOuFalhar(restauranteId);
		restauranteAtual.aberto();
	}
	@Transactional
	public void fechar(Long restauranteId) {
		Restaurante restauranteAtual = buscarRestauranteOuFalhar(restauranteId);
		restauranteAtual.fechado();
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

	@Transactional
	public void desassociarResponsavel(Long restauranteId, Long usuarioId){
		Restaurante restaurante = buscarRestauranteOuFalhar(restauranteId);
		Usuario usuario = cadastroUsuario.buscarUsuarioOuFalhar(usuarioId);
		restaurante.removerResponsavel(usuario);
	}
	@Transactional
	public void associarResponsavel(Long restauranteId, Long usuarioId){
		Restaurante restaurante = buscarRestauranteOuFalhar(restauranteId);
		Usuario usuario = cadastroUsuario.buscarUsuarioOuFalhar(usuarioId);
		restaurante.adicionarResponsavel(usuario);
	}

	public Restaurante buscarRestauranteOuFalhar(Long restauranteId) {
		return restauranteRepository.findById(restauranteId)
				.orElseThrow(() -> new RestauranteNaoEncontradoException(restauranteId));
	}
}