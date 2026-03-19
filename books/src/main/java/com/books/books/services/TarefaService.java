package com.books.books.services;

import com.books.books.models.TarefaModel;
import com.books.books.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    public List<TarefaModel> findAll(){ return tarefaRepository.findAll();}
    public Optional<TarefaModel> findById(Long id) {
        return tarefaRepository.findById(id);
    }
    public TarefaModel criarTarefa(TarefaModel tarefa) { return tarefaRepository.save(tarefa); }
    public TarefaModel atualizarTarefa(TarefaModel tarefa, Long id) {
        TarefaModel tarefaAtualizada = tarefaRepository.findById(id).get();
        tarefaAtualizada.setDescricao(tarefa.getDescricao());
        return tarefaRepository.save(tarefaAtualizada);
    }
    public void deletarTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }
}
