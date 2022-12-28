package com.algafood.domain.service;

import com.algafood.domain.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FluxoPedidoService {
    @Autowired
    private EmissaoPedidoService emissaoPedido;

    @Transactional
    public void confirmar(String codigoPedido){
        Pedido pedido = emissaoPedido.buscarPedidoOuFalhar(codigoPedido);
        pedido.confirmar();
    }

    @Transactional
    public void cancelar(String codigoPedido){
        Pedido pedido = emissaoPedido.buscarPedidoOuFalhar(codigoPedido);
        pedido.cancelar();
    }

    @Transactional
    public void entregar(String codigoPedido){
        Pedido pedido = emissaoPedido.buscarPedidoOuFalhar(codigoPedido);
        pedido.entregar();
    }
}

