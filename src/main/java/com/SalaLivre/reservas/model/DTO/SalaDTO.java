package com.SalaLivre.reservas.model.DTO;

import java.util.List;

public class SalaDTO {
    private String nome;
    private Integer maxAlunos;
    private List<Long> epecId;

    public SalaDTO() {
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMaxAlunos() {
        return maxAlunos;
    }

    public void setMaxAlunos(Integer maxAlunos) {
        this.maxAlunos = maxAlunos;
    }

    public List<Long> getEpecId() {
        return epecId;
    }

    public void setEpecId(List<Long> epecId) {
        this.epecId = epecId;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "nome='" + nome + '\'' +
                ", maximo de alunos='" + maxAlunos + '\'' +
                ", IDespecificações='" + epecId + '\'' +
                '}';
    }

}
