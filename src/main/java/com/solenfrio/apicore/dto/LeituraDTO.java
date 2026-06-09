package com.solenfrio.apicore.dto;

public record LeituraDTO(
    Double temperatura,
    Double umidade,
    Double precipitacao,
    String dataHora,
    Long estacaoId
) {

}
