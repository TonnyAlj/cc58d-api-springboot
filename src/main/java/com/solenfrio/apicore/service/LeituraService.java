package com.solenfrio.apicore.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solenfrio.apicore.dto.LeituraDTO;
import com.solenfrio.apicore.model.LeituraClimatica;
import com.solenfrio.apicore.repository.LeituraRepository;

@Service
public class LeituraService {
    
    @Autowired
    private LeituraRepository leituraRepository;

    public LeituraClimatica create(LeituraDTO dto) {
        LeituraClimatica leitura = new LeituraClimatica();
        BeanUtils.copyProperties(dto, leitura);
        return leituraRepository.save(leitura);
    }

    public LeituraClimatica findById(Long id) {
        return leituraRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Leitura não encontrada"));
    }

    public List<LeituraClimatica> getAll() {
        return leituraRepository.findAll();
    }

    public LeituraClimatica update(Long id, LeituraDTO dto) {
        LeituraClimatica leitura = findById(id);
        BeanUtils.copyProperties(dto, leitura);
        return leituraRepository.save(leitura);
    }

    public void delete(Long id) {
        LeituraClimatica leitura = findById(id);
        leituraRepository.delete(leitura);
    }

}
