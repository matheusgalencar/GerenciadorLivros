package com.books.books.services;

import com.books.books.models.ProdutoModel;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoService produtoService;

    public List<ProdutoModel> findAll(){return produtoService.findAll();}

    public ProdutoModel criarProduto(ProdutoModel produtoModel){return produtoService.save(produtoModel);}

    public Optional<ProdutoModel> buscarId(Long id){
        return produtoService.buscarId(id);
    }

    public ProdutoModel atualizar(Long id, ProdutoModel produtoModel){
        ProdutoModel model = produtoService.buscarId(id).get();
        model.setNome(produtoModel.getNome());

        return produtoService.save(model);
    }

}
