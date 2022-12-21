package com.algafood.domain.exception;

import java.io.Serial;

public class CidadeNaoEncontradaException extends EntidadeNaoEncontradaException {

	@Serial
	private static final long serialVersionUID = 1L;

	public CidadeNaoEncontradaException(String message) {
		super( message);
	}

	public CidadeNaoEncontradaException(Long cidadeId) {
		this(String.format("Não existe um cadastro de cidade com código %d", cidadeId));
	}
}
