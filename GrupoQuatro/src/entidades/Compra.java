package entidades;

import java.util.Map;

/**
 * Movimentação de Entrada.
 *
 * @author Celiculos
 */
public class Compra extends MovimentacaoBase {

    private final Pessoa fornecedor;


    public Compra(final long numero, final int ano, final Pessoa fornecedor) {
        super(numero, ano);
        this.fornecedor = fornecedor;
    }


    public Pessoa getFornecedor() {
        return this.fornecedor;
    }

    @Override
    protected ItemMovimentacao criaItem(Produto produto, double quantidade, double valor) {
        return new ItemCompra(produto, quantidade, valor);
    }

    @Override
    protected Map mapForBox() {
        Map map = new java.util.HashMap<String, String>(super.mapForBox());
        map.put("Fornecedor", fornecedor.getNome());
        return map;
    }

}