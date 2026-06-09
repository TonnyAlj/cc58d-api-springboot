package com.solenfrio.apicore.service;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solenfrio.apicore.dto.AreaDTO;
import com.solenfrio.apicore.model.EstacaoClimatica;
import com.solenfrio.apicore.repository.EstacaoRepository;


@Service
public class EstacaoService {

    @Autowired
    private EstacaoRepository estacaoRepository;

    public EstacaoClimatica create(AreaDTO dto) {
        EstacaoClimatica estacao = new EstacaoClimatica();
        estacao.setNome(dto.nome());
        return estacaoRepository.save(estacao);
    }

    public EstacaoClimatica findById(Long id) {
        return estacaoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Estação não encontrada"));
    }

    public @Nullable Object getAll() {
        return estacaoRepository.findAll();
    }

    public @Nullable Object update(Long id, AreaDTO dto) {
        var estacao = estacaoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Estação não encontrada"));

        estacao.setNome(dto.nome());

        return estacaoRepository.save(estacao);
    }

    public void delete(Long id) {
        var estacao = estacaoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Estação não encontrada"));

        estacaoRepository.delete(estacao);
    }

  

}
