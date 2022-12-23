package com.algafood.dto.assembler;

import com.algafood.domain.model.FormaPagamento;
import com.algafood.dto.input.FormaPagamentoInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FormaPagamentoDTOInputDissembler {

    @Autowired
    private ModelMapper modelMapper;

    public FormaPagamento toDoMainObject(FormaPagamentoInput formaPagamentoInput) {
        return modelMapper.map(formaPagamentoInput, FormaPagamento.class);
    }

    public void copyToDomainObject(FormaPagamentoInput formaPagamentoInput, FormaPagamento formaPagamento) {
        modelMapper.map(formaPagamentoInput, formaPagamento);
    }
}