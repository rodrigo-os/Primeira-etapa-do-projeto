import java.util.List;

public class PrecoHora implements InterfaceCalculoEstacionamento {
    private List<Double> preco_hora;

    public PrecoHora(List<Double> preco_hora) {
        this.preco_hora = preco_hora;
    }

    @Override
    public double calcular(List<Double> horas) {
        double preco = 0;
        for (int indiceHora = 0; indiceHora < horas.size(); indiceHora++) {
            preco += horas.get(indiceHora) * preco_hora.get(indiceHora);
        }
        return preco;
    }
}
