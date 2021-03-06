package com.example.springmvc.controller;

import com.example.springmvc.model.Produto;
import com.example.springmvc.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository produtoRepository;
    public ProdutoRepository getProdutoRepository()
    {
        return this.produtoRepository;
    }
    public void setProdutoRepository(ProdutoRepository produtoRepository)
    {
        this.produtoRepository=produtoRepository;
    }

    @GetMapping
    public List<Produto> listar()
    {
        return produtoRepository.findAll();
    }

    @GetMapping("{codigo}")
    public Produto buscar(@PathVariable int codigo)
    {
        return produtoRepository.findById(codigo).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto)
    {
        return produtoRepository.save(produto);
    }

    @PutMapping("{id}")
    public Produto atualizar(@RequestBody Produto produto, @PathVariable int id)
    {
        produto.setCodigo(id);
        return produtoRepository.save(produto);
    }

    @DeleteMapping("{codigo}")
    public void remover(@PathVariable int codigo)
    {
        produtoRepository.deleteById(codigo);
    }

    @GetMapping("pesquisar")
    public List<Produto> buscar(@RequestParam(required = false) String nome,@RequestParam(defaultValue = "false") boolean novo)
    {
        return nome != null ? produtoRepository.findByNomeAndNovo(nome, novo) : produtoRepository.findByNovo(novo);
    }


}
