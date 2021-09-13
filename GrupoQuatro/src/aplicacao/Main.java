
package aplicacao;

import java.util.Scanner;
import entidade.*;
import entidadeDao.*;

public class Main {

	public static void main(String[] args) {

		menu();

	}

	private static void menu() {
		int opcao;
		Scanner sc = new Scanner(System.in);
		do {
			imprimeOpcoes();
			opcao = sc.nextInt();
			trataOpcaoMenu(opcao);
		} while (opcao != 0);
	}

	private static void imprimeOpcoes() {
		System.out.println("+-------------------------+");
		System.out.println("| ### PROJETO ESTOQUE ### |");
		System.out.println("|                         |");
		System.out.println("| 1 - Estoque             |");
		System.out.println("| 2 - Cadastros           |");
		System.out.println("|                         |");
		System.out.println("| 0 - Sair                |");
		System.out.println("+-------------------------+");
		System.out.print("Digite uma Opção: ");
	}

	private static void trataOpcaoMenu(int opcao) {
		switch (opcao) {
		case 1:
			menuEstoque();
			break;
		case 2:
			menuCadastros();
			break;

		}
	}

	private static void imprimeOpcoesEstoque() {
		System.out.println("+-------------------------+");
		System.out.println("| ###   Estoque  ###      |");
		System.out.println("|                         |");
		System.out.println("|     1 - Compra          |");
		System.out.println("|     2 - Venda           |");
		System.out.println("|                         |");
		System.out.println("| 0 - Voltar              |");
		System.out.println("+-------------------------+");
		System.out.print("Digite uma Opção: ");
	}

	private static void menuEstoque() {
		Scanner sc = new Scanner(System.in);

		int opcao;
		do {
			imprimeOpcoesEstoque();

			opcao = sc.nextInt();
			trataOpcaoMenuEstoque(opcao);
		} while (opcao != 0);
	}

	private static void trataOpcaoMenuEstoque(int estoque) {
		Scanner sc = new Scanner(System.in);
		switch (estoque) {
		case 1: {
			System.out.println("Compra cadastradas:");
			ListCompra();
			int opcao;

			do {
				imprimeAcoesCadastros();
				opcao = sc.nextInt();
				trataAcaoMenuEstoque(estoque, opcao);
			} while (opcao != 0);
		}
		case 2: {
			System.out.println("Venda cadastrados:");
			ListVenda();
			int opcao;
			do {
				imprimeAcoesCadastros();
				opcao = sc.nextInt();
				trataAcaoMenuEstoque(estoque, opcao);
				;
			} while (opcao != 0);
		}
		case 3: {
			System.out.println("Usuarios cadastrados:");
			LisPessoa();
			int opcao;
			do {
				imprimeAcoesCadastros();
				opcao = sc.nextInt();
				trataAcaoMenuEstoque(estoque, opcao);
				;
			} while (opcao != 0);
		}
		}
	}

	private static void trataAcaoMenuEstoque(int estoque, int opcao) {
		switch (estoque) {
		case 1: {
			trataAcaoCadastroCompra(opcao);
			break;
		}

		case 2: {
			trataAcaoCadastroVenda(opcao);
			break;
		}
		}
	}

	private static void imprimeOpcoesCadastros() {
		System.out.println("+-------------------------+");
		System.out.println("| ### Cadastros  ###      |");
		System.out.println("|                         |");
		System.out.println("|     1 - Marcas          |");
		System.out.println("|     2 - Produtos        |");
		System.out.println("|     3 - Usuarios        |");
		System.out.println("|                         |");
		System.out.println("| 0 - Voltar              |");
		System.out.println("+-------------------------+");
		System.out.print("Digite uma Opção: ");
	}

	private static void menuCadastros() {
		Scanner sc = new Scanner(System.in);
		int opcao;
		do {
			imprimeOpcoesCadastros();

			opcao = sc.nextInt();
			trataOpcaoMenuCadastros(opcao);
		} while (opcao != 0);
	}

