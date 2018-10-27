package br.com.robson.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.robson.jdbc.DAO.ProdutosDAO;
import br.com.robson.jdbc.modelo.Produto;

public class TestaDAODeProduto {

	public static void main(String[] args) throws SQLException {
		// Cria produto
		Produto mesa = new Produto("Mesa Azul", "Mesa com 4 pés");
		// Abre a conexao com o DB
		try (Connection con = new ConnectionPool().getConnection()) {
			//Cria o DAO
			ProdutosDAO dao = new ProdutosDAO(con);
			//salva
			dao.salva(con, mesa);
			
			//Executa a busca
			List<Produto> produtos = dao.lista();
			for (Produto produto : produtos) {
				System.out.println("Existe o produto: " + produto);
			}
		}
		
	}

}
