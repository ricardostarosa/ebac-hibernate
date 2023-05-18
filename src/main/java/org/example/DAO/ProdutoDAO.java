package org.example.DAO;

import org.example.dominio.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {

    private EntityManager entityManager;

    public ProdutoDAO(EntityManager em) {

         entityManager = em;
    }

    @Override
    public Long salvar(Produto produto) {
         entityManager.persist(produto);
         return produto.getId();
    }

    @Override
    public Produto buscar(Long id) {

        return entityManager.find(Produto.class, id);
    }

    @Override
    public List<Produto> buscarTodos() {

        String jpql = "Select c from Produto c";

        return entityManager.createQuery(jpql, Produto.class).getResultList();
    }
    @Override
    public Produto atualizar(Produto Produto) {
        return entityManager.merge(Produto);
    }

    @Override
    public void deletar(Produto Produto) {
         entityManager.remove(Produto);
    }
}
