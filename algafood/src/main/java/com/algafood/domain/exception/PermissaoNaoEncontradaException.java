package com.algafood.domain.exception;

import java.io.Serial;

public class PermissaoNaoEncontradaException extends EntidadeNaoEncontradaException {

	@Serial
	private static final long serialVersionUID = 1L;

	public PermissaoNaoEncontradaException(String message) {
		super( message);
	}

	public PermissaoNaoEncontradaException(Long permissaoId) {
		this(String.format("Não existe um cadastro de cidade com código %d", permissaoId));
	}
}
