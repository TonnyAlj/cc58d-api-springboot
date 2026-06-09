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
@Table(name = "alerta_clima")
@Data
public class AlertaClima extends BaseEntity{

    @Column(name="evento", length = 100, nullable = false)
    public String evento;

    @Column(name="severidade", length = 200, nullable = false)
    public String severidade;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "estacao_id")
    public EstacaoClimatica estacao;
}
