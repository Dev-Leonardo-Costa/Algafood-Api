package com.algafood.domain.service;

import com.algafood.domain.exception.NegocioException;
import com.algafood.domain.exception.UsuarioNaoEncontradaException;
import com.algafood.domain.model.Grupo;
import com.algafood.domain.model.Usuario;
import com.algafood.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroUsuarioService {
    public static final String NAO_COINCIDE_COM_A_SENHA_DO_USUARIO = "Senha atual informada não coincide com a senha do usuário.";
    public static final String JA_EXISTE_USUARIO_CADASTRADO_COM_ESSE_EMAIL = "Já existe usuário cadastrado com esse e-mail %s";

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CadastroGrupoService cadastroGrupo;

    @Transactional
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public Usuario salvar(Usuario usuario) {
        usuarioRepository.detach(usuario);

        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioExistente.isPresent() && !usuarioExistente.get().equals(usuario)) {
            throw new NegocioException(String.format(JA_EXISTE_USUARIO_CADASTRADO_COM_ESSE_EMAIL, usuario.getEmail()));
        }

        return usuarioRepository.save(usuario);
    }

    @Transactional
    public void alterarSenha(Long usuarioId, String senhaAtual, String novaSenha) {
        Usuario usuario = buscarUsuarioOuFalhar(usuarioId);

        if (usuario.senhaNaoCoincideCom(senhaAtual)) {
            throw new NegocioException(NAO_COINCIDE_COM_A_SENHA_DO_USUARIO);
        }
        usuario.setSenha(novaSenha);
    }

    public Usuario buscarUsuarioOuFalhar(Long usuarioId) {
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new UsuarioNaoEncontradaException(usuarioId));
    }

    @Transactional
    public void desassociarGrupo(Long usuarioId, Long grupoId) {
        Usuario usuario = buscarUsuarioOuFalhar(usuarioId);
        Grupo grupo = cadastroGrupo.buscarGrupoOuFalhar(grupoId);
        usuario.removerGrupo(grupo);
    }

    @Transactional
    public void associarGrupo(Long usuarioId, Long grupoId) {
        Usuario usuario = buscarUsuarioOuFalhar(usuarioId);
        Grupo grupo = cadastroGrupo.buscarGrupoOuFalhar(grupoId);
        usuario.adicionarrGrupo(grupo);
    }
}
