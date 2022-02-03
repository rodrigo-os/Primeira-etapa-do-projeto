public class Ativo extends ClienteState {

    public Ativo(Cliente cliente) {
        super(cliente);
        System.out.println("Sou um cliente");
    }

    @Override
    public void consultarCliente() {
        System.out.println("Pago o dia.");
    }

    @Override
    public void vincular() {
        System.out.println("Já sou um cliente ativo.");
    }

    @Override
    public void desvincular() {
        System.out.println("Irei me tornar um cliente inativo.");
        getCliente().setState(new Inativo(getCliente()));
    }

}
