package entidades;

public final class Produto {

    private long codigo;
    private String descricao;
    private Marca marca;


    public Produto(final long codigo, final String descricao, final Marca marca) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.marca = marca;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Marca getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return new util.BoxPrint(
          java.util.Map.<String, String>of(
            "codigo"   , String.valueOf(this.getCodigo()),
            "descricao", String.valueOf(this.getDescricao()),
            "marca"    , this.getMarca().getNome()
          )
        ).toString();
    }

}