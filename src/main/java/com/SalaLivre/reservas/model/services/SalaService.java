package com.SalaLivre.reservas.model.services;

import java.util.List;
import java.util.Optional;

import com.SalaLivre.reservas.model.entities.Sala;
import com.SalaLivre.reservas.model.repositories.SalaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaService {
    
    @Autowired
    private SalaRepository salaRepository;

    public boolean novaSala(Sala sala) throws Exception {
        if (sala.getNome() == null || sala.getNome().isEmpty()) {
            throw new Exception("Nome da sala é obrigatório!");
        }

        if (sala.getMaxAlunos() == null || sala.getMaxAlunos() <= 0) {
            throw new Exception("Número máximo de alunos inválido!");
        }

        salaRepository.save(sala);
        return true;
    }

    public List<Sala> getSalas() {
        return (List<Sala>) salaRepository.findAll();
    }

    public boolean deletarProduto(Long id) throws Exception {
        if (id == null) {
            throw new Exception("ID inválido.");
        }

        try {
            salaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao deletar sala: " + e.getMessage());
        }
    }

    public boolean atualizarProduto(Long id, Sala sala) throws Exception {

        if (id == null) {
            throw new Exception("ID inválido.");
        }

        Optional<Sala> salaExistente = salaRepository.findById(id);
        if (salaExistente.isEmpty()){
            throw new Exception("Sala com ID:" + id + " não encontrado.");
        }

        if (sala.getNome() == null || sala.getNome().isEmpty()) {
            throw new Exception("Nome da sala é obrigatório!");
        }

        if (sala.getMaxAlunos() == null || sala.getMaxAlunos() <= 0) {
            throw new Exception("Número máximo de alunos inválido!");
        }

        Sala salaParaAtualizar = salaExistente.get();
        salaParaAtualizar.setNome(sala.getNome());
        salaParaAtualizar.setMaxAlunos(sala.getMaxAlunos());
        salaParaAtualizar.setListaEspecificacoes(sala.getListaEspecificacoes());

        try {
            salaRepository.save(salaParaAtualizar);
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar sala: " + e.getMessage());
        }
    }
}
