package com.algafood.api.controller;

import com.algafood.domain.exception.CidadeNaoEncontradaException;
import com.algafood.domain.exception.NegocioException;
import com.algafood.domain.model.Cidade;
import com.algafood.domain.service.CadastroCidadeService;
import com.algafood.dto.CidadeDTO;
import com.algafood.dto.assembler.CidadeDtoAssembler;
import com.algafood.dto.assembler.CidadeDtoInputDissembler;
import com.algafood.dto.input.CidadeInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CadastroCidadeService cadastroCidades;

    @Autowired
    private CidadeDtoAssembler cidadeDtoAssembler;

    @Autowired
    private CidadeDtoInputDissembler cidadeDtoInputDissembler;

    @GetMapping
    public List<CidadeDTO> listar() {
        List<Cidade> todasCidades = cadastroCidades.buscarTodas();
        return cidadeDtoAssembler.toCollectionModel(todasCidades);
    }

    @GetMapping("/{cidadeId}")
    public CidadeDTO buscar(@PathVariable Long cidadeId) {
        Cidade cidade = cadastroCidades.buscarCidadeOuFalhar(cidadeId);
        return cidadeDtoAssembler.toModelDTO(cidade);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CidadeDTO adicionar(@RequestBody @Valid CidadeInput cidadeInput) {
        try {

            Cidade cidade = cidadeDtoInputDissembler.toDoMainObject(cidadeInput);
            cidade = cadastroCidades.salvar(cidade);
            return cidadeDtoAssembler.toModelDTO(cidade);

        } catch (CidadeNaoEncontradaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    @DeleteMapping("/{cidadeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cidadeId) {
        cadastroCidades.excluir(cidadeId);
    }

    @PutMapping("/{cidadeId}")
    public CidadeDTO atualizar(@PathVariable Long cidadeId, @RequestBody @Valid CidadeInput cidadeInput) {

        try {

            Cidade cidadeAtual = cadastroCidades.buscarCidadeOuFalhar(cidadeId);
            cidadeDtoInputDissembler.copyToDomainObject(cidadeInput, cidadeAtual);
            return cidadeDtoAssembler.toModelDTO(cadastroCidades.salvar(cidadeAtual));

        } catch (CidadeNaoEncontradaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

}