package com.SalaLivre.reservas.model.services;

import java.util.List;

import com.SalaLivre.reservas.model.entities.Especificacao;
import com.SalaLivre.reservas.model.repositories.EspecificacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecificacaoService {
    
    @Autowired
    private EspecificacaoRepository especificacaoRepository;

    public boolean novaEspecificacao (Especificacao espec) throws Exception {
        
        if (espec.getNome() == null || espec.getNome().isEmpty()) {
            throw new Exception("Nome da especificação é obrigatório!");
        }

        especificacaoRepository.save(espec);
        return true;
    }

    public List<Especificacao> getEspecs() {
        return (List<Especificacao>) especificacaoRepository.findAll();
    }

    public boolean deletarEspec(Long id) throws Exception {
        if (id == null) {
            throw new Exception("ID inválido.");
        }

        try {
            especificacaoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao deletar especificação: " + e.getMessage());
        }
    }

}
