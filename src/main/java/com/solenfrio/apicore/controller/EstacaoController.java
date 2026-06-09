package com.solenfrio.apicore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solenfrio.apicore.dto.AreaDTO;
import com.solenfrio.apicore.model.EstacaoClimatica;
import com.solenfrio.apicore.service.EstacaoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/estacao")
public class EstacaoController {
    
    @Autowired
    private EstacaoService estacaoService;


   @GetMapping("{id}")
    public EstacaoClimatica get(@PathVariable Long id) {

        return estacaoService.findById(id);
    }

    @Operation(summary = "Obter todos os áreas", description = "Retorna todos os áreas")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Áreas encontradas"),
        @ApiResponse(responseCode = "500", description = "Nenhuma área encontrada")
    })        
    @GetMapping(value = {"","/"})
    public ResponseEntity<Object> getAll() {
       
        return ResponseEntity.status(200).body(estacaoService.getAll());
    }

    @PostMapping
    public EstacaoClimatica create(@RequestBody @Valid AreaDTO dto) {
        return estacaoService.create(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody @Valid AreaDTO dto) {
        
        System.out.println("Atualizando area " + dto);
        
        return ResponseEntity.ok(estacaoService.update(id, dto));

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        System.out.println("Deletando area " + id);
        estacaoService.delete(id);
    }

}
