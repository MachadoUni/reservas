package com.SalaLivre.reservas.controller;

import com.SalaLivre.reservas.model.services.SalaService;
import com.SalaLivre.reservas.model.entities.Sala;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salas")
public class SalaController {
    
    private SalaService salaService;

    @Autowired
    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @PostMapping("/novo")
    public ResponseEntity<?> novoSala(@RequestBody Sala sala) {
        try {
            salaService.novaSala(sala);
            return ResponseEntity.ok("Sala criado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } 
    }

    @GetMapping
    public ResponseEntity<List<Sala>> getSalas() {
        List<Sala> salas = salaService.getSalas();
        return ResponseEntity.ok(salas);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<?> deletarSala(@PathVariable("id") Long id) {
        try {
            salaService.deletarSala(id);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarSala(@PathVariable("id") Long id, @RequestBody Sala sala) {
        try {
            salaService.atualizarSala(id, sala);
            return ResponseEntity.ok(true);
        }catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}