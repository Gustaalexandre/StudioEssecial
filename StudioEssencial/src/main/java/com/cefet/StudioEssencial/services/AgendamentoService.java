package com.cefet.StudioEssencial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.StudioEssencial.dto.AgendamentoDTO;
import com.cefet.StudioEssencial.dto.ProcedimentoDTO;
import com.cefet.StudioEssencial.entities.Agendamento;
import com.cefet.StudioEssencial.entities.Pessoa;
import com.cefet.StudioEssencial.entities.Procedimento;
import com.cefet.StudioEssencial.repositories.AgendamentoRepository;
import com.cefet.StudioEssencial.repositories.PessoaRepository;
import com.cefet.StudioEssencial.repositories.ProcedimentoRepository;
import com.cefet.StudioEssencial.repositories.TelefoneRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AgendamentoService {

        @Autowired
        private AgendamentoRepository agendamentoRepository;
        @Autowired
        private PessoaRepository pessoaRepository;
        @Autowired
        private ProcedimentoRepository procedimentoRepository;

        // Buscar todos os agendamentos
        public List<AgendamentoDTO> findAll() {
                return agendamentoRepository.findAll().stream()
                                .map(AgendamentoDTO::new)
                                .toList();
        }

        // Buscar por ID
        public AgendamentoDTO findById(Long id) {
                Agendamento agendamento = agendamentoRepository.findById(id)
                                .orElseThrow(() -> new EntityNotFoundException(
                                                "Agendamento não encontrado com ID: " + id));
                return new AgendamentoDTO(agendamento);
        }

        public AgendamentoDTO insert(AgendamentoDTO agendamentoDTO) {
                Agendamento agendamento = new Agendamento();
                agendamento.setData(agendamentoDTO.getData());
                agendamento.setSituacao(agendamentoDTO.getSituacao());
                agendamento.setNumeroParcelas(agendamentoDTO.getNumeroParcelas());
                agendamento.setValorTotal(agendamentoDTO.getValorTotal());

                // Corrigido: buscar pessoa e procedimento pelo ID
                agendamento.setPessoa(
                                pessoaRepository.findById(agendamentoDTO.getPessoaId())
                                                .orElseThrow(() -> new EntityNotFoundException(
                                                                "Pessoa não encontrada com ID: "
                                                                                + agendamentoDTO.getPessoaId())));
                agendamento.setProcedimento(
                                procedimentoRepository.findById(agendamentoDTO.getProcedimentoId())
                                                .orElseThrow(() -> new EntityNotFoundException(
                                                                "Procedimento não encontrado com ID: "
                                                                                + agendamentoDTO.getProcedimentoId())));

                Agendamento agendamentoSalvo = agendamentoRepository.save(agendamento);
                return new AgendamentoDTO(agendamentoSalvo);
        }

        // Atualizar Pessoa
        public AgendamentoDTO update(Long id, AgendamentoDTO novoAgendamentoDTO) {
                Agendamento agendamento = agendamentoRepository.findById(id)
                                .orElseThrow(() -> new EntityNotFoundException(
                                                "Agendamento não encontrado com ID: " + id));
                agendamento.setData(novoAgendamentoDTO.getData());
                agendamento.setSituacao(novoAgendamentoDTO.getSituacao());
                agendamento.setNumeroParcelas(novoAgendamentoDTO.getNumeroParcelas());
                agendamento.setValorTotal(novoAgendamentoDTO.getValorTotal());
                // Corrigido: buscar pessoa e procedimento pelo ID
                agendamento.setPessoa(
                                pessoaRepository.findById(novoAgendamentoDTO.getPessoaId())
                                                .orElseThrow(() -> new EntityNotFoundException(
                                                                "Pessoa não encontrada com ID: "
                                                                                + novoAgendamentoDTO.getPessoaId())));
                agendamento.setProcedimento(
                                procedimentoRepository.findById(novoAgendamentoDTO.getProcedimentoId())
                                                .orElseThrow(() -> new EntityNotFoundException(
                                                                "Procedimento não encontrado com ID: "
                                                                                + novoAgendamentoDTO
                                                                                                .getProcedimentoId())));
                Agendamento atualizado = agendamentoRepository.save(agendamento);
                return new AgendamentoDTO(atualizado);
        }

        // Remover por ID
        public void delete(Long id) {
                if (!agendamentoRepository.existsById(id)) {
                        throw new EntityNotFoundException("Agendamento não encontrado com ID: " + id);
                }
                agendamentoRepository.deleteById(id);
        }

        // Buscar por Pessoa
        public List<AgendamentoDTO> findByPessoa(Long pessoaId) {
                Pessoa pessoa = pessoaRepository.findById(pessoaId)
                                .orElseThrow(() -> new EntityNotFoundException(
                                                "Pessoa não encontrada com ID: " + pessoaId));
                return agendamentoRepository.findAll().stream()
                                .filter(a -> a.getPessoa().equals(pessoa))
                                .map(AgendamentoDTO::new)
                                .toList();
        }

}