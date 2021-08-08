package entidades;

public class Produto {
	
	private String nomeProd;
	private int codigo;
	private int estoque;
	private String marca;
	private String dataF;
	private String dataV;
	
	
	public Produto(int codigo, String marca, String nomeProd, int estoqueInicial, String dataF, String dataV){
		this.nomeProd = nomeProd;
		this.codigo = codigo;
		this.marca = marca;
		deposito(estoqueInicial);
		this.dataF = dataF;
		this.dataV = dataV;
		
	}
	
	

	public String getNomeProd() {
		return nomeProd;
	}
	
	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public int getEstoque() {
		return estoque;
	}
	
	public int deposito(int quantidade) {
		return estoque += quantidade;
	}
	
	public int depositoTirar(int quantidade) {
		return estoque -= quantidade;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public  String getDataF() {
		return dataF;
	}
	
	public void setDataF(String dataF) {
		this.dataF = dataF;
	}
	
	public  String getDataV() {
		return dataV;
	}
	
	public void setDataV(String dataV) {
		this.dataV = dataV;
	}


	
	
	public String toString() {
		return    "Codigo Produto: "
				+ getCodigo()
				+ "\n"
				+ "Nome do Produto: "
				+ getNomeProd()
				+ "\n"
				+ "Marca do Produto: "
				+ marca
				+ "\n"
				+ "data de Fabricação : "
				+ dataF
				+ "\n"
				+ "data de Validade : "
				+ dataV
				+ "\n"
				+ "Quantidade em estoque: "
				+ getEstoque()
				+ "\n --------------------------";
	}

	
}
