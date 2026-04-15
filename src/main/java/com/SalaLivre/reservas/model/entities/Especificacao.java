package com.SalaLivre.reservas.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "especificacoes")
public class Especificacao {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    public Especificacao() {

    }

    public Especificacao(String nome) {
        this.setNome(nome);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                '}';
    }
}
