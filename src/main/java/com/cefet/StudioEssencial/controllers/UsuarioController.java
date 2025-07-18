package com.cefet.StudioEssencial.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cefet.StudioEssencial.dto.UsuarioCreateDTO;
import com.cefet.StudioEssencial.dto.UsuarioDTO;
import com.cefet.StudioEssencial.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody UsuarioCreateDTO usuarioCreateDTO) {
        try {
            UsuarioDTO novoUsuario = usuarioService.criarUsuario(usuarioCreateDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<UsuarioDTO> listarUsuarios(){
        return usuarioService.listarUsuarios().stream().map(UsuarioDTO::new).toList();
    }

    @GetMapping("/existe")
    public ResponseEntity<Boolean> existsByLogin(@RequestParam String login) {
        boolean existe = usuarioService.existsByLogin(login);
        return ResponseEntity.ok(existe);
    }
}