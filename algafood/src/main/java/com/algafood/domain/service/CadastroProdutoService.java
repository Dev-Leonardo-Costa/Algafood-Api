package com.algafood.domain.service;

import com.algafood.domain.exception.ProdutoNaoEncontradaException;
import com.algafood.domain.model.Produto;
import com.algafood.domain.model.Restaurante;
import com.algafood.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CadastroProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public List<Produto> buscarTodos(Restaurante restaurante){
        return produtoRepository.findByRestaurante(restaurante);
    }

    @Transactional
    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto buscarProdutoOuFalhar(Long restauranteId, Long produtoId){
        return produtoRepository.findById(restauranteId, produtoId)
                .orElseThrow(() -> new ProdutoNaoEncontradaException(restauranteId, produtoId));
    }
}