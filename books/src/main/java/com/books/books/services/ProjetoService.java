package com.books.books.services;

import com.books.books.models.ProjetoModel;
import com.books.books.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<ProjetoModel> findAll(){ return projetoRepository.findAll();}
    public Optional<ProjetoModel> findById(Long id) {
        return projetoRepository.findById(id);
    }
    public ProjetoModel criarProjeto (ProjetoModel projeto) { return projetoRepository.save(projeto); }
    public ProjetoModel atualizarProjeto (ProjetoModel projeto, Long id) {
        ProjetoModel projetoAtualizado = projetoRepository.findById(id).get();
        projetoAtualizado.setNome(projeto.getNome());
        return projetoRepository.save(projetoAtualizado);
    }
    public void deletarCliente(Long id) {
        projetoRepository.deleteById(id);
    }
}
