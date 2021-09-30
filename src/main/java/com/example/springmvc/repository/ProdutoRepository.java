package com.example.springmvc.repository;

import com.example.springmvc.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

    //Assinaturas referentes ao banco de dados
    //Select:findAll() ou findById()
    //INSERT ou UPDATE: save()
    //DELETE: deleteById()
    List<Produto> findByNome(String prod);
    List<Produto> findByNovo(Boolean novo);
    List<Produto> findByNomeAndNovo(String prod,boolean novo);
    List<Produto> findByPrecoGreaterThan(double preco);
}
