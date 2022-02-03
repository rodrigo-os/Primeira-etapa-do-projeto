import java.util.List;

public class VisualizarSimples implements VisualizarEstacionamento {
    private String modeloSimples;
    private double precoSimples;
    public double horasSimples;

    public VisualizarSimples(String modeloSimples, double precoSimples) {
        this.modeloSimples = modeloSimples;
        this.precoSimples = precoSimples;
    }

    @Override
    public String getModelo() {
        return modeloSimples;
    }

    @Override
    public double getHoras(List<Double> horas) {
        horasSimples = horas.get(0) + horas.get(1) + horas.get(2);

        return horasSimples;
    }


    @Override
    public double getPreco() {
        return precoSimples;
    }
}