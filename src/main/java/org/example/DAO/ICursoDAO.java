package org.example.DAO;

import org.example.dominio.Curso;

import java.io.Serializable;
import java.util.List;

public interface ICursoDAO extends Serializable {

    Long salvar(Curso curso);

    Curso buscar(Long id);

    List<Curso> buscarTodos();

    void deletar(Curso curso);

    Integer deletarPorCodigo(String codigo);

    Curso atualizar(Curso curso);
}
