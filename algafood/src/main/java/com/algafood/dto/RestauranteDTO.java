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

    public static RestauranteDTO toModelDTO(Restaurante restaurante) {
        CozinhaDTO cozinhaDTO = new CozinhaDTO();
        cozinhaDTO.setId(restaurante.getCozinha().getId());
        cozinhaDTO.setNome(restaurante.getCozinha().getNome());

        RestauranteDTO restauranteDTO = new RestauranteDTO();
        restauranteDTO.setRestauranteId(restaurante.getId());
        restauranteDTO.setRestaurante(restaurante.getNome());
        restauranteDTO.setFrete(restaurante.getTaxaFrete());
        restauranteDTO.setCozinha(cozinhaDTO);
        return restauranteDTO;
    }

    public static Restaurante toDoMainObject(RestauranteInput restauranteInput){
        Restaurante restaurante = new Restaurante();
        restaurante.setNome(restauranteInput.getNome());
        restaurante.setTaxaFrete(restauranteInput.getTaxaFrete());

        Cozinha cozinha = new Cozinha();
        cozinha.setId(restauranteInput.getCozinha().getId());

        restaurante.setCozinha(cozinha);

        return restaurante;
    }

    public static List<RestauranteDTO> toCollectionModel(List<Restaurante> restaurantes){
        return restaurantes.stream()
                .map(restaurante -> toModelDTO(restaurante))
                .collect(Collectors.toList());
    }
}