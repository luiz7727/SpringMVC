package com.example.springmvc.controller;

import com.example.springmvc.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProdutoResource {

    @Autowired
    private ProdutoRepository produtoRepository;
}
