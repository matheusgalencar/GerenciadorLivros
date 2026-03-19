package com.books.books.controllers;

import com.books.books.models.DepartamentoModel;
import com.books.books.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> findAll() {
        List<DepartamentoModel> departamentos = departamentoService.findAll();
        return ResponseEntity.status(200).body(departamentos);
    }

    @PostMapping
    public ResponseEntity<DepartamentoModel> criarDepartamento(@RequestBody DepartamentoModel departamentoModel) {
        DepartamentoModel departamento = departamentoService.criarDepartamento(departamentoModel);
        return ResponseEntity.status(201).body(departamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DepartamentoModel>> findById(@PathVariable Long id) {
        Optional<DepartamentoModel> departamento = departamentoService.findById(id);
        return ResponseEntity.status(200).body(departamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoModel> atualizarDepartamento(@PathVariable Long id, @RequestBody DepartamentoModel departamentoModel) {
        DepartamentoModel departamento = departamentoService.findById(id).get();
        departamento.setNome(departamentoModel.getNome());
        return ResponseEntity.status(200).body(departamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDepartamento(@PathVariable Long id) {
        departamentoService.deletarDepartamento(id);
        return ResponseEntity.status(204).build();
    }

}
