package com.books.books.controllers;

import com.books.books.models.PedidoModel;
import com.books.books.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoModel>> findAll(){
        List<PedidoModel> model= pedidoService.findAll();

        return ResponseEntity.status(200).body(model);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PedidoModel>> buscarId(@PathVariable Long id){
        Optional<PedidoModel> model = pedidoService.buscarId(id);

        return ResponseEntity.status(200).body(model);
    }

    @PostMapping
    public ResponseEntity<PedidoModel> criarPedido(@RequestBody PedidoModel pedidoCriado){
        PedidoModel pedido = pedidoService.criarPedido(pedidoCriado);

        return ResponseEntity.status(201).body(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoModel> atualizarPedido(@RequestBody PedidoModel pedidoNovo,@PathVariable Long id){

        PedidoModel pedidoAntigo = pedidoService.atualizarStatusPedido(pedidoNovo,id);
        return ResponseEntity.status(200).body(pedidoAntigo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id){
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }

}

