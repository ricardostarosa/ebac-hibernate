package org.example.DAO;

import org.example.dominio.Produto;

import java.io.Serializable;
import java.util.List;

public interface IProdutoDAO extends Serializable {

    Long salvar(Produto produto);

    Produto buscar(Long id);

    List<Produto> buscarTodos();

    void deletar(Produto produto);
    Produto atualizar(Produto produto);
}
