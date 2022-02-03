import java.util.List;

public class PrecoDia implements InterfaceCalculoEstacionamento {
    @Override
    public double calcular(List<Double> horas) {
        double preco = 0;
        for (Double hora : horas) {
            preco += hora;
        }
        preco = (preco * 1.70);
        return preco;
    }
}