package entidadeDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Compra;
import entidades.Pessoa;
import util.ConnectionFactory;

public class CompraDao {

	private Connection con = null;

	public CompraDao() {
		con = (ConnectionFactory.getConnection());
	}


	public boolean inserir(Compra compra) {
		 
		String sql = "INSERT INTO compra (pessoa, estoques, quantidade, valor) VALUES (?,?,?,?)";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, compra.getPessoa().getId());
			stmt.setInt(2, compra.getEstoque().getProduto().getId());
			stmt.setInt(3, compra.getQuantidade());
			stmt.setDouble(4, compra.getValor());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("erro ao Inserir" + e);
			return false;
		}

	}

	
	public List<Compra> Buscartodos() {

		String sql = "SELECT * FROM compraestoque";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Compra> compras = new ArrayList<Compra>();

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Compra compra = new Compra();
				compra.getPessoa().setNome(rs.getString("nome"));
				compra.getPessoa().setIndentificacao(rs.getString("identificacao"));
				compra.getPessoa().setTipoPessoa(rs.getString("tipoPessoa"));
				compra.setData(rs.getString("data"));
				;
				compra.getEstoque().setQuantidade(rs.getInt("quantidade"));
				compra.getEstoque().setValor(rs.getDouble("valor"));

				compras.add(compra);
			}
			stmt.close();
			rs.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("erro" + e);
		}
		return compras;
	}

	
	public boolean atualizar(Compra compra) {
		
		String sql = "UPDATE compra SET pessoa = ? , data = ? , quantidade = ? , valor=?  estoque = ? WHERE id = (?,?,?,?,?)";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, compra.getPessoa().getId());
			stmt.setString(2,compra.getData());
			stmt.setInt(3, compra.getEstoque().getProduto().getId());
			stmt.setInt(4, compra.getId());
			stmt.setInt(5, compra.getQuantidade());
			stmt.setDouble(6, compra.getValor());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("erro ao Atualizar" + e);
			return false;
		}

	}

	
	public boolean delete(Compra compra) {
		
		String sql = "DELETE FROM marca WHERE id = ?";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, compra.getId());
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
		List<Pessoa> compras = new ArrayList<Pessoa>();

		return compras.size() + 1;
	}

}
