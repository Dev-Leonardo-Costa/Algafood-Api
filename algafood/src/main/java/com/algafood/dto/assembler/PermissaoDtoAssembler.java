package com.algafood.dto.assembler;

import com.algafood.domain.model.Cidade;
import com.algafood.domain.model.Permissao;
import com.algafood.dto.CidadeDTO;
import com.algafood.dto.PermissaoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PermissaoDtoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public PermissaoDTO toModelDTO(Permissao permissao) {
        return modelMapper.map(permissao, PermissaoDTO.class);
    }

    public List<PermissaoDTO> toCollectionModel(Collection<Permissao> permissoes){
        return  permissoes.stream()
                .map(this::toModelDTO)
                .collect(Collectors.toList());
    }
}