package br.com.robson.jdbc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.robson.jdbc.modelo.Categoria;
import br.com.robson.jdbc.modelo.Produto;

public class ProdutosDAO {

	private Connection con;

	public ProdutosDAO(Connection con) {
		this.con = con;
		// TODO Auto-generated constructor stub
	}

	public void salvaProduto(Produto mesa, Connection con) {
		this.con = con;
	}

	public void salva(Connection con, Produto produto) throws SQLException {
		String sql = "insert into Produto (nome, descricao) values (?, ?)";

		// Escreve o statement e salva
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getDescricao());
			stmt.execute();
			// Busca o id
			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) { // se gerar algum valor, pegar o id.
					int id = rs.getInt("id");
					produto.setId(id);
				}
			}
		}
	}

	public List<Produto> lista() throws SQLException {
		// Cria lista que tem todos os produtos
		List<Produto> produtos = new ArrayList<>();
		// Prepara query sql de produto e busca
		String sql = "select * from Produto";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			// executa statement
			stmt.execute();
			transformaResultadoEmProdutos(produtos, stmt);
		}
		return produtos; // Retorna lista
	}

	private void transformaResultadoEmProdutos(List<Produto> produtos, PreparedStatement stmt) throws SQLException {
		try (ResultSet rs = stmt.getResultSet()) {
			// Faz a consulta em cada linha
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				Produto produto = new Produto(nome, descricao);
				produto.setId(id);
				// add na lista
				produtos.add(produto);
			}
		}
	}

	public List<Produto> busca(Categoria categoria) throws SQLException {
		System.out.println("Executando uma query");
		// Cria lista que tem todos os produtos
		List<Produto> produtos = new ArrayList<>();
		// Prepara query sql de produto e busca
		String sql = "select * from Produto where categoria_id = ?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, categoria.getId());
			// executa statement
			stmt.execute();

			transformaResultadoEmProdutos(produtos, stmt);
		}

		return produtos; // Retorna lista
	}

}
