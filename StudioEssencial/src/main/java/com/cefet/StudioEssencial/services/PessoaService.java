package com.cefet.StudioEssencial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.StudioEssencial.dto.PessoaDTO;
import com.cefet.StudioEssencial.entities.Pessoa;
import com.cefet.StudioEssencial.repositories.PessoaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    // Buscar todos as pessoas
    public List<PessoaDTO> findAll() {
        List<Pessoa> listaPessoa = pessoaRepository.findAll();
        return listaPessoa.stream().map(PessoaDTO::new).toList();
    }

    // Buscar por ID
    public PessoaDTO findById(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrado com ID: " + id));
        return new PessoaDTO(pessoa);
    }

    // Inserir Pessoa
    public PessoaDTO insert(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setSexo(pessoaDTO.getSexo());
        pessoa.setEndereco(pessoaDTO.getEndereco());
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return new PessoaDTO(pessoaSalva);
    }

    // Atualizar Pessoa
    public PessoaDTO update(Long id, PessoaDTO novaPessoaDTO) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrado com ID: " + id));
        pessoa.setNome(novaPessoaDTO.getNome());
        pessoa.setSexo(novaPessoaDTO.getSexo());
        pessoa.setEndereco(novaPessoaDTO.getEndereco());
        Pessoa atualizada = pessoaRepository.save(pessoa);
        return new PessoaDTO(atualizada);
    }

    // Remover por ID
    public void delete(Long id) {
        if (!pessoaRepository.existsById(id)) {
            throw new EntityNotFoundException("Tipo não encontrado com ID: " + id);
        }
        pessoaRepository.deleteById(id);
    }

}
