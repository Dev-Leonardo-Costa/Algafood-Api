package com.algafood.domain.exception;

import java.io.Serial;

public class PedidoNaoEncontradaException extends EntidadeNaoEncontradaException {

	@Serial
	private static final long serialVersionUID = 1L;

	public PedidoNaoEncontradaException(String codigoPedido) {
		super(String.format("Não existe um pedido com código %s", codigoPedido));
	}
}
