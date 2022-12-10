package com.algafood.dto;

import com.algafood.domain.model.Cozinha;
import com.algafood.domain.model.Restaurante;
import com.algafood.dto.input.RestauranteInput;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class RestauranteDTO {

    private Long restauranteId;
    private String restaurante;
    private BigDecimal frete;
    private CozinhaDTO cozinha;

}