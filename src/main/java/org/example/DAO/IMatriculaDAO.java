package org.example.DAO;

import org.example.dominio.Curso;
import org.example.dominio.Matricula;

import java.io.Serializable;
import java.util.List;

public interface IMatriculaDAO extends Serializable {

    Long salvar(Matricula matricula);

    Matricula buscar(Long id);

    List<Matricula> buscarTodos();

    Integer deletarPorCodigo(Matricula matricula);

    void deletar(Matricula matricula);
    Matricula atualizar(Matricula matricula);

}
