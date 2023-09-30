package com.guialvesdev.pratica.prova.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tra_trabalho")
public class Trabalho {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;



    private LocalDateTime dataHoraEntrega;


    private String descricao;

    private String grupo;


    private Integer nota;


    private String justificativa;


    public Trabalho(Long id, String titulo, LocalDateTime dataHoraEntrega, String descricao, String grupo, Integer nota, String justificativa) {
        this.id = id;
        this.titulo = titulo;
        this.dataHoraEntrega = dataHoraEntrega;
        this.descricao = descricao;
        this.grupo = grupo;
        this.nota = nota;
        this.justificativa = justificativa;
    }

    public Trabalho() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getDataHoraEntrega() {
        return dataHoraEntrega;
    }

    public void setDataHoraEntrega(LocalDateTime dataHoraEntrega) {
        this.dataHoraEntrega = dataHoraEntrega;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }
}
