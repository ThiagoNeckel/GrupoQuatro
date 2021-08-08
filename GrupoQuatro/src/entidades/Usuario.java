package entidades;

public class Usuario {
	private int matricula;
	private String nome;
	private int rg;
	private String cpf;
	private String nascimento;
	private String funcao;
	private String data;
	

	
	public Usuario (int matricula, String nome, int rg, String cpf, String nascimento, String funcao, String data) {
		
		this.matricula = matricula;
		this.nome = nome;
		this.rg= rg;
		this.cpf= cpf;
		this.nascimento = nascimento;
		this.funcao = funcao;
		this.data = data;
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getRg() {
		return rg;
	}
	
	public void setRg(int rg) {
		this.rg = rg;
	}
	

	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNascimento() {
		return nascimento;
	}
	
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	
	public String getFuncao() {
		return funcao;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	
	public String toString() {
		
		return  "Numero Matriucula: "
				+ getMatricula()
				+ "\n"
				+ "Nome Funcionario: "
				+ getNome()
				+ "\n"
				+ "Numero Rg: "
				+ getRg()
				+ "\n"
				+ "Numero Cpf: "
				+ getCpf()
				+ "\n"
				+ "Função: "
				+ getFuncao()
				+ "\n --------------------------";
		
	
	}
}
