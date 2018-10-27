package br.com.robson.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.activation.DataSource;

import org.hsqldb.jdbc.JDBCPool;

public class ConnectionPool {

	private JDBCPool dataSource;

	ConnectionPool() {
		JDBCPool pool = new JDBCPool();
		pool.setUrl("jdbc:hsqldb:hsql://localhost/loja-virtual");
		pool.setUser("SA");
		pool.setPassword("");
		this.dataSource = pool;

	}

	Connection getConnection() throws SQLException {
	//	Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual", "SA", "");
		Connection connection = dataSource.getConnection();
		return connection;
	}
}