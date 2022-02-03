import java.util.HashMap;
import java.util.Map;

public class Interior extends PesquisarCidade {
    private Map<String, Cidade> bd = new HashMap<>();

    public Interior(PesquisarCidade proximo) {
        super(proximo);
        bd.put("Canoinhas", new Cidade("Canoinhas", "Canoinhas - SC"));
        bd.put("Mafra", new Cidade("Mafra", "Mafra - SC"));
        bd.put("Guarapuava", new Cidade("Guarapuava", "Guarapuava - PR"));
        bd.put("Pelotas", new Cidade("Pelotas", "Pelotas - RS"));
    }

    @Override
    protected Cidade recuperarCidade(String nome) {
        if (bd.containsKey(nome)) {
            return bd.get(nome);
        }
        return null;
    }
}