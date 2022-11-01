package com.algafood.dto;

import com.algafood.domain.model.Restaurante;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RestauranteDTO {

    private Long restauranteId;
    private String nomeRestaurante;
    private BigDecimal frete;
    private CozinhaDTO cozinha;

}
