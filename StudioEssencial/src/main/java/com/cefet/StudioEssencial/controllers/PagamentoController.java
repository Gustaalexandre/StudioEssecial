package com.cefet.StudioEssencial.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cefet.StudioEssencial.dto.PagamentoDTO;
import com.cefet.StudioEssencial.services.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDTO> findById(@PathVariable Long id) {
        PagamentoDTO pagamentoDTO = pagamentoService.findById(id);
        return ResponseEntity.ok(pagamentoDTO);
    }

    @GetMapping
    public ResponseEntity<List<PagamentoDTO>> findAll() {
        List<PagamentoDTO> pagamentoDTOs = pagamentoService.findAll();
        return ResponseEntity.ok(pagamentoDTOs);
    }

    @PostMapping
    public ResponseEntity<PagamentoDTO> create(@RequestBody PagamentoDTO pagamentoDTO) {
        PagamentoDTO novoPagamento = pagamentoService.insert(pagamentoDTO);
        return ResponseEntity.status(201).body(novoPagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagamentoDTO> update(@PathVariable Long id, @RequestBody PagamentoDTO pagamentoDTO) {
        PagamentoDTO pagamentoAtualizado = pagamentoService.update(id, pagamentoDTO);
        return ResponseEntity.ok(pagamentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pagamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/agendamentos/{agendamentoId}")
    public ResponseEntity<List<PagamentoDTO>> findByAgendamento(@PathVariable Long agendamentoId) {
        List<PagamentoDTO> pagamentos = pagamentoService.findByAgendamento(agendamentoId);
        return ResponseEntity.ok(pagamentos);
    }
}