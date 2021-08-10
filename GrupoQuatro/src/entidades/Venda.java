package entidades;

/**
 *
 * @author Celiculos
 */
public class Venda extends MovimentacaoBase {

    public Venda(final long numero, final int ano) {
        super(numero, ano);
    }


    @Override
    protected ItemMovimentacao criaItem(Produto produto, double quantidade, double valor) {
        return new ItemVenda(produto, quantidade, valor);
    }

}