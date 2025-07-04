package com.cefet.StudioEssencial.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cefet.StudioEssencial.dto.AgendamentoDTO;
import com.cefet.StudioEssencial.services.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> findById(@PathVariable Long id) {
        AgendamentoDTO agendamentoDTO = agendamentoService.findById(id);
        return ResponseEntity.ok(agendamentoDTO);
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> findAll() {
        List<AgendamentoDTO> agendamentoDTOs = agendamentoService.findAll();
        return ResponseEntity.ok(agendamentoDTOs);
    }

    @PostMapping
    public ResponseEntity<AgendamentoDTO> create(@RequestBody AgendamentoDTO agendamentoDTO) {
        AgendamentoDTO novoAgendamento = agendamentoService.insert(agendamentoDTO);
        return ResponseEntity.status(201).body(novoAgendamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> update(@PathVariable Long id, @RequestBody AgendamentoDTO agendamentoDTO) {
        AgendamentoDTO agendamentoAtualizado = agendamentoService.update(id, agendamentoDTO);
        return ResponseEntity.ok(agendamentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        agendamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/pessoas/{pessoaId}")
    public ResponseEntity<List<AgendamentoDTO>> findByPessoa(@PathVariable Long pessoaId) {
        List<AgendamentoDTO> agendamentos = agendamentoService.findByPessoa(pessoaId);
        return ResponseEntity.ok(agendamentos);
    }
}