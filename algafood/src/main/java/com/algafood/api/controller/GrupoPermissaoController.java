package com.algafood.api.controller;

import com.algafood.domain.model.Grupo;
import com.algafood.domain.service.CadastroGrupoService;
import com.algafood.dto.PermissaoDTO;
import com.algafood.dto.assembler.PermissaoDTOAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos/{grupoId}/permissoes")
public class GrupoPermissaoController {

    @Autowired
    private CadastroGrupoService cadastroGrupo;

    @Autowired
    private PermissaoDTOAssembler permissaoDtoAssembler;

    @GetMapping
    public List<PermissaoDTO> listar(@PathVariable Long grupoId) {
        Grupo grupo = cadastroGrupo.buscarGrupoOuFalhar(grupoId);
        return permissaoDtoAssembler.toCollectionModel(grupo.getPermissoes());
    }

    @DeleteMapping("/{permissaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociar(@PathVariable Long grupoId, @PathVariable Long permissaoId ){
        cadastroGrupo.desassociarPermissao(grupoId, permissaoId);
    }

    @PutMapping("/{permissaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associar(@PathVariable Long grupoId, @PathVariable Long permissaoId ){
        cadastroGrupo.associarPermissao(grupoId, permissaoId);
    }

}