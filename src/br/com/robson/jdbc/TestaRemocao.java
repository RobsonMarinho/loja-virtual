package br.com.robson.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws Exception {
		Connection connection = Database.getConnection();
		Statement stmt = (Statement) connection.createStatement();
		stmt.execute("delete from Produto where id>3");
		int count = ((java.sql.Statement) stmt).getUpdateCount();
		System.out.println(count + " linhas atualizadas");

		connection.close();
	}
}
