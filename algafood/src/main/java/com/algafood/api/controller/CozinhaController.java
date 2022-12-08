package com.algafood.api.controller;


import com.algafood.domain.model.Cozinha;
import com.algafood.domain.service.CadastroCozinhaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CadastroCozinhaService cadastroCozinhas;

    @GetMapping
    public List<Cozinha> listar() {
        return cadastroCozinhas.buscarTodas();
    }

    @GetMapping("/{cozinhaId}")
    public Cozinha buscar(@PathVariable Long cozinhaId) {
        return cadastroCozinhas.buscarOuFalhar(cozinhaId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody @Valid Cozinha cozinha) {
        return cadastroCozinhas.salvar(cozinha);
    }

    @PutMapping("/{cozinhaId}")
    public Cozinha atualizar(@PathVariable Long cozinhaId, @RequestBody @Valid Cozinha cozinha) {
        Cozinha cozinhaAtual = cadastroCozinhas.buscarOuFalhar(cozinhaId);
        BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
        return cadastroCozinhas.salvar(cozinhaAtual);
    }

    @DeleteMapping("/{cozinhaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cozinhaId) {
        cadastroCozinhas.excluir(cozinhaId);
    }
}
