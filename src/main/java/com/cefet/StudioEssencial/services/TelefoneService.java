package com.cefet.StudioEssencial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.StudioEssencial.dto.TelefoneDTO;
import com.cefet.StudioEssencial.entities.Pessoa;
import com.cefet.StudioEssencial.entities.Telefone;
import com.cefet.StudioEssencial.repositories.PessoaRepository;
import com.cefet.StudioEssencial.repositories.TelefoneRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    // Buscar todos os telefones
    public List<TelefoneDTO> findAll() {
        List<Telefone> listaTelefone = telefoneRepository.findAll();
        return listaTelefone.stream().map(TelefoneDTO::new).toList();
    }

    // Buscar por ID
    public TelefoneDTO findById(Long id) {
        Telefone telefone = telefoneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Telefone não encontrado com ID: " + id));
        return new TelefoneDTO(telefone);
    }

    // Inserir Telefone
    public TelefoneDTO insert(TelefoneDTO telefoneDTO) {
        Telefone telefone = new Telefone();
        Pessoa pessoa = pessoaRepository.findById(telefoneDTO.getPessoaId())
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + telefoneDTO.getPessoaId()));
        telefone.setPessoa(pessoa);
        telefone.setTelefone(telefoneDTO.getTelefone());
        Telefone telefoneSalvo = telefoneRepository.save(telefone);
        return new TelefoneDTO(telefoneSalvo);
    }

    // Atualizar Telefone
    public TelefoneDTO update(Long id, TelefoneDTO novoTelefoneDTO) {
        Telefone telefone = telefoneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Telefone não encontrado com ID: " + id));
        Pessoa pessoa = pessoaRepository.findById(novoTelefoneDTO.getPessoaId())
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + novoTelefoneDTO.getPessoaId()));
        telefone.setPessoa(pessoa);
        telefone.setTelefone(novoTelefoneDTO.getTelefone());
        Telefone atualizado = telefoneRepository.save(telefone);
        return new TelefoneDTO(atualizado);
    }

    // Remover por ID
    public void delete(Long id) {
        if (!telefoneRepository.existsById(id)) {
            throw new EntityNotFoundException("Telefone não encontrado com ID: " + id);
        }
        telefoneRepository.deleteById(id);
    }
}