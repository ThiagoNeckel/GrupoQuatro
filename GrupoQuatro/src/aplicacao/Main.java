package aplicacao;

import java.util.ArrayList;

import entidades.Produto;
import entidades.Usuario;

public class Main {

public static void main(String[] args) {
		
		// Criando Arrays
		
		ArrayList<Usuario> funcionario = new ArrayList<Usuario>();
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		
		//Cadastro funcionario
		
		int matricula = 12;
		String nome = "João Martins";
		int rg = 5555234;
		String cpf = "98745328909" ;
		String nascimento = "08/12/1988";
		String funcao = "Administação";
		String data = "07/09/2000";
		
		Usuario usuario = new Usuario(matricula, nome, rg, cpf, nascimento, funcao, data);
		funcionario.add(usuario); // adiciona na Array
		
		matricula = 60;
		nome = "Carlos Fontes";
		rg = 5213234;
		cpf = "98745320000" ;
		nascimento = "08/12/1991";
		funcao = "Caixa";
		data = "07/09/2010";
		
		usuario = new Usuario(matricula, nome, rg, cpf, nascimento, funcao, data);
		funcionario.add(usuario);
		
		
		
		// Cadastro de Produtos
	
		int codigo = 123;
		String marca = "Nestle";
		String nomeProd = "Neston";
		int estoque = 2;
		String dataF = "08/08/2021";
		String dataV = "09/09/2021";
		
		Produto produto = new Produto(codigo , marca ,nomeProd, estoque, dataF, dataV);
		
		// aumenta quantidade do estoque 
		int quantidade = 4;
		produto.deposito(quantidade);
		produtos.add(produto);
		
		
		codigo = 12;
		marca = "Qualy";
		nomeProd = "Margarina";
		estoque = 2;
		dataF = "08/08/2022";
		dataV = "09/12/2021";
		produto = new Produto(codigo , marca ,nomeProd, estoque, dataF, dataV);
		produtos.add(produto);
		
		
		
			/* percorrendo Arrays*/
		System.out.println("\n----------Usuario------------\n");
		
		for (Usuario f : funcionario ) {
		
			System.out.println(f );		
		}
		
		
		System.out.println("\n----------Produtos------------\n");

		for (Produto p :produtos) {
			System.out.println(p);
		}
	}
}

