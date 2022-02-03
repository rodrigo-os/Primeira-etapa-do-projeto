import java.util.ArrayList;
import java.util.List;

public class ModeloDAO {
    static List<String> modelos = new ArrayList<String>();

    public static AbstractModelo getModelo(String modelo) {
        for (int i = 0; i < modelos.size(); i++)
            if (modelos.get(i).equalsIgnoreCase(modelo))
                return new RealModelo(modelo);
        return new NullModelo();
    }
}