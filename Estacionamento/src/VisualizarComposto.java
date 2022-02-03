import java.util.ArrayList;
import java.util.List;

public class VisualizarComposto implements VisualizarEstacionamento {
    private String modeloComposto;
    List<String> modelos = new ArrayList<String>();
    public double precoComposto;
    public double horasComposto;


    public VisualizarComposto(String modeloComposto, double precoComposto) {
        this.modeloComposto = modeloComposto;
        this.precoComposto = precoComposto;
        modelos.add(modeloComposto);
    }

    @Override
    public String getModelo() {


        return modeloComposto;

    }

    @Override
    public double getHoras(List<Double> horas) {
        horasComposto = horas.get(0) + horas.get(1) + horas.get(2);


        return horasComposto;

    }

    @Override
    public double getPreco() {


        return precoComposto;

    }
}
