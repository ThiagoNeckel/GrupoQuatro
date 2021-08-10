package entidades;

/**
 * Estoque de Produto.
 *
 * @author Celiculos
 */
public class Estoque {

    public static java.util.Map<Produto, Estoque> estoque = new java.util.HashMap<>();

    private final Produto produto;
    private double quantidade;
    private double valorTotal;


    public Estoque(final Produto produto, final double quantidade, final double valorTotal) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public Estoque(Produto produto) {
        this(produto, 0, 0);
    }


    public Produto getProduto() {
        return produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public double getValorUnitario() {
        return this.getValorTotal() / this.getQuantidade();
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public void entrada(double quantidade, double valorTotal) {
        this.quantidade += quantidade;
        this.valorTotal += valorTotal;
    }

    public void saida(double quantidade, double valorTotal) {
        //TODO validar quantidade negativa
        this.quantidade -= quantidade;
        this.valorTotal -= valorTotal;
    }

    public static Estoque busca(Produto produto) {
        if(!estoque.containsKey(produto)) {
            estoque.put(produto, new Estoque(produto));
        }
        return estoque.get(produto);
    }

    @Override
    public String toString() {
        return new util.BoxPrint(
          java.util.Map.<String, String>of(
            "Produto"       , this.getProduto().getDescricao(),
            "Marca"         , this.getProduto().getMarca().getNome(),
            "quantidade"    , String.format("%.2f", this.getQuantidade()),
            "Valor Unitário", String.format("%.2f", this.getValorUnitario()),
            "Valor Total"   , String.format("%.2f", this.getValorTotal())
          )
        ).toString();
    }

}