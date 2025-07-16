package com.cefet.StudioEssencial.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cefet.StudioEssencial.dto.TelefoneDTO;
import com.cefet.StudioEssencial.services.TelefoneService;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {

    @Autowired
    private TelefoneService telefoneService;

    @GetMapping("/{id}")
    public ResponseEntity<TelefoneDTO> findById(@PathVariable Long id) {
        TelefoneDTO telefoneDTO = telefoneService.findById(id);
        return ResponseEntity.ok(telefoneDTO);
    }

    @GetMapping
    public ResponseEntity<List<TelefoneDTO>> findAll() {
        List<TelefoneDTO> telefoneDTOs = telefoneService.findAll();
        return ResponseEntity.ok(telefoneDTOs);
    }

    @PostMapping
    public ResponseEntity<TelefoneDTO> create(@RequestBody TelefoneDTO telefoneDTO) {
        TelefoneDTO novoTelefone = telefoneService.insert(telefoneDTO);
        return ResponseEntity.status(201).body(novoTelefone);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelefoneDTO> update(@PathVariable Long id, @RequestBody TelefoneDTO telefoneDTO) {
        TelefoneDTO telefoneAtualizado = telefoneService.update(id, telefoneDTO);
        return ResponseEntity.ok(telefoneAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        telefoneService.delete(id);
        return ResponseEntity.noContent().build();
    }
}