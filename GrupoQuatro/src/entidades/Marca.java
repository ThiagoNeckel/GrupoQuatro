package entidades;

/**
 * Marca de Produto.
 *
 * @author Celiculos
 */
public final class Marca {

    private String nome;


    public Marca(final String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return new util.BoxPrint(
          java.util.Map.<String, String>of("nome", this.getNome())
        ).toString();
    }

}