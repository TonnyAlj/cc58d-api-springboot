package com.solenfrio.apicore.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solenfrio.apicore.dto.AlertaDTO;
import com.solenfrio.apicore.model.AlertaClima;
import com.solenfrio.apicore.repository.AlertaRepository;


@Service
public class AlertaService {
    
    @Autowired
    private AlertaRepository alertaRepository;

    public AlertaClima create(AlertaDTO dto) {
        AlertaClima alerta = new AlertaClima();
        BeanUtils.copyProperties(dto, alerta);
        return alertaRepository.save(alerta);
    }

    public AlertaClima findById(Long id) {
        return alertaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Alerta não encontrado"));
    }

    public List<AlertaClima> getAll() {
        return alertaRepository.findAll();
    }

    public AlertaClima update(Long id, AlertaDTO dto) {
        AlertaClima alerta = findById(id);
        BeanUtils.copyProperties(dto, alerta);
        return alertaRepository.save(alerta);
    }

    public void delete(Long id) {
        AlertaClima alerta = findById(id);
        alertaRepository.delete(alerta);
    }

}

