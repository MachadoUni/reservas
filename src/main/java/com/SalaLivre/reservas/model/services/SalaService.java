package com.SalaLivre.reservas.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.SalaLivre.reservas.model.DTO.SalaDTO;
import com.SalaLivre.reservas.model.entities.Especificacao;
import com.SalaLivre.reservas.model.entities.Sala;
import com.SalaLivre.reservas.model.repositories.EspecificacaoRepository;
import com.SalaLivre.reservas.model.repositories.SalaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaService {
    
    @Autowired
    private SalaRepository salaRepository;
    @Autowired
    private EspecificacaoRepository especRepository;

    public boolean novaSala(SalaDTO sala) throws Exception {


        if (sala.getNome() == null || sala.getNome().isEmpty()) {
            throw new Exception("Nome da sala é obrigatório!");
        }

        if (sala.getMaxAlunos() == null || sala.getMaxAlunos() <= 0) {
            throw new Exception("Número máximo de alunos inválido!");
        }

        List<Especificacao> especList = new ArrayList<Especificacao>();
        if (sala.getEspecId() != null && !sala.getEspecId().isEmpty()) {
            for(Long id : sala.getEspecId()) {
                Optional<Especificacao> especOpt = especRepository.findById(id);
                if(especOpt.isEmpty()) {
                    throw new Exception("Especificação com id:" + id + " não encontrado.");
                }
                especList.add(especOpt.get());
            }
        }

        Sala novaSala = new Sala();
        novaSala.setNome(sala.getNome());
        novaSala.setMaxAlunos(sala.getMaxAlunos());
        novaSala.setListaEspecificacoes(especList);

        salaRepository.save(novaSala);
        return true;
    }

    public List<Sala> getSalas() {
        return (List<Sala>) salaRepository.findAll();
    }

    public boolean deletarSala(Long id) throws Exception {
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

    public boolean atualizarSala(Long id, SalaDTO sala) throws Exception {

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

        List<Especificacao> especList = new ArrayList<Especificacao>();
        for(Long eId : sala.getEspecId()) {
            Optional<Especificacao> especOpt = especRepository.findById(eId);
            if(especOpt.isEmpty()) {
                throw new Exception("Especificação com id:" + eId + " não encontrado.");
            }
            especList.add(especOpt.get());
        }

        Sala salaParaAtualizar = salaExistente.get();
        salaParaAtualizar.setNome(sala.getNome());
        salaParaAtualizar.setMaxAlunos(sala.getMaxAlunos());
        salaParaAtualizar.setListaEspecificacoes(especList);

        try {
            salaRepository.save(salaParaAtualizar);
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar sala: " + e.getMessage());
        }
    }
}
