package com.SalaLivre.reservas.controller;

import java.util.List;

import com.SalaLivre.reservas.model.entities.Especificacao;
import com.SalaLivre.reservas.model.services.EspecificacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping("/especificacoes")
public class EspecificacaoController {
    
    private EspecificacaoService especService;

    @Autowired
    public EspecificacaoController(EspecificacaoService especService) {
        this.especService = especService;
    }

    @PostMapping("/novo")
    public ResponseEntity<?> novoProduto(@RequestBody Especificacao espec) {
        try {
            especService.novaEspecificacao(espec);
            return ResponseEntity.ok("Especificação criado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Especificacao>> getEspecificacao() {
        List<Especificacao> especificacaos = especService.getEspecs();
        return ResponseEntity.ok(especificacaos);
    }
}
