package org.example.DAO;

import org.example.dominio.Matricula;

import javax.persistence.EntityManager;
import java.util.List;

public class MatriculaDAO implements IMatriculaDAO {

    private EntityManager entityManager;




    public MatriculaDAO(EntityManager em) {

         entityManager = em;
    }

    @Override
    public Long salvar(Matricula matricula) {
         entityManager.persist(matricula);
         return matricula.getId();
    }

    @Override
    public Matricula buscar(Long id) {

        return entityManager.find(Matricula.class, id);
    }

    @Override
    public List<Matricula> buscarTodos() {

        String jpql = "Select c from Matricula c";

        return entityManager.createQuery(jpql, Matricula.class).getResultList();
    }

    @Override
    public Integer deletarPorCodigo(Matricula matricula) {

      return  entityManager.createQuery("DELETE FROM Matricula m WHERE m.codigo = :codigo")
                .setParameter("codigo", matricula.getCodigo()).executeUpdate();
    }
    @Override
    public Matricula atualizar(Matricula matricula) {
        return entityManager.merge(matricula);
    }

    @Override
    public void deletar(Matricula matricula) {
         entityManager.remove(matricula);
    }
}
