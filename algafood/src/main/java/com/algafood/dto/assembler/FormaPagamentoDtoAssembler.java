package com.algafood.dto.assembler;

import com.algafood.domain.model.Cidade;
import com.algafood.domain.model.FormaPagamento;
import com.algafood.dto.CidadeDTO;
import com.algafood.dto.FormaPagamentoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FormaPagamentoDtoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public FormaPagamentoDTO toModelDTO(FormaPagamento formaPagamento) {
        return modelMapper.map(formaPagamento, FormaPagamentoDTO.class);
    }

    public List<FormaPagamentoDTO> toCollectionModel(Collection<FormaPagamento> formasPagamento){
        return formasPagamento.stream()
                .map(this::toModelDTO)
                .collect(Collectors.toList());
    }
}