	private static void imprimeAcoesCadastros() {
		System.out.println("\r\nInforme a ação desejada:");
		System.out.println("+-------------------------+");
		System.out.println("| 1 - Inserir             |");
		System.out.println("| 2 - Alterar             |");
		System.out.println("| 3 - Excluir             |");
		System.out.println("|                         |");
		System.out.println("| 0 - Voltar              |");
		System.out.println("+-------------------------+");
		System.out.print("Digite uma Opção: ");
	}

	private static void trataOpcaoMenuCadastros(int cadastro) {
		Scanner sc = new Scanner(System.in);
		switch (cadastro) {
		case 1: {
			System.out.println("Marcas cadastradas:");
			ListMarca();
			int opcao;

			do {
				imprimeAcoesCadastros();
				opcao = sc.nextInt();
				trataAcaoMenuCadastros(cadastro, opcao);
			} while (opcao != 0);
		}
		case 2: {
			System.out.println("Produtos cadastrados:");
			LisProd();
			int opcao;
			do {
				imprimeAcoesCadastros();
				opcao = sc.nextInt();
				trataAcaoMenuCadastros(cadastro, opcao);
				;
			} while (opcao != 0);
		}
		case 3: {
			System.out.println("Usuarios cadastrados:");
			LisPessoa();
			int opcao;
			do {
				imprimeAcoesCadastros();
				opcao = sc.nextInt();
				trataAcaoMenuCadastros(cadastro, opcao);
				;
			} while (opcao != 0);
		}
		}
	}

