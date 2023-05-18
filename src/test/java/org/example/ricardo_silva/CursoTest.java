package org.example.ricardo_silva;

import org.example.DAO.CursoDAO;
import org.example.dominio.Curso;
import org.example.factory.EntityManagerUtil;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import java.util.List;

public class CursoTest {

    EntityManager em;

    public CursoTest() {
        this.em = EntityManagerUtil.getManager("vendas");
    }

    @AfterEach
    void pagarDatabase(){

        CursoDAO cursoDAO = new CursoDAO(em);
        List<Curso> cursos = cursoDAO.buscarTodos();
        cursos.stream().forEach(cursoDAO::deletar);

        em.getTransaction().commit();
        em.close();
    }


    @Test
    void cadastrar(){

        Curso curso = new Curso();
        curso.setNome("java");
        curso.setCodigo("J01");
        curso.setDescricao("Especialista");

        em.getTransaction().begin();

        CursoDAO cursoDAO = new CursoDAO(em);

        Long id = cursoDAO.salvar(curso);

        Curso buscarCurso = cursoDAO.buscar(id);

        Assertions.assertEquals(id,buscarCurso.getId());

    }

    @Test
    void excluirPorCodigo(){

        String codigo = "J01";

        Curso curso = new Curso();
        curso.setNome("java");
        curso.setCodigo(codigo);
        curso.setDescricao("Especialista");

        em.getTransaction().begin();

        CursoDAO cursoDAO = new CursoDAO(em);

        Long id = cursoDAO.salvar(curso);

        Integer numeroLinhas = cursoDAO.deletarPorCodigo(codigo);

        Assertions.assertTrue(numeroLinhas > 0);

    }
}
