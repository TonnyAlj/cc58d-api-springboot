package com.solenfrio.apicore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EstacaoDTO(   
    @NotBlank
    @Size(min = 2, max = 100)
    String nome,

    @NotBlank
    @Size(min = 2, max = 100)
    String cidade,

    @NotNull
    Double latitude,

    @NotNull
    Double longitude
) {



}
