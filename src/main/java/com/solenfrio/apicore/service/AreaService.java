package com.solenfrio.apicore.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solenfrio.apicore.dto.AreaDTO;
import com.solenfrio.apicore.model.Area;
import com.solenfrio.apicore.repository.AreaRepository;

@Service
public class AreaService {
    
    @Autowired
    private AreaRepository areaRepository;

    public Area create(AreaDTO dto) {
        Area area = new Area();
        BeanUtils.copyProperties(dto, area);
        return areaRepository.save(area);
    }

    public Area findById(Long id) {
        return areaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Area não encontrada"));
    }

    public List<Area> getAll() {
        return areaRepository.findAll();
    }

    public Area update(Long id, AreaDTO dto) {
        Area area = findById(id);
        BeanUtils.copyProperties(dto, area);
        return areaRepository.save(area);
    }

    public void delete(Long id) {
        Area area = findById(id);
        areaRepository.delete(area);
    }

}
