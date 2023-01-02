package com.algafood.api.controller;


import com.algafood.domain.model.Cozinha;
import com.algafood.domain.repository.CozinhaRepository;
import com.algafood.domain.service.CadastroCozinhaService;
import com.algafood.dto.CozinhaDTO;
import com.algafood.dto.assembler.CozinhaDTOAssembler;
import com.algafood.dto.assembler.CozinhaDTOInputDissembler;
import com.algafood.dto.input.CozinhaInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    private CozinhaDTOAssembler cozinhaDtoAssembler;

    @Autowired
    private CozinhaDTOInputDissembler cozinhaDtoInputDissembler;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping
    public Page<CozinhaDTO> listar(@PageableDefault(size = 10) Pageable pageable) {
        Page<Cozinha> cozinhasPage = cadastroCozinha.buscarTodas(pageable);
        List<CozinhaDTO> cozinhaDTO = cozinhaDtoAssembler.toCollectionModel(cozinhasPage.getContent());
        return  new PageImpl<>(cozinhaDTO, pageable, cozinhasPage.getTotalElements());
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
        cozinhaDtoInputDissembler.copyToDomainObject(cozinhaInput, cozinhaAtual);
        cozinhaAtual = cadastroCozinha.salvar(cozinhaAtual);
        return cozinhaDtoAssembler.toModelDTO(cozinhaAtual);
    }

    @DeleteMapping("/{cozinhaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cozinhaId) {
        cadastroCozinha.excluir(cozinhaId);
    }
}
