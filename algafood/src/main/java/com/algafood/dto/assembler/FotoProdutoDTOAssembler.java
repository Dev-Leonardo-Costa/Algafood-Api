package com.algafood.dto.assembler;

import com.algafood.domain.model.FotoProduto;
import com.algafood.dto.FotoProdutoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FotoProdutoDTOAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public FotoProdutoDTO toModelDTO(FotoProduto foto) {
        return modelMapper.map(foto, FotoProdutoDTO.class);
    }

}