package com.algafood.domain.exception;

import java.io.Serial;

public class UsuarioNaoEncontradaException extends EntidadeNaoEncontradaException {

	@Serial
	private static final long serialVersionUID = 1L;

	public UsuarioNaoEncontradaException(String message) {
		super( message);
	}

	public UsuarioNaoEncontradaException(Long usuarioId) {
		this(String.format("Não existe um cadastro de usuário com código %d", usuarioId));
	}
}
