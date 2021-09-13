package entidadeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Estoque;
import entidades.Marca;
import entidades.Produto;
import util.ConnectionFactory;

public class EstoqueDao  {

	private Connection con = null;

	public EstoqueDao() {
		con = (ConnectionFactory.getConnection());
	}

	
	public boolean inserir(Estoque estoque) {
		
		String sql = "INSERT INTO estoque (produto, quantidade, valor) VALUES (?,?,?)";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, estoque.getProduto().getId());
			stmt.setInt(2, estoque.getQuantidade());
			stmt.setDouble(3, estoque.getValor());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("erro ao Inserir" + e);
			return false;
		}

	}

	
	public List<Estoque> Buscartodos() {

		String sql = "SELECT * FROM produtoestoque";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Estoque> estoques = new ArrayList<Estoque>();

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();
				produto.setDescricao(rs.getString("descricao"));

				Marca marca = new Marca();
				marca.setNome(rs.getString("nome"));

				Estoque estoque = new Estoque();
				estoque.setQuantidade(rs.getInt("quantidade"));
				estoque.setValor(rs.getDouble("valor"));
				

				produto.setMarca(marca);
				estoques.add(estoque);
			}
			stmt.close();
			rs.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("erro" + e);
		}
		return estoques;
	}

	
	public boolean atualizar(Estoque estoque) {
		
		String sql = "UPDATE estoque SET quantidade = ? ,valor =? WHERE produto = ?";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, estoque.getQuantidade());
			stmt.setDouble(2, estoque.getValor());
			stmt.setInt(3, estoque.getProduto().getId());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("erro ao Atualizar" + e);
			return false;
		}

	}

	
	public boolean delete(Estoque estoque) {
		
		String sql = "DELETE FROM marca WHERE produto = ?";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, estoque.getProduto().getId());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("erro ao Deletar" + e);
			return false;
		}

	}

	
	public long proximoCodigo() {
		List<Estoque> estoques = new ArrayList<Estoque>();
		return estoques.size() + 1;
	}

}
