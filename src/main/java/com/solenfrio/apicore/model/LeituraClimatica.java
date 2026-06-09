package com.solenfrio.apicore.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Entity     
@Table(name = "leitura_climatica")
@Data
public class LeituraClimatica extends BaseEntity {

    @Column(name="temperatura", nullable = false)
    public Double temperatura;

    @Column(name="umidade", nullable = false)
    public Double umidade;

    @Column(name="precipitacao", nullable = false)
    public Double precipitacao;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "estacao_id")
    public EstacaoClimatica estacao;

}
