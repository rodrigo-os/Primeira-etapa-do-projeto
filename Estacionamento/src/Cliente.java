public class Cliente {
    private ClienteState state;

    public Cliente(Ativo ativo) {
        super();
        this.state = new Ativo(this);
    }

    public Cliente() {
        super();
        this.state = new Inativo(this);
    }

    public void consultarCliente() {
        state.consultarCliente();
    }

    public void vincular() {
        state.vincular();
    }

    public void desvincular() {
        state.desvincular();
    }

    public ClienteState getState() {
        return state;
    }

    public void setState(ClienteState state) {
        this.state = state;
    }
}
