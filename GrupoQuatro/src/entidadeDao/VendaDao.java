package entidadeDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Pessoa;
import entidades.Venda;
import util.ConnectionFactory;

public class VendaDao  {

	private Connection con = null;

	public VendaDao() {
		con = (ConnectionFactory.getConnection());
	}

	
	public boolean inserir(Venda venda) {
		
		String sql = "INSERT INTO venda (pessoa, data, estoque, quantidade, valor) VALUES (?,?,?,?,?)";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, venda.getPessoa().getId());
			stmt.setString(2, venda.getData());
			stmt.setInt(3, venda.getEstoque().getProduto().getId());
			stmt.setInt(5, venda.getQuantidade());
			stmt.setDouble(6, venda.getValor());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("erro ao Inserir" + e);
			return false;
		}

	}


	public List<Venda> Buscartodos() {

		String sql = "SELECT * FROM vendaestoque";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Venda> vendas = new ArrayList<Venda>();

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Venda venda = new Venda();
				venda.getPessoa().setNome(rs.getString("nome"));
				venda.getPessoa().setIndentificacao(rs.getString("identificacao"));
				venda.getPessoa().setTipoPessoa(rs.getString("tipoPessoa"));
				venda.setData(rs.getString("data"));
				;
				venda.getEstoque().setQuantidade(rs.getInt("quantidade"));
				venda.getEstoque().setValor(rs.getDouble("valor"));

				vendas.add(venda);
			}
			stmt.close();
			rs.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("erro" + e);
		}
		return vendas;
	}

	
	public boolean atualizar(Venda venda) {
		
		String sql = "UPDATE venda SET pessoa = ? , data = ?, estoque = ?, quantidade =?, valor = ? WHERE id = ?";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, venda.getPessoa().getId());
			stmt.setString(2, venda.getData());
			stmt.setInt(3, venda.getEstoque().getProduto().getId());
			stmt.setInt(4, venda.getId());
			stmt.setInt(5, venda.getQuantidade());
			stmt.setDouble(6, venda.getValor());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("erro ao Atualizar" + e);
			return false;
		}

	}

	
	public boolean delete(Venda venda) {
		
		String sql = "DELETE FROM venda WHERE id = ?";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, venda.getId());
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
		List<Pessoa> vendas = new ArrayList<Pessoa>();

		return vendas.size() + 1;
	}

}
