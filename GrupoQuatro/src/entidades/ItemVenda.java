package entidades;

/**
 *
 * @author Celiculos
 */
public class ItemVenda extends ItemMovimentacaoBase {

    public ItemVenda(Produto produto, double quantidade, double valor) {
        super(produto, quantidade, valor);
    }


    @Override
    protected void contabiliza(Estoque estoque) {
        estoque.saida(this.getQuantidade(), this.getValor());
    }

}