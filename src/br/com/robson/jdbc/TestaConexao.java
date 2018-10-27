package br.com.robson.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

//Classe que testa a conexao com o banco de dados
public class TestaConexao {
	
	public static void main(String[] args) throws SQLException {
		//Set o tipo de DB, tipo de conexao e nome do DB
		Connection connection = new  ConnectionPool().getConnection();
		//Exibe uma mensagem de confirmacao de conexao com o DB
		System.out.println("Abrindo uma conexao com sucesso!! ");
		//Fecha conexao com o DB
		connection.close();
	}
}
