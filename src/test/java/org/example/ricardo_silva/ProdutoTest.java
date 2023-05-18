package org.example.ricardo_silva;

import org.example.DAO.ProdutoDAO;
import org.example.dominio.Produto;
import org.example.factory.EntityManagerUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoTest {

    EntityManager em;

    public ProdutoTest() {
        this.em = EntityManagerUtil.getManager("vendas");
    }

    @AfterEach
    void pagarDatabase(){

        ProdutoDAO ProdutoDAO = new ProdutoDAO(em);
        List<Produto> produtos = ProdutoDAO.buscarTodos();
        produtos.stream().forEach(ProdutoDAO::deletar);

        em.getTransaction().commit();
        em.close();
    }


    @Test
    void cadastrar(){

        Produto produto = new Produto();

        produto.setTipo("graduação");
        produto.setPreco(2500d);


        em.getTransaction().begin();

        ProdutoDAO ProdutoDAO = new ProdutoDAO(em);

        Long id = ProdutoDAO.salvar(produto);

        Produto buscarProduto = ProdutoDAO.buscar(id);

        Assertions.assertEquals(id,buscarProduto.getId());

    }
}
