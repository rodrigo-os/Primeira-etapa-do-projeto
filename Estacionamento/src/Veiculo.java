import java.util.List;

public abstract class Veiculo{
    private String cor;
    private String modelo;
    private String fabricante;
    private boolean cliente;
    private List<Double> horas;
    private double pagamento;
    private Cliente clienteStatus = new Cliente();

    public Veiculo(String cor, String modelo, String fabricante, boolean cliente, List<Double> horas) {
        this.cor = cor;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.cliente = cliente;
        this.horas = horas;
    }

    public String getCor() {
        return cor;
    }

    public String getModelo() {
        return modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public boolean getCliente() {
        return cliente;
    }

    public void setCliente(boolean cliente) {
        this.cliente = cliente;
    }

    public List<Double> getHoras() {
        return horas;
    }

    public void setHoras(List<Double> horas) {
        this.horas = horas;
    }

    public double getPagamento() {
        return pagamento;
    }

    public void setPagamento(double pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getClienteStatus() {
        return clienteStatus;
    }

    public void setClienteStatus(Cliente clienteStatus) {
        this.clienteStatus = clienteStatus;
    }

    public double calcularTaxaRiscoSemanal() {
        return calcularTaxaRisco() * 6;
        // Segunda, Terça, Quarta, Quinta e Sexta
    }

    protected abstract double calcularTaxaRisco();

}