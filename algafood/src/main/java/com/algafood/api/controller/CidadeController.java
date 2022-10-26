package com.algafood.api.controller;

import com.algafood.domain.exception.CidadeNaoEncontradoException;
import com.algafood.domain.exception.NegocioException;
import com.algafood.domain.model.Cidade;
import com.algafood.domain.service.CadastroCidadeService;
import org.springframework.beans.BeanUtils;
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

    @GetMapping
    public List<Cidade> buscar() {
        return cadastroCidades.buscarTodas();
    }

    @GetMapping("/{cidadeId}")
    public Cidade buscarPorId(@PathVariable Long cidadeId) {
        return cadastroCidades.buscarCidadeOuFalhar(cidadeId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cidade adicionar(@RequestBody @Valid Cidade cidade){
        try {
            return  cadastroCidades.salvar(cidade);
        }catch (CidadeNaoEncontradoException ex){
            throw new NegocioException(ex.getMessage());
        }
    }

    @DeleteMapping("/{cidadeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cidadeId) {
        cadastroCidades.excluir(cidadeId);
    }

    @PutMapping("/{cidadeId}")
    public Cidade atualizar(@PathVariable Long cidadeId, @RequestBody @Valid Cidade cidade) {
        Cidade cidadeAtual = cadastroCidades.buscarCidadeOuFalhar(cidadeId);
        BeanUtils.copyProperties(cidade, cidadeAtual, "id");

        try {
            return cadastroCidades.salvar(cidadeAtual);
        }catch (CidadeNaoEncontradoException ex){
            throw new NegocioException(ex.getMessage());
        }
    }

}
