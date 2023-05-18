package org.example.DAO;

import org.example.dominio.Curso;

import javax.persistence.EntityManager;
import java.util.List;

public class CursoDAO implements ICursoDAO {

    private EntityManager entityManager;




    public CursoDAO(EntityManager em) {

         entityManager = em;
    }

    @Override
    public Long salvar(Curso curso) {
         entityManager.persist(curso);
         return curso.getId();
    }

    @Override
    public Curso buscar(Long id) {

        return entityManager.find(Curso.class, id);
    }

    @Override
    public List<Curso> buscarTodos() {

        String jpql = "Select c from Curso c";

        return entityManager.createQuery(jpql, Curso.class).getResultList();
    }

    @Override
    public void deletar(Curso curso) {

        entityManager.remove(curso);
    }

    @Override
    public Integer deletarPorCodigo(String codigo) {

       return entityManager.createQuery("DELETE FROM Curso c WHERE c.codigo = :codigo")
               .setParameter("codigo", codigo).executeUpdate();
    }

    @Override
    public Curso atualizar(Curso curso) {

       return entityManager.merge(curso);

    }
}
