package com.cefet.StudioEssencial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cefet.StudioEssencial.dto.UsuarioCreateDTO;
import com.cefet.StudioEssencial.dto.UsuarioDTO;
import com.cefet.StudioEssencial.entities.Pessoa;
import com.cefet.StudioEssencial.entities.Usuario;
import com.cefet.StudioEssencial.repositories.PessoaRepository;
import com.cefet.StudioEssencial.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private PessoaRepository pessoaRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioDTO criarUsuario(UsuarioCreateDTO usuarioCreateDTO){
        if(usuarioRepository.existsByLogin(usuarioCreateDTO.getLogin())){
            throw new IllegalArgumentException("Login já existe.");
        }
        Pessoa pessoa = pessoaRepository.findById(usuarioCreateDTO.getPessoaId())
            .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada."));
        Usuario usuario = new Usuario();
        usuario.setLogin(usuarioCreateDTO.getLogin());
        usuario.setSenha(passwordEncoder.encode(usuarioCreateDTO.getSenha()));
        usuario.setNivelAcesso(usuarioCreateDTO.getNivelAcesso());
        usuario.setPessoa(pessoa);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new UsuarioDTO(usuarioSalvo);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    // Verifica login   
    public boolean existsByLogin(String login) {
        return usuarioRepository.existsByLogin(login);
    }
}