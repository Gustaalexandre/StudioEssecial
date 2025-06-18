package com.cefet.StudioEssencial.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cefet.StudioEssencial.dto.ProcedimentoDTO;
import com.cefet.StudioEssencial.services.ProcedimentoService;

@RestController
@RequestMapping("/procedimentos")
public class ProcedimentoController {

    @Autowired
    private ProcedimentoService procedimentoService;

    @GetMapping("/{id}")
    public ResponseEntity<ProcedimentoDTO> findById(@PathVariable Long id) {
        ProcedimentoDTO procedimentoDTO = procedimentoService.findById(id);
        return ResponseEntity.ok(procedimentoDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProcedimentoDTO>> findAll() {
        List<ProcedimentoDTO> procedimentoDTOs = procedimentoService.findAll();
        return ResponseEntity.ok(procedimentoDTOs);
    }

    @PostMapping
    public ResponseEntity<ProcedimentoDTO> create(@RequestBody ProcedimentoDTO procedimentoDTO) {
        ProcedimentoDTO novoProcedimento = procedimentoService.insert(procedimentoDTO);
        return ResponseEntity.status(201).body(novoProcedimento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcedimentoDTO> update(@PathVariable Long id, @RequestBody ProcedimentoDTO procedimentoDTO) {
        ProcedimentoDTO procedimentoAtualizado = procedimentoService.update(id, procedimentoDTO);
        return ResponseEntity.ok(procedimentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        procedimentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}