package com.algafood.core.modelmapper;

import com.algafood.domain.model.Endereco;
import com.algafood.dto.EnderecoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

//        modelMapper.createTypeMap(Restaurante.class, RestauranteDTO.class)
//                .addMapping(Restaurante::getTaxaFrete, RestauranteDTO::setPrecoFrete);
        var enderecoToEnderecoModelTypeMap = modelMapper.createTypeMap(
                Endereco.class, EnderecoDTO.class);

        enderecoToEnderecoModelTypeMap.<String>addMapping(
            enderecoSrc -> enderecoSrc.getCidade().getEstado().getNome(),
                (enderecoDestino, value) -> enderecoDestino.getCidade().setEstado(value));

        return modelMapper;
    }

}
