package com.books.books.controllers;

import com.books.books.models.CategoriaModel;
import com.books.books.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> findAll() {

        List<CategoriaModel> categorias = categoriaService.findAll();
        return ResponseEntity.status(200).body(categorias);
    }
    @PostMapping
    public ResponseEntity<CategoriaModel> criarCategoria(@RequestBody CategoriaModel categoriaModel) {
        CategoriaModel categoria = categoriaService.criarCategoria(categoriaModel);
        return ResponseEntity.status(201).body(categoria);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<CategoriaModel>> findById(@PathVariable Long id) {
        Optional<CategoriaModel> categoria = categoriaService.findById(id);
        return ResponseEntity.status(200).body(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaModel> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaModel categoriaModel) {
        CategoriaModel categoria = categoriaService.findById(id).get();

        categoria.setNome(categoriaModel.getNome());

        return ResponseEntity.status(200).body(categoria);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
        return ResponseEntity.status(204).build();
    }
}
