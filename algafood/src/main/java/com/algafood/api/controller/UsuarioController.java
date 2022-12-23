package com.algafood.api.controller;

import com.algafood.domain.model.Usuario;
import com.algafood.domain.service.CadastroUsuarioService;
import com.algafood.dto.UsuarioDTO;
import com.algafood.dto.assembler.UsuarioDTOAssembler;
import com.algafood.dto.assembler.UsuarioDTOInputDissembler;
import com.algafood.dto.input.SenhaInput;
import com.algafood.dto.input.UsuarioComSenhaInput;
import com.algafood.dto.input.UsuarioInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private CadastroUsuarioService cadastroUsuario;

    @Autowired
    private UsuarioDTOAssembler usuarioDtoAssembler;

    @Autowired
    private UsuarioDTOInputDissembler usuarioDtoInputDissembler;

    @GetMapping
    public List<UsuarioDTO> listar(){
         List<Usuario> todosUsuarios = cadastroUsuario.buscarTodos();
         return usuarioDtoAssembler.toCollectionModel(todosUsuarios);
    }

    @GetMapping("/{usuarioId}")
    public UsuarioDTO buscar(@PathVariable Long usuarioId){
        Usuario usuario = cadastroUsuario.buscarUsuarioOuFalhar(usuarioId);
        return usuarioDtoAssembler.toModelDTO(usuario);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO adicionar(@RequestBody @Valid UsuarioComSenhaInput usuarioInput){
        Usuario usuario = usuarioDtoInputDissembler.toDoMainObject(usuarioInput);
        usuario = cadastroUsuario.salvar(usuario);
        return usuarioDtoAssembler.toModelDTO(usuario);
    }

    @PutMapping("/{usuarioId}")
    public UsuarioDTO atualizar(@PathVariable Long usuarioId, @RequestBody @Valid UsuarioInput usuarioInput){
        Usuario usuarioAtual = cadastroUsuario.buscarUsuarioOuFalhar(usuarioId);
        usuarioDtoInputDissembler.copyToDomainObject(usuarioInput, usuarioAtual);
        usuarioAtual = cadastroUsuario.salvar(usuarioAtual);
        return usuarioDtoAssembler.toModelDTO(usuarioAtual);
    }

    @PutMapping("/{usuarioId}/senha")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarSenha(@PathVariable Long usuarioId,@RequestBody @Valid SenhaInput senha){
        cadastroUsuario.alterarSenha(usuarioId, senha.getSenhaAtual(), senha.getNovaSenha());
    }

}