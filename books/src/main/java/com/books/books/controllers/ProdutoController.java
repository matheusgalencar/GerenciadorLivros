package com.books.books.controllers;

import com.books.books.models.ProdutoModel;
import com.books.books.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAll(){
        List<ProdutoModel> produtos = produtoService.findAll();
        return ResponseEntity.status(200).body(produtos);
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> criarProduto(@RequestBody ProdutoModel produtoModel){
        ProdutoModel model = produtoService.criarProduto(produtoModel);
        return ResponseEntity.status(201).body(model);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProdutoModel>> buscarId(@PathVariable Long id){
        Optional<ProdutoModel> produto = produtoService.buscarId(id);

        return ResponseEntity.status(200).body(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> atualizarNome(@PathVariable Long id, @RequestBody ProdutoModel produtoModel){
        ProdutoModel model = produtoService.atualizar(id, produtoModel);

        return ResponseEntity.status(200).body(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        produtoService.deletar(id);
        return ResponseEntity.status(204).build();
    }
}