	public static void inserirMarca() {
		Scanner sc = new Scanner(System.in);
		Marca marca = new Marca();
		MarcaDao dao = new MarcaDao();
		System.out.println("Nome");
		marca.setNome(sc.nextLine());

		if (dao.inserir(marca)) {
			System.out.println("Salvo com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void atualizarMarca() {
		Scanner sc = new Scanner(System.in);
		Marca marca = new Marca();
		MarcaDao dao = new MarcaDao();
		System.out.println("Digite o id da marca a ser atualizada:");
		marca.setId(sc.nextInt());
		System.out.println("Atualizar nome:");
		sc.nextLine();
		marca.setNome(sc.nextLine());
		if (dao.atualizar(marca)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void deleteMarca() {
		Scanner sc = new Scanner(System.in);
		Marca marca = new Marca();
		MarcaDao dao = new MarcaDao();
		System.out.println("Digite o id da marca a ser deletada:");
		marca.setId(sc.nextInt());
		if (dao.delete(marca)) {
			System.out.println("Deletada  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void ListMarca() {

		MarcaDao dao = new MarcaDao();

		for (Marca m : dao.Buscartodos()) {
			System.out.println(" Nome Marca " + m.getNome());
		}
	}

	public static void inserirProd() {
		Scanner sc = new Scanner(System.in);
		Produto produto = new Produto();
		Marca marca = new Marca();
		ProdutoDao dao = new ProdutoDao();
		System.out.println("Descricao");
		produto.setDescricao(sc.nextLine());
		System.out.println("Marca:");
		marca.setId(sc.nextInt());
		produto.setMarca(marca);
		if (dao.inserir(produto)) {
			System.out.println("Salvo com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void atualizarProd() {
		Scanner sc = new Scanner(System.in);
		Produto produto = new Produto();
		Marca marca = new Marca();
		ProdutoDao dao = new ProdutoDao();
		System.out.println("Digite o id da produto a ser atualizada:");
		produto.setId(sc.nextInt());
		System.out.println("Descricao");
		sc.nextLine();
		produto.setDescricao(sc.nextLine());
		System.out.println("Marca:");
		marca.setId(sc.nextInt());
		produto.setMarca(marca);
		if (dao.atualizar(produto)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void deleteProd() {
		Scanner sc = new Scanner(System.in);
		Produto produto = new Produto();
		Marca marca = new Marca();
		ProdutoDao dao = new ProdutoDao();
		System.out.println("Digite o id da produto a ser deletada:");
		produto.setId(sc.nextInt());
		if (dao.delete(produto)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void LisProd() {
		ProdutoDao dao = new ProdutoDao();

		for (Produto p : dao.Buscartodos()) {
			System.out.println("id " + p.getId() + "Descricao " + p.getDescricao() + "nome: " + p.getMarca().getNome());
		}

	}

	public static void inserirPessoa() {
		Scanner sc = new Scanner(System.in);
		Pessoa pessoa = new Pessoa();
		PessoaDao dao = new PessoaDao();
		System.out.println("Nome: ");
		pessoa.setNome(sc.nextLine());
		System.out.println("CPF/CNPJ");
		pessoa.setIndentificacao(sc.nextLine());
		System.out.println("tipoPessoa digite funcionario / cliente:");
		pessoa.setTipoPessoa(sc.nextLine());
		if (dao.inserir(pessoa)) {
			System.out.println("Salvo com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void atualizarPessoa() {
		Scanner sc = new Scanner(System.in);
		Pessoa pessoa = new Pessoa();
		PessoaDao dao = new PessoaDao();
		System.out.println("Digite o id da pessoa a ser atualizada:");
		pessoa.setId(sc.nextInt());
		System.out.println("Nome: ");
		sc.nextLine();
		pessoa.setNome(sc.nextLine());
		System.out.println("CPF/CNPJ");
		pessoa.setIndentificacao(sc.nextLine());
		System.out.println("tipoPessoa digite funcionario / cliente:");
		pessoa.setTipoPessoa(sc.nextLine());
		if (dao.atualizar(pessoa)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void deletePessoa() {
		Scanner sc = new Scanner(System.in);
		Pessoa pessoa = new Pessoa();
		PessoaDao dao = new PessoaDao();
		System.out.println("Digite o id da pessoa a ser deletada:");
		pessoa.setId(sc.nextInt());
		if (dao.delete(pessoa)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void LisPessoa() {
		PessoaDao dao = new PessoaDao();

		for (Pessoa p : dao.Buscartodos()) {
			System.out.println("id " + p.getId() + "nome " + p.getNome() + "cpf/cnpj: " + p.getIndentificacao()
					+ "Tipo Pessoa: " + p.getTipoPessoa());
		}

	}

	public static void inserirEstoque() {
		Scanner sc = new Scanner(System.in);
		Estoque estoque = new Estoque();
		Produto produto = new Produto();
		EstoqueDao dao = new EstoqueDao();
		System.out.println("Digite o id do Produto:");
		produto.setId(sc.nextInt());
		estoque.setProduto(produto);
		System.out.println("Digite a quantidade:");
		int quantidade = sc.nextInt();
		estoque.setQuantidade(quantidade);
		estoque.entrada(quantidade);
		System.out.println("Digite o  valor:");
		double valor = sc.nextDouble();
		estoque.setValor(valor);
		estoque.valorTotal(valor);
		if (dao.inserir(estoque)) {
			System.out.println("Salvo com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void atualizarEstoque() {
		Scanner sc = new Scanner(System.in);
		Estoque estoque = new Estoque();
		Produto produto = new Produto();
		EstoqueDao dao = new EstoqueDao();
		System.out.println("Digite o id a ser atualizada:");
		produto.setId(sc.nextInt());
		estoque.setProduto(produto);
		System.out.println("Digite  a quantidade:");
		int quantidade = sc.nextInt();
		estoque.setQuantidade(quantidade);
		estoque.entrada(quantidade);
		System.out.println("Digite o valor:");
		double valor = sc.nextDouble();
		estoque.setValor(valor);
		estoque.valorTotal(valor);
		if (dao.atualizar(estoque)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void deleteEstoque() {
		Scanner sc = new Scanner(System.in);
		Estoque estoque = new Estoque();
		Produto produto = new Produto();
		EstoqueDao dao = new EstoqueDao();
		System.out.println("Digite o id a ser deletada:");
		produto.setId(sc.nextInt());
		estoque.setProduto(produto);
		if (dao.delete(estoque)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void ListEstoque() {
		EstoqueDao dao = new EstoqueDao();

		for (Estoque e : dao.Buscartodos()) {
			System.out.println("id " + e.getProduto() + "Descricao " + e.getProduto().getDescricao() + "nome: "
					+ e.getProduto().getMarca().getNome());
		}

	}

	public static void inserirCompra() {
		Scanner sc = new Scanner(System.in);
		Pessoa pessoa = new Pessoa();
		Produto produto = new Produto();
		Estoque estoque = new Estoque();
		Compra compra = new Compra();
		CompraDao dao = new CompraDao();

		produto.getId();
		System.out.println("Digite o id da produto :");
		compra.setProduto(produto);
		System.out.println("Digite o id da pessoa :");
		pessoa.setId(sc.nextInt());
		compra.setPessoa(pessoa);
		System.out.println("Digite  quantidade :");
		int quantidade = sc.nextInt();
		compra.entrada(quantidade);
		System.out.println("Digite  valor:");
		double valor = sc.nextDouble();
		compra.setValor(valor);
		System.out.println("Data");
		compra.setData(sc.nextLine());
		if (dao.inserir(compra)) {
			System.out.println("Salvo com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void atualizarCompra() {
		Scanner sc = new Scanner(System.in);
		Pessoa pessoa = new Pessoa();
		Produto produto = new Produto();
		Estoque estoque = new Estoque();
		Compra compra = new Compra();
		CompraDao dao = new CompraDao();
		System.out.println("Digite o id da compra a ser atualizada:");
		compra.setId(sc.nextInt());

		System.out.println("Data");
		sc.nextLine();
		compra.setData(sc.nextLine());
		System.out.println("Digite o id da produto a ser atualizada:");
		produto.getId();
		compra.setProduto(produto);
		System.out.println("Digite o id da pessoa a ser atualizada:");
		pessoa.setId(sc.nextInt());
		compra.getId();
		System.out.println("Digite a quantidade a ser atualizada:");
		int quantidade = sc.nextInt();
		compra.entrada(quantidade);
		System.out.println("Digite o  valor a ser atualizada:");
		double valor = sc.nextDouble();
		compra.setValor(valor);

		if (dao.atualizar(compra)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void deleteCompra() {
		Scanner sc = new Scanner(System.in);
		Compra compra = new Compra();
		CompraDao dao = new CompraDao();
		System.out.println("Digite o id da pessoa a ser deletada:");
		compra.setId(sc.nextInt());
		if (dao.delete(compra)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void ListCompra() {
		CompraDao dao = new CompraDao();

		for (Compra c : dao.Buscartodos()) {
			System.out.println("id " + c.getId() + "nome " + c.getPessoa().getNome() + "cpf/cnpj: "
					+ c.getPessoa().getIndentificacao() + "Tipo Pessoa: " + c.getPessoa().getTipoPessoa() + "Data "
					+ c.getData() + "Quantidade" + c.getEstoque().getQuantidade() + " valor"
					+ c.getEstoque().getValor());
		}

	}

	public static void inserirVenda() {
		Scanner sc = new Scanner(System.in);
		Pessoa pessoa = new Pessoa();
		Produto produto = new Produto();
		Estoque estoque = new Estoque();
		Venda venda = new Venda();
		VendaDao dao = new VendaDao();

		System.out.println("Data");
		sc.nextLine();
		venda.setData(sc.nextLine());
		System.out.println("Digite o id da produto :");
		produto.getId();
		venda.setProduto(produto);
		System.out.println("Digite o id da pessoa :");
		pessoa.setId(sc.nextInt());
		venda.getId();
		System.out.println("Digite  quantidade :");
		int quantidade = sc.nextInt();
		venda.entrada(quantidade);
		System.out.println("Digite  valor:");
		double valor = sc.nextDouble();
		venda.setValor(valor);
		if (dao.inserir(venda)) {
			System.out.println("Salvo com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void atualizarVenda() {
		Scanner sc = new Scanner(System.in);
		Pessoa pessoa = new Pessoa();
		Produto produto = new Produto();
		Estoque estoque = new Estoque();
		Venda venda = new Venda();
		VendaDao dao = new VendaDao();
		System.out.println("Digite o id da venda a ser atualizada:");
		venda.setId(sc.nextInt());

		System.out.println("Data");
		sc.nextLine();
		venda.setData(sc.nextLine());
		System.out.println("Digite o id da produto a ser atualizada:");
		produto.getId();
		venda.setProduto(produto);
		System.out.println("Digite o id da pessoa a ser atualizada:");
		pessoa.setId(sc.nextInt());
		venda.getId();
		System.out.println("Digite a quantidade a ser atualizada:");
		int quantidade = sc.nextInt();
		venda.entrada(quantidade);
		System.out.println("Digite o  valor a ser atualizada:");
		double valor = sc.nextDouble();
		venda.setValor(valor);

		if (dao.atualizar(venda)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void deleteVenda() {
		Scanner sc = new Scanner(System.in);
		Venda venda = new Venda();
		VendaDao dao = new VendaDao();
		System.out.println("Digite o id da pessoa a ser deletada:");
		venda.setId(sc.nextInt());
		if (dao.delete(venda)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void ListVenda() {
		VendaDao dao = new VendaDao();

		for (Venda c : dao.Buscartodos()) {
			System.out.println("id " + c.getId() + "nome " + c.getPessoa().getNome() + "cpf/cnpj: "
					+ c.getPessoa().getIndentificacao() + "Tipo Pessoa: " + c.getPessoa().getTipoPessoa() + "Data "
					+ c.getData() + "Quantidade" + c.getEstoque().getQuantidade() + " valor"
					+ c.getEstoque().getValor());
		}

	}

	private static void trataAcaoMenuCadastros(int cadastro, int opcao) {
		switch (cadastro) {
		case 1: {
			trataAcaoCadastroMarca(opcao);
			break;
		}
		case 2: {
			trataAcaoCadastroProduto(opcao);
			break;
		}

		case 3: {
			trataAcaoCadastroUsuario(opcao);
			break;
		}
		}
	}

	private static void trataAcaoCadastroProduto(int acao) {
		switch (acao) {
		case 1: {
			inserirProd();
			break;
		}

		case 2: {
			atualizarProd();
			break;
		}

		case 3: {
			deleteProd();
			break;
		}
		}

	}

	private static void trataAcaoCadastroMarca(int acao) {
		switch (acao) {
		case 1: {
			inserirMarca();
			break;
		}

		case 2: {
			atualizarMarca();
			break;
		}

		case 3: {
			deleteMarca();
			break;
		}
		}

	}

	private static void trataAcaoCadastroUsuario(int acao) {
		switch (acao) {
		case 1: {
			inserirPessoa();
			break;
		}

		case 2: {
			atualizarPessoa();
			break;
		}

		case 3: {
			deletePessoa();
			break;
		}

		}

	}

	private static void trataAcaoCadastroVenda(int acao) {
		switch (acao) {
		case 1: {
			inserirVenda();
			break;
		}

		case 2: {
			atualizarVenda();
			break;
		}

		case 3: {
			deleteVenda();
			break;
		}
		}
	}

	private static void trataAcaoCadastroCompra(int acao) {
		switch (acao) {
		case 1: {
			inserirEstoque();
			break;
		}

		case 2: {
			atualizarEstoque();
			break;
		}

		case 3: {
			deleteEstoque();
			break;
		}
		}
	}

}
