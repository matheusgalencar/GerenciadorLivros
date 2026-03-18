package com.books.books.controllers;

import com.books.books.models.LivroModel;
import com.books.books.models.ProdutoModel;
import com.books.books.services.LivroService;
import com.books.books.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.admin.SpringApplicationAdminMXBeanRegistrar;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroModel>> findAll(){
        List<LivroModel> livro = livroService.findAll();
        return ResponseEntity.status(200).body(livro);
    }

    @PostMapping
    public ResponseEntity<LivroModel> criarProduto(@RequestBody LivroModel livro){
        LivroModel model = livroService.criarLivro(livro);
        return ResponseEntity.status(201).body(model);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<LivroModel>> buscarId(@PathVariable Long id){
        Optional<LivroModel> livro = livroService.buscarId(id);

        return ResponseEntity.status(200).body(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroModel> atualizarNome(@PathVariable Long id, @RequestBody LivroModel livroModel){
        LivroModel model = livroService.atualizarAutor(id, livroModel);

        return ResponseEntity.status(200).body(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        livroService.deletar(id);
        return ResponseEntity.status(204).build();
    }

}
