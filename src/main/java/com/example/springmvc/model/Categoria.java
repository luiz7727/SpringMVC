package com.example.springmvc.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "categoria", sequenceName = "SQ_T_CATEGORIA", allocationSize = 1)
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "categoria")
    private int codigo;
    private String nome;
    public int getCodigo()
    {
        return this.codigo;
    }

    public void getCodigo(int codigo)
    {
        this.codigo=codigo;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

}
