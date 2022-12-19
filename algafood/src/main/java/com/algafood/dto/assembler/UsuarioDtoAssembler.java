package com.algafood.dto.assembler;

import com.algafood.domain.model.Cidade;
import com.algafood.domain.model.Usuario;
import com.algafood.dto.CidadeDTO;
import com.algafood.dto.UsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioDtoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public UsuarioDTO toModelDTO(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    public List<UsuarioDTO> toCollectionModel(List<Usuario> usuarios){
        return usuarios.stream()
                .map(this::toModelDTO)
                .collect(Collectors.toList());
    }
}