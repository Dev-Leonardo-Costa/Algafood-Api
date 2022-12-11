package com.algafood.dto.assembler;

import com.algafood.domain.model.Restaurante;
import com.algafood.dto.CozinhaDTO;
import com.algafood.dto.RestauranteDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestauranteDtoAssembler {

    public RestauranteDTO toModelDTO(Restaurante restaurante) {
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
    public List<RestauranteDTO> toCollectionModel(List<Restaurante> restaurantes){
        return restaurantes.stream()
                .map(this::toModelDTO)
                .collect(Collectors.toList());
    }
}