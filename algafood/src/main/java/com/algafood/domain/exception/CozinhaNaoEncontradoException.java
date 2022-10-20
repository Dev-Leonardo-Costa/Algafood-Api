package com.algafood.domain.exception;

public class CozinhaNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public CozinhaNaoEncontradoException(String message) {
		super( message);
	}
}
