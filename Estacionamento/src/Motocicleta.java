import java.util.List;

public class Motocicleta extends Veiculo implements Observer{

    public Motocicleta(String cor, String modelo, String fabricante, boolean cliente, List<Double> horas) {
        super(cor, modelo, fabricante, cliente, horas);
    }

    @Override
    protected double calcularTaxaRisco() {
        return this.getPagamento() * 0.1;
    }

    @Override
    public void notify(Observable observable, String message) {
        System.out.println(this.getModelo() + " recebeu a seguinte notificação de " + observable + ": " + message);
    }
}
