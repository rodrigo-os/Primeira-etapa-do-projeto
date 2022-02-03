import java.util.HashMap;
import java.util.Map;

public class Metropole extends PesquisarCidade {
    private Map<String, Cidade> bd = new HashMap<>();

    public Metropole(PesquisarCidade proximo) {
        super(proximo);
        bd.put("Curitiba", new Cidade("Curitiba", "Curitiba - PR"));
        bd.put("Porto Alegre", new Cidade("Porto Alegre", "Porto Alegre - RS"));
    }

    @Override
    protected Cidade recuperarCidade(String nome) {
        if (bd.containsKey(nome)) {
            return bd.get(nome);
        }
        return null;
    }
}