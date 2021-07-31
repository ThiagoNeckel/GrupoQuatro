package aplicacao;

import java.util.ArrayList;

import entidades.Produto;
import entidades.Usuario;

public class Main {

	public static void main(String[] args) {
		
		
		
		ArrayList<Usuario> funcionario = new ArrayList<Usuario>();
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		
		/* Cadastrando Funcionario */
	
		Usuario usuario = new Usuario("Mateus Barbosa", "Auxiliar");
		
		Usuario usuario1 = new Usuario("Jhonatan Cardoso", "Administração");
		
		funcionario.add(usuario);
		funcionario.add(usuario1);
		
		/* Cadastrar dados Produtos*/
		
		Produto itens = new Produto("Copo", 12323, 12);
		Produto itens1  = new Produto("Prato", 34234, 10);
	
		produtos.add(itens);      /* adicionando ao Array*/
		produtos.add(itens1);
		
		
		/* percorrendo Arrays*/
		
		for (Usuario f : funcionario ) {
		
			System.out.println(f );	
			
		}
		
		for (Produto p : produtos) {
			System.out.println(p);
		}
		

	}

}
