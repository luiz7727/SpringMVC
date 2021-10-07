package com.example.springmvc;

import com.example.springmvc.model.Produto;
import com.example.springmvc.repository.ProdutoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProdutoRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Test
    public void whenFindByName_thenReturnProduct()
    {
        //NESSE TESTE AQUI ESTOU VERIFICANDO SE O OBJETO LOUSA FOR ARMAZENADO CORRETAMENTE NO BANCO DE DADOS.
        //PARA ISSO UTILIZO O MÉTODO ASSERTTHAT
        //given
        Produto lousa = new Produto("lousa escolar",2.90);
        entityManager.persist(lousa);
        entityManager.flush();


        //when
        Produto found = produtoRepository.findByNome(lousa.getNome()).get(0);

        //then
        assertThat(found.getNome()).isEqualTo(lousa.getNome());

        assertThat(found.getPreco()).isEqualTo(lousa.getPreco());
    }
}
