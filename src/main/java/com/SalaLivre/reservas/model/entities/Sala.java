package com.SalaLivre.reservas.model.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "salas")
public class Sala {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private List<String> listaEspecificacoes ;
    private Integer maxAlunos;

    public Sala() {

    }

    public Sala(String nome, List<String> especificacoes, Integer maxAlunos) {
        this.setNome(nome);
        this.setListaEspecificacoes(especificacoes);
        this.setMaxAlunos(maxAlunos);
    }

    public Integer getMaxAlunos() {
        return maxAlunos;
    }

    public void setMaxAlunos(Integer maxAlunos) {
        this.maxAlunos = maxAlunos;
    }

    public List<String> getListaEspecificacoes() {
        return listaEspecificacoes;
    }

    public void setListaEspecificacoes(List<String> listaEspecificacoes) {
        this.listaEspecificacoes = listaEspecificacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "nome='" + nome + '\'' +
                ", maximo de alunos='" + maxAlunos + '\'' +
                ", especificações='" + listaEspecificacoes + '\'' +
                '}';
    }
}
