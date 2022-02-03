import java.util.List;

public class PrecoFinal {
    private Veiculo veiculo;
    private List<Double> horas;
    private InterfaceCalculoEstacionamento calculoPrecoFinal;

    public PrecoFinal(Veiculo veiculo, List<Double> horas, InterfaceCalculoEstacionamento calculoPreçoFinal) {
        super();
        this.veiculo = veiculo;
        this.horas = horas;
        this.calculoPrecoFinal = calculoPreçoFinal;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<Double> getHoras() {
        return horas;
    }

    public void setHoras(List<Double> horas) {
        this.horas = horas;
    }

    public InterfaceCalculoEstacionamento getCalculoPrecoFinal() {
        return calculoPrecoFinal;
    }

    public void setCalculoPrecoFinal(InterfaceCalculoEstacionamento calculoPrecoFinal) {
        this.calculoPrecoFinal = calculoPrecoFinal;
    }

    public double calculoPrecoFinal() {
        return calculoPrecoFinal.calcular(horas);
    }
}
