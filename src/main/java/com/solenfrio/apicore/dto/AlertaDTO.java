package com.solenfrio.apicore.dto;

import java.time.LocalDate;

import com.solenfrio.apicore.model.EstacaoClimatica;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public record AlertaDTO(
    
    @NotBlank
    @Size(min = 2, max = 100)
    String evento,

    
    @NotBlank
    @Size(min = 2, max = 100)
    String severidade,

    @PastOrPresent
    LocalDate data,
    
    @NotBlank
    @Size(min = 2, max = 100)
    EstacaoClimatica estacao
) {

}
