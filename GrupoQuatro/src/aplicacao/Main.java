package aplicacao;

import entidades.*;

public class Main {

    private static java.util.Map<String, Produto> produtos = new java.util.HashMap<>();
    private static java.util.Map<String, Usuario> usuarios = new java.util.HashMap<>();


    public static void main(String[] args) {
        criaUsuarios();
        criaProdutos();
        criaEstoqueInicial();
        imprimeEstoqueInicial();
        criaEntradas();
        imprimeEstoquePosCompras();
        criaSaidas();
        imprimeEstoqueFinal();
    }


    private static void criaUsuarios() {
        usuarios.put("celio"  , new Usuario(1, "programador"  , new Pessoa("Célio"  , "1")));
        usuarios.put("thiago" , new Usuario(2, "programador"  , new Pessoa("Thiago" , "2")));
        usuarios.put("rafael" , new Usuario(3, "desenvolvedor", new Pessoa("Rafael" , "3")));
        usuarios.put("marcelo", new Usuario(4, "desenvolvedor", new Pessoa("Marcelo", "4")));
    }

    private static void criaProdutos() {
        Marca elmaChips = new Marca("ElmaChips");
        Marca coca      = new Marca("Coca-Cola");
        produtos.put("doritos", new Produto(1, "Doritos", elmaChips));
        produtos.put("ruffles", new Produto(2, "Ruffles", elmaChips));
        produtos.put("cheetos", new Produto(3, "Cheetos", elmaChips));
        produtos.put("coca"   , new Produto(4, "Coca-Cola", coca));
        produtos.put("fanta"  , new Produto(5, "Fanta"    , coca));
    }

    private static void criaEstoqueInicial() {
        Compra compra1_2020 = new Compra(1, 2020, new Pessoa("Pepsico", "XX.XXX.XXX/0001-XX"));
        compra1_2020.adicionaItem(produtos.get("doritos"), 10, 100);
        compra1_2020.adicionaItem(produtos.get("ruffles"),  5,  75);
        compra1_2020.adicionaItem(produtos.get("cheetos"), 10,  10);

        Compra compra2_2020 = new Compra(2, 2020, new Pessoa("João do Caminhão", "000.123.456-78"));
        compra2_2020.adicionaItem(produtos.get("coca"), 10, 50);

        compra1_2020.movimentaEstoque(usuarios.get("celio"));
        compra2_2020.movimentaEstoque(usuarios.get("thiago"));
    }

    private static void imprimeEstoqueInicial() {
        System.out.println("*** Estoque Inicial ***");
        imprimeEstoque();
    }

    private static void imprimeEstoque() {
        Estoque.estoque.entrySet().forEach(pair -> {
            System.out.println(pair.getValue());
        });
    }

    private static void criaEntradas() {
        Compra compra1_2021 = new Compra(1, 2021, new Pessoa("Mercadão", "CNPJ"));
        compra1_2021.adicionaItem(produtos.get("ruffles"), 2, 20);
        compra1_2021.adicionaItem(produtos.get("fanta")  , 1,  5);

        Compra compra2_2021 = new Compra(2, 2021, new Pessoa("Pubzinho", "CNPJ 2"));
        compra2_2021.adicionaItem(produtos.get("coca")   , 1, 6);
        compra2_2021.adicionaItem(produtos.get("doritos"), 1, 8);

        compra1_2021.movimentaEstoque(usuarios.get("rafael"));
        compra2_2021.movimentaEstoque(usuarios.get("marcelo"));

        System.out.println("");
        System.out.println("*** Compras ***");
        System.out.println(compra1_2021);
        System.out.println(compra2_2021);
    }

    private static void imprimeEstoquePosCompras() {
        System.out.println("*** Estoque Após Compras ***");
        imprimeEstoque();
    }


    private static void criaSaidas() {
        Venda venda1_2021 = new Venda(1, 2021);
        venda1_2021.adicionaItem(produtos.get("ruffles"), 3, 20);
        venda1_2021.adicionaItem(produtos.get("doritos"), 1,  8);

        Venda venda2_2021 = new Venda(2, 2021);
        venda2_2021.adicionaItem(produtos.get("cheetos"), 1, 10);
        venda2_2021.adicionaItem(produtos.get("doritos"), 1,  8);

        venda1_2021.movimentaEstoque(usuarios.get("celio"));
        venda2_2021.movimentaEstoque(usuarios.get("marcelo"));

        System.out.println("");
        System.out.println("*** Vendas ***");
        System.out.println(venda1_2021);
        System.out.println(venda2_2021);
    }


    private static void imprimeEstoqueFinal() {
        System.out.println("*** Estoque Final ***");
        imprimeEstoque();
    }

}