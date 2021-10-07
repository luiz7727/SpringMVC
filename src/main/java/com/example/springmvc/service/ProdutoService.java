package com.example.springmvc.service;

import com.example.springmvc.model.Produto;

import java.util.List;

public interface ProdutoService {
    public Produto getProdutoById(int id);

    public List<Produto> getProdutoByName(String name);

    public List<Produto> getAllProdutos();

    public boolean exists(String nome);

    public Produto save(Produto prod);

    public long contarPorPrecoMaior(double preco);

    public void deleteById(int id);


}
