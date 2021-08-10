package entidades;

/**
 *
 * @author Celiculos
 */
public class ItemCompra extends ItemMovimentacaoBase {


    public ItemCompra(Produto produto, double quantidade, double valor) {
        super(produto, quantidade, valor);
    }


    @Override
    protected void contabiliza(Estoque estoque) {
        estoque.entrada(this.getQuantidade(), this.getValor());
    }

}