package org.example.ricardo_silva;

import org.example.DAO.MatriculaDAO;
import org.example.dominio.Matricula;
import org.example.factory.EntityManagerUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.List;

public class MatriculaTest {

    EntityManager em;

    public MatriculaTest() {
        this.em = EntityManagerUtil.getManager("vendas");
    }

    @AfterEach
    void pagarDatabase(){

        MatriculaDAO MatriculaDAO = new MatriculaDAO(em);
        List<Matricula> Matriculas = MatriculaDAO.buscarTodos();
        Matriculas.stream().forEach(MatriculaDAO::deletar);

        em.getTransaction().commit();
        em.close();
    }


    @Test
    void cadastrar(){

        Matricula matricula = new Matricula();
        matricula.setStatusMatricula("matriculado");
        matricula.setCodigo("J01");
        matricula.setValorMatricula(2500d);


        em.getTransaction().begin();

        MatriculaDAO matriculaDAO = new MatriculaDAO(em);

        Long id = matriculaDAO.salvar(matricula);

        Matricula buscarMatricula = matriculaDAO.buscar(id);

        Assertions.assertEquals(id,buscarMatricula.getId());

    }

    @Test
    void excluirPorCodigo(){

        String codigo = "J01";

        Matricula matricula = new Matricula();
        matricula.setStatusMatricula("matriculado");
        matricula.setCodigo(codigo);
        matricula.setValorMatricula(2500d);

        em.getTransaction().begin();

        MatriculaDAO MatriculaDAO = new MatriculaDAO(em);

        Long id = MatriculaDAO.salvar(matricula);

        Integer numeroLinhas = MatriculaDAO.deletarPorCodigo(matricula);

        Assertions.assertTrue(numeroLinhas > 0);

    }
}
