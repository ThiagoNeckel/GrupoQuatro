package entidades;

/**
 *
 * @author Celiculos
 */
public interface ItemMovimentacao {

    /**
     * Produto estocado.
     *
     * @return Produto
     */
    public Produto getProduto();

    /**
     * Quantidade movimentada no estoque.
     *
     * @return quantidade
     */
    public double getQuantidade();

    /**
     * Valor alterado do estoque.
     *
     * @return valor total
     */
    public double getValor();

    /**
     * Movimenta o estoque
     */
    public void movimentaEstoque();

}