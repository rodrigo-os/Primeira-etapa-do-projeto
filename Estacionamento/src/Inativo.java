public class Inativo extends ClienteState {

    public Inativo(Cliente cliente) {
        super(cliente);
        System.out.println("Não sou um cliente");
    }

    @Override
    public void consultarCliente() {
        System.out.println("Pago a hora.");
    }

    @Override
    public void vincular() {
        System.out.println("Irei me tornar um cliente ativo.");
        getCliente().setState(new Ativo(getCliente()));
    }

    @Override
    public void desvincular() {
        System.out.println("Já sou um cliente inativo.");
    }

}
