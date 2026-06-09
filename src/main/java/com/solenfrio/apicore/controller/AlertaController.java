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

import com.solenfrio.apicore.dto.AlertaDTO;
import com.solenfrio.apicore.model.AlertaClima;
import com.solenfrio.apicore.service.AlertaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/alerta")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

   @GetMapping("{id}")
    public AlertaClima get(@PathVariable Long id) {

        return alertaService.findById(id);
    }

    @Operation(summary = "Obter todos os áreas", description = "Retorna todos os áreas")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Áreas encontradas"),
        @ApiResponse(responseCode = "500", description = "Nenhuma área encontrada")
    })        
    @GetMapping(value = {"","/"})
    public ResponseEntity<Object> getAll() {
       
        return ResponseEntity.status(200).body(alertaService.getAll());
    }

    @PostMapping
    public AlertaClima create(@RequestBody @Valid AlertaDTO dto) {
        return alertaService.create(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody @Valid AlertaDTO dto) {
        
        System.out.println("Atualizando alerta " + dto);
        
        return ResponseEntity.status(200).body(alertaService.update(id, dto));

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        System.out.println("Deletando alerta " + id);
        alertaService.delete(id);
    }

}
