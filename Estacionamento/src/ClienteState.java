public abstract class ClienteState {
    private Cliente cliente;

    public ClienteState(Cliente cliente) {
        super();
        this.cliente = cliente;
    }

    public abstract void consultarCliente();

    public abstract void vincular();

    public abstract void desvincular();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}