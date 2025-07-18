package com.cefet.StudioEssencial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.StudioEssencial.dto.ProcedimentoDTO;
import com.cefet.StudioEssencial.entities.Procedimento;
import com.cefet.StudioEssencial.repositories.ProcedimentoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProcedimentoService {

    @Autowired
    private ProcedimentoRepository procedimentoRepository;

    // Buscar todos os procedimentos
    public List<ProcedimentoDTO> findAll() {
        List<Procedimento> listaProcedimento = procedimentoRepository.findAll();
        return listaProcedimento.stream().map(ProcedimentoDTO::new).toList();
    }

    // Buscar por ID
    public ProcedimentoDTO findById(Long id) {
        Procedimento procedimento = procedimentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Procedimento não encontrado com ID: " + id));
        return new ProcedimentoDTO(procedimento);
    }

    // Inserir Procedimento
    public ProcedimentoDTO insert(ProcedimentoDTO procedimentoDTO) {
        Procedimento procedimento = new Procedimento();
        procedimento.setNome(procedimentoDTO.getNome());
        procedimento.setDescricao(procedimentoDTO.getDescricao());
        procedimento.setPreco(procedimentoDTO.getPreco());
        procedimento.setDuracao(procedimentoDTO.getDuracao());
        Procedimento procedimentoSalvo = procedimentoRepository.save(procedimento);
        return new ProcedimentoDTO(procedimentoSalvo);
    }

    // Atualizar Procedimento
    public ProcedimentoDTO update(Long id, ProcedimentoDTO novoProcedimentoDTO) {
        Procedimento procedimento = procedimentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Procedimento não encontrado com ID: " + id));
        procedimento.setNome(novoProcedimentoDTO.getNome());
        procedimento.setDescricao(novoProcedimentoDTO.getDescricao());
        procedimento.setPreco(novoProcedimentoDTO.getPreco());
        procedimento.setDuracao(novoProcedimentoDTO.getDuracao());
        Procedimento atualizado = procedimentoRepository.save(procedimento);
        return new ProcedimentoDTO(atualizado);
    }

    // Remover por ID
    public void delete(Long id) {
        if (!procedimentoRepository.existsById(id)) {
            throw new EntityNotFoundException("Procedimento não encontrado com ID: " + id);
        }
        procedimentoRepository.deleteById(id);
    }

    public boolean procedimentoExiste(String nome) {
    return procedimentoRepository.existsByNome(nome);
}
}