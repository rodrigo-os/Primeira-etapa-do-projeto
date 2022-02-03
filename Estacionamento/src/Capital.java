import java.util.HashMap;
import java.util.Map;

public class Capital extends PesquisarCidade {
    private Map<String, Cidade> bd = new HashMap<>();

    public Capital(PesquisarCidade proximo) {
        super(proximo);
        bd.put("Florianópolis", new Cidade("Florianópolis", "Florianópolis - SC"));
    }

    @Override
    protected Cidade recuperarCidade(String nome) {
        if (bd.containsKey(nome)) {
            return bd.get(nome);
        }
        return null;
    }
}