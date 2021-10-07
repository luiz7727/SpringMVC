package com.example.springmvc;

import com.example.springmvc.model.Produto;
import com.example.springmvc.repository.ProdutoRepository;
import com.example.springmvc.service.ProdutoService;
import com.example.springmvc.service.ProdutoServiceimpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setExtractBareNamePropertyMethods;

@RunWith(SpringRunner.class)
public class ProdutoServiceImpIIntegrationTest {
    @TestConfiguration
    static class ProdutoServiceImplTestContextConfiguration
    {
        @Bean
        public ProdutoService produtoService()
        {
            return (ProdutoService) new ProdutoServiceimpl();
        }
    }

    @Autowired
    private ProdutoService produtoService;

    @MockBean
    private ProdutoRepository produtoRepository;

    //Foi usado a annotation Before para especificar um método que será executado antes do test.É equivalente ao trecho Given
    @Before
    public void setUp()
    {
        List<Produto> result = new ArrayList<>();
        Produto prod = new Produto("cateninha",5);
        result.add(prod);

        Mockito.when(produtoRepository.findByNome(prod.getNome())).thenReturn(result);
    }

    @Test
    public void whenValidName_thenProductShouldBeFound()
    {
        String name = "canetinha";
        List<Produto> found = produtoService.getProdutoByName(name);

        assertThat(found.get(0).getNome()).isEqualTo(name);
    }
}
