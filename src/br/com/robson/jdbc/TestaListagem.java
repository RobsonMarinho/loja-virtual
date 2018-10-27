package br.com.robson.jdbc;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		// insere os dados para conexao do DB
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual", "SA", "");

		// Executa o select
		java.sql.Statement statement = connection.createStatement();
		// Retorna um boolean do resultado da query
		boolean resultado = statement.execute("select * from Produto");
		ResultSet resultSet = statement.getResultSet();
		// Passa para o próximo
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			// Exibe o nome
			String nome = resultSet.getString("nome");
			// Exibe a descricao do produto
			String descricao = resultSet.getString("descricao");
			System.out.println(id);
			System.out.println(nome);
			System.out.println(descricao);
		}

		// fecha a conexão
		resultSet.close();
		statement.close();
		connection.close();
	}
}
