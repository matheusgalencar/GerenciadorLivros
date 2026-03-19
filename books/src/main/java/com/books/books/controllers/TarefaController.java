package com.books.books.controllers;

import com.books.books.models.TarefaModel;
import com.books.books.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<TarefaModel>> findAll() {
        List<TarefaModel> tarefas = tarefaService.findAll();
        return ResponseEntity.status(200).body(tarefas);
    }

    @PostMapping
    public ResponseEntity<TarefaModel> criarTarefa(@RequestBody TarefaModel tarefaModel) {
        TarefaModel tarefa = tarefaService.criarTarefa(tarefaModel);
        return ResponseEntity.status(201).body(tarefa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TarefaModel>> findById(@PathVariable Long id) {
        Optional<TarefaModel> tarefa = tarefaService.findById(id);
        return ResponseEntity.status(200).body(tarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaModel> atualizarTarefa(@PathVariable Long id, @RequestBody TarefaModel tarefaModel) {
        TarefaModel tarefa = tarefaService.findById(id).get();
        tarefa.setDescricao(tarefaModel.getDescricao());
        return ResponseEntity.status(200).body(tarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.status(204).build();
    }
}
