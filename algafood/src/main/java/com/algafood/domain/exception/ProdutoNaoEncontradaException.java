package com.algafood.domain.exception;

import java.io.Serial;

public class ProdutoNaoEncontradaException extends EntidadeNaoEncontradaException {

	@Serial
	private static final long serialVersionUID = 1L;

	public ProdutoNaoEncontradaException(String message) {
		super( message);
	}

	public ProdutoNaoEncontradaException(Long restauranteId, Long produtoId) {
		this(String.format("Não existe um cadastro de produto com código %d para o restaurante de código %d", produtoId,restauranteId));
	}
}
