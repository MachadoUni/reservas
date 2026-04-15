package com.SalaLivre.reservas.model.DTO;

import java.util.ArrayList;
import java.util.List;

public class SalaDTO {
    private String nome;
    private Integer maxAlunos;
    private List<Long> especId = new ArrayList<Long>();

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

    public List<Long> getEspecId() {
        return especId;
    }

    public void setEspecId(List<Long> especId) {
        this.especId = especId;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "nome='" + nome + '\'' +
                ", maximo de alunos='" + maxAlunos + '\'' +
                ", IDespecificações='" + especId + '\'' +
                '}';
    }

}
