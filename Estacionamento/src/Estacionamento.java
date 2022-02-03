import java.util.ArrayList;
import java.util.List;

public class Estacionamento implements Observable {
    private String servico;
    private List<Observer> observers;

    public Estacionamento(String servico) {
        super();
        this.servico = servico;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    private List<Observer> getObservers() {
        if (observers == null)
            this.observers = new ArrayList<Observer>();
        return observers;
    }

    @Override
    public String toString() {
        return servico;
    }

    @Override
    public void addObserver(Observer observer) {
        getObservers().add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        getObservers().remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer o : observers)
            o.notify(this, message);
    }
}
