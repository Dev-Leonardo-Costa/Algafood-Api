package com.algafood.dto.assembler;

import com.algafood.domain.model.Pedido;
import com.algafood.dto.PedidoDTO;
import com.algafood.dto.PedidoResumoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoResumoDTOAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public PedidoResumoDTO toModelDTO(Pedido pedido) {
        return modelMapper.map(pedido, PedidoResumoDTO.class);
    }

    public List<PedidoResumoDTO> toCollectionModel(List<Pedido> pedidos){
        return pedidos.stream()
                .map(this::toModelDTO)
                .collect(Collectors.toList());
    }
}