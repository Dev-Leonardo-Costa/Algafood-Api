package com.algafood.api.controller;

import com.algafood.domain.model.Grupo;
import com.algafood.domain.repository.RestauranteRepository;
import com.algafood.domain.service.CadastroGrupoService;
import com.algafood.dto.GrupoDTO;
import com.algafood.dto.assembler.GrupoDTOAssembler;
import com.algafood.dto.assembler.GrupoDTOInputDissembler;
import com.algafood.dto.input.GrupoInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private CadastroGrupoService cadastroGrupo;

    @Autowired
    private GrupoDTOAssembler grupoDtoAssembler;

    @Autowired
    private GrupoDTOInputDissembler grupoDtoInputDissembler;
    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping
    public List<GrupoDTO> listar(){
        List<Grupo> todosGrupos = cadastroGrupo.buscarTodos();
        return grupoDtoAssembler.toCollectionModel(todosGrupos);
    }

    @GetMapping("/{grupoId}")
    public GrupoDTO buscar(@PathVariable Long grupoId){
        Grupo grupo = cadastroGrupo.buscarGrupoOuFalhar(grupoId);
        return grupoDtoAssembler.toModelDTO(grupo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GrupoDTO adicionar(@RequestBody @Valid GrupoInput grupoInput){
        Grupo grupo = grupoDtoInputDissembler.toDoMainObject(grupoInput);
        grupo = cadastroGrupo.salvar(grupo);
        return grupoDtoAssembler.toModelDTO(grupo);
    }

    @PutMapping("/{grupoId}")
    public GrupoDTO atualizar(@PathVariable Long grupoId, @RequestBody @Valid GrupoInput grupoInput){
        Grupo grupoAtual = cadastroGrupo.buscarGrupoOuFalhar(grupoId);
        grupoDtoInputDissembler.copyToDomainObject(grupoInput, grupoAtual);
        grupoAtual = cadastroGrupo.salvar(grupoAtual);
        return grupoDtoAssembler.toModelDTO(grupoAtual);
    }

    @DeleteMapping("/{grupoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long grupoId){
        cadastroGrupo.excluir(grupoId);
    }
}
