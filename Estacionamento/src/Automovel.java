import java.util.List;

public class Automovel extends Veiculo implements Observer{

    public Automovel(String cor, String modelo, String fabricante, boolean cliente, List<Double> horas) {
        super(cor, modelo, fabricante, cliente, horas);
    }

    @Override
    protected double calcularTaxaRisco() {
        return this.getPagamento() * 0.2;
    }

    @Override
    public void notify(Observable observable, String message) {
        System.out.println(this.getModelo() + " recebeu a seguinte notificação de " + observable + ": " + message);// problema em observable
    }
}
