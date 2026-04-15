package com.SalaLivre.reservas.model.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
@Table(name = "salas")
public class Sala {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @ManyToMany
    @JoinTable(
        name = "sala_especificacao",
        joinColumns = @JoinColumn(name = "sala_id"), 
        inverseJoinColumns = @JoinColumn(name = "especificacao_id")
    )
    private List<Especificacao> listaEspecificacoes ;

    private Integer maxAlunos;

    public Sala() {

    }

    public Sala(String nome, List<Especificacao> especificacoes, Integer maxAlunos) {
        this.setNome(nome);
        this.setListaEspecificacoes(especificacoes);
        this.setMaxAlunos(maxAlunos);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMaxAlunos() {
        return maxAlunos;
    }

    public void setMaxAlunos(Integer maxAlunos) {
        this.maxAlunos = maxAlunos;
    }

    public List<Especificacao> getListaEspecificacoes() {
        return listaEspecificacoes;
    }

    public void setListaEspecificacoes(List<Especificacao> listaEspecificacoes) {
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
