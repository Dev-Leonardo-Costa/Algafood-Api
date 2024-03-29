package com.algafood.domain.service;

import com.algafood.domain.exception.PermissaoNaoEncontradaException;
import com.algafood.domain.model.Permissao;
import com.algafood.domain.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroPermissaoService {
    @Autowired
    private PermissaoRepository permissaoRepository;

    public Permissao buscarPermissaoOuFalhar(Long cidadeId) {
        return permissaoRepository.findById(cidadeId)
                .orElseThrow(() -> new PermissaoNaoEncontradaException(cidadeId));
    }
}