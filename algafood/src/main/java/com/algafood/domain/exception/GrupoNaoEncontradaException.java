package com.algafood.domain.exception;

import java.io.Serial;

public class GrupoNaoEncontradaException extends EntidadeNaoEncontradaException {

	@Serial
	private static final long serialVersionUID = 1L;

	public GrupoNaoEncontradaException(String message) {
		super( message);
	}

	public GrupoNaoEncontradaException(Long grupoId) {
		this(String.format("Não existe um cadastro de grupo com código %d", grupoId));
	}
}
