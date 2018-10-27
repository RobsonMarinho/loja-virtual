package br.com.robson.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.robson.jdbc.DAO.CategoriasDAO;
import br.com.robson.jdbc.DAO.ProdutosDAO;
import br.com.robson.jdbc.modelo.Categoria;
import br.com.robson.jdbc.modelo.Produto;

public class TestaCategorias {

	public static void main(String[] args) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			List<Categoria> categorias = new CategoriasDAO(con).listaComProdutos();
			for (Categoria categoria : categorias) {
				System.out.println(categoria.getNome());

				for (Produto produto :categoria.getProdutos()) {
					System.out.println(categoria.getNome() + " - " + produto.getNome());
				}

			}
		}
	}
}