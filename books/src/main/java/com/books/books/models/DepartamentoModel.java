package com.books.books.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_departamento")
public class DepartamentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomeDepartamento")
    private String nome;
    @Column(name = "localizacaoDepartamento")
    private String localizacao;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome;}

    public String getLocalizacao() { return localizacao; }

    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }
}
