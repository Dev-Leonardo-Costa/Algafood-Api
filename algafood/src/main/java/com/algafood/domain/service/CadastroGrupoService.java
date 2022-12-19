package com.algafood.domain.service;

import com.algafood.domain.exception.CidadeNaoEncontradaException;
import com.algafood.domain.exception.EntidadeEmUsoException;
import com.algafood.domain.exception.GrupoNaoEncontradaException;
import com.algafood.domain.model.Cidade;
import com.algafood.domain.model.Estado;
import com.algafood.domain.model.Grupo;
import com.algafood.domain.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CadastroGrupoService {

    public static final String MSG_GRUPO_ENCONTRA_SE_EM_USO
            = "Grupo de código %d não pode ser removida: Encontra-se em uso";
    @Autowired
    private GrupoRepository grupoRepository;

    @Transactional
    public List<Grupo> buscarTodos() {
        return grupoRepository.findAll();
    }

    @Transactional
    public Grupo salvar(Grupo grupo){
        return grupoRepository.save(grupo);
    }

    @Transactional
    public void excluir(Long grupoId){
        try {

            grupoRepository.deleteById(grupoId);
            grupoRepository.flush();

        }catch (EmptyResultDataAccessException ex){
            throw new GrupoNaoEncontradaException(grupoId);

        }catch (DataIntegrityViolationException ex){
            throw  new EntidadeEmUsoException(
                    String.format(MSG_GRUPO_ENCONTRA_SE_EM_USO, grupoId));
        }
    }

    public Grupo buscarGrupoOuFalhar(Long grupoId){
        return grupoRepository.findById(grupoId)
                .orElseThrow(() -> new GrupoNaoEncontradaException(grupoId));
    }

}