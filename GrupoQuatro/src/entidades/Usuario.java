package entidades;

public class Usuario {

    private final long matricula;
    private final String funcao;
    private final Pessoa pessoa;


    public Usuario(long matricula, String funcao, Pessoa pessoa) {
        this.matricula = matricula;
        this.funcao = funcao;
        this.pessoa = pessoa;
    }


    public long getMatricula() {
        return matricula;
    }

    public String getFuncao() {
        return funcao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    @Override
    public String toString() {
        return new util.BoxPrint(
          java.util.Map.<String, String>of(
            "matricula", String.valueOf(this.getMatricula()),
            "funcao"   , this.getFuncao(),
            "Pessoa"   , this.getPessoa().getNome()
          )
        ).toString();
    }

}