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

import com.solenfrio.apicore.dto.LeituraDTO;
import com.solenfrio.apicore.model.LeituraClimatica;
import com.solenfrio.apicore.service.LeituraService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/leitura")
public class LeituraController {

    @Autowired
    private LeituraService leituraService;

   @GetMapping("{id}")
    public LeituraClimatica get(@PathVariable Long id) {

        return leituraService.findById(id);
    }

    @Operation(summary = "Obter todos os dados de leitura", description = "Retorna todos os dados de leitura")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Dados de leitura encontrados"),
        @ApiResponse(responseCode = "500", description = "Nenhum dado de leitura encontrado")
    })        
    @GetMapping(value = {"","/"})
    public ResponseEntity<Object> getAll() {
       
        return ResponseEntity.status(200).body(leituraService.getAll());
    }

    @PostMapping
    public LeituraClimatica create(@RequestBody @Valid LeituraDTO dto) {
        return leituraService.create(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody @Valid LeituraDTO dto) {
        System.out.println("Atualizando leitura " + dto);
        
        return ResponseEntity.status(200).body(leituraService.update(id, dto));

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        System.out.println("Deletando leitura " + id);
        leituraService.delete(id);
    }

}
