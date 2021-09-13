package entidades;

public class Estoque {

	private Produto produto;
	private int quantidade;
	private double valor;

	public Estoque() {
		// TODO Auto-generated constructor stub
	}

	public Estoque(Produto produto, int quantidade, double valor) {

		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void entrada(int quantidade) {
		this.quantidade += quantidade;
	}

	public void saida(int quantidade) {

		this.quantidade -= quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double valorTotal(double valor) {
		return valor * this.quantidade;
	}

	public String toString() {
		return getProduto().toString() + "Quantidade Estoque: " + getQuantidade() + "\n" + "Valor por unidade: "
				+ String.format("%.2f", getValor()) + "\n" + "Valor total: " + String.format("%.2f", valorTotal(valor))
				+ "\n";
	}

}
