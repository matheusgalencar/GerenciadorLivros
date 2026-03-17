package com.books.books.services;

import com.books.books.models.LivroModel;
import com.books.books.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroModel> findAll(){
        return livroRepository.findAll();
    }

    public LivroModel criarLivro(LivroModel livro){
        return livroRepository.save(livro);
    }

    public Optional<LivroModel> buscarId(Long id){
        return livroRepository.findById(id);
    }

    public LivroModel atualizarAutor(Long id, LivroModel livro){
        LivroModel model = livroRepository.findById(id).get();

        model.setAutor(livro.getAutor());

        return livroRepository.save(model);
    }

    public void deletar(Long id){
        livroRepository.deleteById(id);
    }
}
