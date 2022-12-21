package com.algafood.dto.assembler;

import com.algafood.domain.model.Produto;
import com.algafood.dto.input.ProdutoInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoDtoInputDissembler {

    @Autowired
    private ModelMapper modelMapper;

    public Produto toDoMainObject(ProdutoInput produtoInput) {
        return modelMapper.map(produtoInput, Produto.class);
    }

    public void copyToDomainObject(ProdutoInput produtoInput, Produto produto) {
        modelMapper.map(produtoInput, produto);
    }
}