package com.algafood.api.controller;

import com.algafood.domain.model.Usuario;
import com.algafood.domain.service.CadastroUsuarioService;
import com.algafood.dto.GrupoDTO;
import com.algafood.dto.assembler.GrupoDTOAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios/{usuarioId}/grupos")
public class UsuarioGrupoController {

    @Autowired
    private CadastroUsuarioService cadastroUsuario;

    @Autowired
    private GrupoDTOAssembler grupoDtoAssembler;

    @GetMapping
    public List<GrupoDTO> listar(@PathVariable Long usuarioId) {
        Usuario usuario = cadastroUsuario.buscarUsuarioOuFalhar(usuarioId);
        return grupoDtoAssembler.toCollectionModel(usuario.getGrupos());
    }

    @DeleteMapping("/{grupoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociar(@PathVariable Long usuarioId,@PathVariable Long grupoId){
        cadastroUsuario.desassociarGrupo(usuarioId,grupoId);
    }

    @PutMapping("/{grupoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associar(@PathVariable Long usuarioId,@PathVariable Long grupoId){
        cadastroUsuario.associarGrupo(usuarioId, grupoId);
    }
}