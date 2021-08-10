package entidades;

/**
 *
 * @author Celiculos
 */
public class Pessoa {

    private String nome;
    private String numeroDocumento;


    public Pessoa(String nome, String numeroDocumento) {
        this.nome = nome;
        this.numeroDocumento = numeroDocumento;
    }


    public String getNome() {
        return nome;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    @Override
    public String toString() {
        return new util.BoxPrint(
          java.util.Map.<String, String>of(
            "nome"    , this.getNome(),
            "cpf/cnpj", this.getNumeroDocumento()
          )
        ).toString();
    }


}