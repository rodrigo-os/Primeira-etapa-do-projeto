public abstract class PesquisarCidade {
    private PesquisarCidade proximo;

    public PesquisarCidade(PesquisarCidade proximo) {
        this.proximo = proximo;
    }

    public Cidade pesquisar(String nome) {
        Cidade sample = recuperarCidade(nome);
        if (sample == null) {
            return chamarProximo(nome);
        } else {
            return sample;
        }
    }

    private Cidade chamarProximo(String nome) {
        if (proximo == null) {
            throw new RuntimeException("Não temos nenhuma filial na cidade de " + nome + ".");
        } else {
            return proximo.pesquisar(nome);
        }
    }

    protected abstract Cidade recuperarCidade(String nome);
}