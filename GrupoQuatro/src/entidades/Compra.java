package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Compra extends Estoque{
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private int id;
	private String data;
	private Pessoa pessoa;
	private Estoque estoque;
	private double valor;
	public Compra() {

	}

	public Compra(int id, String data, Pessoa pessoa, Estoque estoque, double valor) {
		
		this.id = id;
		this.data = data;
		this.pessoa = pessoa;
		this.estoque = estoque;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public void entrada(int quantidade) {
		quantidade += quantidade;
		super.saida(quantidade);
	}

	@Override
	public String toString() {

		return getProduto().toString() + sdf.format(data);
	}

}
