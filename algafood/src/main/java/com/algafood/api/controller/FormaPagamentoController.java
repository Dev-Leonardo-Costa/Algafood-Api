package com.algafood.api.controller;

import com.algafood.domain.model.FormaPagamento;
import com.algafood.domain.service.CadastroFormaPagamentoService;
import com.algafood.dto.FormaPagamentoDTO;
import com.algafood.dto.assembler.FormaPagamentoDtoAssembler;
import com.algafood.dto.assembler.FormaPagamentoDtoInputDissembler;
import com.algafood.dto.input.FormaPagamentoInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/formas-pagamento")
public class FormaPagamentoController {
    
    @Autowired
    private CadastroFormaPagamentoService cadastroFormaPagamento;

    @Autowired
    private FormaPagamentoDtoAssembler formaPagamentoDtoAssembler;

    @Autowired
    private FormaPagamentoDtoInputDissembler formaPagamentoDtoInputDissembler;

    @GetMapping
    public List<FormaPagamentoDTO> listar(){
        List<FormaPagamento> todasFormaPagamento = cadastroFormaPagamento.buscarTodos();
        return formaPagamentoDtoAssembler.toCollectionModel(todasFormaPagamento);
    }

    @GetMapping("/{formaPagamentoId}")
    public FormaPagamentoDTO buscar(@PathVariable Long formaPagamentoId){
        FormaPagamento formaPagamento = cadastroFormaPagamento.buscarFormaPagamentoOuFalhar(formaPagamentoId);
        return formaPagamentoDtoAssembler.toModelDTO(formaPagamento);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FormaPagamentoDTO adicionar(@RequestBody @Valid FormaPagamentoInput formaPagamentoInput){
        FormaPagamento formaPagamento = formaPagamentoDtoInputDissembler.toDoMainObject(formaPagamentoInput);
        formaPagamento = cadastroFormaPagamento.salvar(formaPagamento);
        return formaPagamentoDtoAssembler.toModelDTO(formaPagamento);
    }

    @PutMapping("/{formaPagamentoId}")
    public FormaPagamentoDTO atulizar(@PathVariable Long formaPagamentoId, @RequestBody @Valid FormaPagamentoInput formaPagamentoInput){
        FormaPagamento pagamentoAtual = cadastroFormaPagamento.buscarFormaPagamentoOuFalhar(formaPagamentoId);
        formaPagamentoDtoInputDissembler.copyToDomainObject(formaPagamentoInput, pagamentoAtual);
        pagamentoAtual = cadastroFormaPagamento.salvar(pagamentoAtual);
        return formaPagamentoDtoAssembler.toModelDTO(pagamentoAtual);
    }

    @DeleteMapping("{formaPagamentoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long formaPagamentoId){
        cadastroFormaPagamento.excluir(formaPagamentoId);
    }

}