package com.algafood.api.controller;


import com.algafood.domain.exception.CidadeNaoEncontradaException;
import com.algafood.domain.exception.NegocioException;
import com.algafood.domain.model.Cidade;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.model.Estado;
import com.algafood.domain.service.CadastroCozinhaService;
import com.algafood.dto.CozinhaDTO;
import com.algafood.dto.EstadoDTO;
import com.algafood.dto.assembler.CozinhaDtoAssembler;
import com.algafood.dto.assembler.CozinhaDtoInputDissembler;
import com.algafood.dto.input.CozinhaInput;
import com.algafood.dto.input.EstadoInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CadastroCozinhaService cadastroCozinha;

    @Autowired
    private CozinhaDtoAssembler cozinhaDtoAssembler;

    @Autowired
    private CozinhaDtoInputDissembler cozinhaDtoInputDissembler;

    @GetMapping
    public List<CozinhaDTO> listar() {
        List<Cozinha> todasCozinhas = cadastroCozinha.buscarTodas();
        return cozinhaDtoAssembler.toCollectionModel(todasCozinhas);
    }

    @GetMapping("/{cozinhaId}")
    public CozinhaDTO buscar(@PathVariable Long cozinhaId) {
        Cozinha cozinha = cadastroCozinha.buscarOuFalhar(cozinhaId);
        return cozinhaDtoAssembler.toModelDTO(cozinha);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CozinhaDTO adicionar(@RequestBody @Valid CozinhaInput cozinhaInput) {
        Cozinha cozinha = cozinhaDtoInputDissembler.toDoMainObject(cozinhaInput);
        cozinha = cadastroCozinha.salvar(cozinha);
        return cozinhaDtoAssembler.toModelDTO(cozinha);
    }

    @PutMapping("/{cozinhaId}")
    public CozinhaDTO atualizar(@PathVariable Long cozinhaId, @RequestBody @Valid CozinhaInput cozinhaInput) {
        Cozinha cozinhaAtual = cadastroCozinha.buscarOuFalhar(cozinhaId);
        cozinhaDtoInputDissembler.copyToDomainObjetct(cozinhaInput, cozinhaAtual);
        cozinhaAtual = cadastroCozinha.salvar(cozinhaAtual);
        return cozinhaDtoAssembler.toModelDTO(cozinhaAtual);
    }

    @DeleteMapping("/{cozinhaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cozinhaId) {
        cadastroCozinha.excluir(cozinhaId);
    }
}
