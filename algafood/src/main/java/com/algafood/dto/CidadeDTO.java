package com.algafood.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeDTO {

    private Long cidadeId;
    private String cidadeNome;
    private EstadoDTO estado;

}
