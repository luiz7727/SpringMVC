package com.example.springmvc.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name = "produto",sequenceName = "SQ_PRODUTO",allocationSize = 1)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
    private int codigo;

    public Produto(String nome, double preco)
    {
        this.nome = nome;
        this.preco = preco;
    }

    @NotNull
    private String nome;

    private double preco;

    private boolean novo;

    private LocalDate dataFabricacao;


    public int getCodigo()
    {
        return this.codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public double getPreco()
    {
        return this.preco;
    }

    public void setPreco(double preco)
    {
        this.preco = preco;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao)
    {
        this.dataFabricacao=dataFabricacao;
    }

    public Boolean getNovo(){return this.novo=novo;}

    public void setNovo(Boolean novo){this.novo=novo;}

    @ManyToOne
    private Categoria categoria;

    public Categoria getCategoria()
    {
        return this.categoria;
    }
    public void setCategoria(Categoria categoria)
    {
        this.categoria=categoria;
    }
}
