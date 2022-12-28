package com.algafood.domain.service;

import com.algafood.domain.exception.NegocioException;
import com.algafood.domain.model.Pedido;
import com.algafood.domain.model.enums.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;

@Service
public class FluxoPedidoService {
    public static final String MSG_VALIDACAO_STATUS_PEDIDO =
            "Status do pedido %d não pode ser alterado de %s para %s";
    @Autowired
    private EmissaoPedidoService emissaoPedido;

    @Transactional
    public void confirmar(Long pedidoId){

        Pedido pedido = emissaoPedido.buscarPedidoOuFalhar(pedidoId);

        if (!pedido.getStatus().equals(StatusPedido.CRIADO)){
            throw new NegocioException(
                    String.format(MSG_VALIDACAO_STATUS_PEDIDO, pedido.getId(), pedido.getStatus().getDescricao(), StatusPedido.CONFIRMADO.getDescricao()));
        }

        pedido.setStatus(StatusPedido.CONFIRMADO);
        pedido.setDataConfirmacao(OffsetDateTime.now());
    }

    @Transactional
    public void cancelar(Long pedidoId){
        Pedido pedido = emissaoPedido.buscarPedidoOuFalhar(pedidoId);

        if (!pedido.getStatus().equals(StatusPedido.CRIADO)){
            throw new NegocioException(  String.format(MSG_VALIDACAO_STATUS_PEDIDO, pedido.getId(), pedido.getStatus().getDescricao(), StatusPedido.CANCELADO.getDescricao()));
        }

        pedido.setStatus(StatusPedido.CANCELADO);
        pedido.setDataCancelamento(OffsetDateTime.now());
    }

    @Transactional
    public void entregar(Long pedidoId){

        Pedido pedido = emissaoPedido.buscarPedidoOuFalhar(pedidoId);

        if (!pedido.getStatus().equals(StatusPedido.CONFIRMADO)){
            throw new NegocioException(String.format(MSG_VALIDACAO_STATUS_PEDIDO, pedido.getId(),pedido.getStatus().getDescricao(), StatusPedido.ENTREGUE.getDescricao()));
        }

        pedido.setStatus(StatusPedido.ENTREGUE);
        pedido.setDataEntrega(OffsetDateTime.now());
    }
}

