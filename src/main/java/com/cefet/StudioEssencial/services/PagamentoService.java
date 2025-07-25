package com.cefet.StudioEssencial.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cefet.StudioEssencial.dto.PagamentoDTO;
import com.cefet.StudioEssencial.entities.Agendamento;
import com.cefet.StudioEssencial.entities.Pagamento;
import com.cefet.StudioEssencial.repositories.AgendamentoRepository;
import com.cefet.StudioEssencial.repositories.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    // Buscar todos os pagamentos
    public List<PagamentoDTO> findAll() {
        return pagamentoRepository.findAll().stream()
                .map(PagamentoDTO::new)
                .toList();
    }

    // Buscar por ID
    public PagamentoDTO findById(Long id) {
        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pagamento não encontrado com ID: " + id));
        return new PagamentoDTO(pagamento);
    }

    // Inserir Pagamento
    // ...existing code...
    public PagamentoDTO insert(PagamentoDTO pagamentoDTO) {
        Agendamento agendamento = agendamentoRepository.findById(pagamentoDTO.getAgendamentoId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Agendamento não encontrado com ID: " + pagamentoDTO.getAgendamentoId()));
        Pagamento pagamento = new Pagamento();
        pagamento.setAgendamento(agendamento);
        pagamento.setValor(pagamentoDTO.getValor());
        pagamento.setDataPagamento(pagamentoDTO.getDataPagamento());
        pagamento.setDataVencimento(pagamentoDTO.getDataVencimento());
        pagamento.setFormaPagamento(pagamentoDTO.getFormaPagamento());
        pagamento.setNumeroParcela(pagamentoDTO.getNumeroParcela());
        Pagamento pagamentoSalvo = pagamentoRepository.save(pagamento);
        return new PagamentoDTO(pagamentoSalvo);
    }
    // ...existing code...

    // Atualizar Pagamento
    public PagamentoDTO update(Long id, PagamentoDTO novoPagamentoDTO) {
        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pagamento não encontrado com ID: " + id));
        Agendamento agendamento = agendamentoRepository.findById(novoPagamentoDTO.getAgendamentoId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Agendamento não encontrado com ID: " + novoPagamentoDTO.getAgendamentoId()));
        pagamento.setAgendamento(agendamento);
        pagamento.setValor(novoPagamentoDTO.getValor());
        pagamento.setDataVencimento(novoPagamentoDTO.getDataVencimento());
        pagamento.setFormaPagamento(novoPagamentoDTO.getFormaPagamento());
        pagamento.setNumeroParcela(novoPagamentoDTO.getNumeroParcela());
        Pagamento atualizado = pagamentoRepository.save(pagamento);
        return new PagamentoDTO(atualizado);
    }

    // Remover por ID
    public void delete(Long id) {
        if (!pagamentoRepository.existsById(id)) {
            throw new EntityNotFoundException("Pagamento não encontrado com ID: " + id);
        }
        pagamentoRepository.deleteById(id);
    }

    // Buscar por Agendamento
    public List<PagamentoDTO> findByAgendamento(Long agendamentoId) {
        Agendamento agendamento = agendamentoRepository.findById(agendamentoId)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado com ID: " + agendamentoId));
        return pagamentoRepository.findAll().stream()
                .filter(p -> p.getAgendamento().equals(agendamento))
                .map(PagamentoDTO::new)
                .toList();
    }
}