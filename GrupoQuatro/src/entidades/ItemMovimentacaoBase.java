package entidades;

/**
 *
 * @author Celiculos
 */
public abstract class ItemMovimentacaoBase implements ItemMovimentacao {

    protected final Produto produto;
    protected final double quantidade;
    protected final double valor;


    public ItemMovimentacaoBase(Produto produto, double quantidade, double valor) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    @Override
    public Produto getProduto() {
        return produto;
    }

    @Override
    public double getQuantidade() {
        return quantidade;
    }

    public double getValorUnitario() {
        return this.getValor() / this.getQuantidade();
    }

    @Override
    public double getValor() {
        return valor;
    }

    @Override
    public void movimentaEstoque() {
        this.contabiliza(this.findEstoque());
    }

    private Estoque findEstoque() {
        return Estoque.busca(this.produto);
    }

    protected abstract void contabiliza(Estoque estoque);

}