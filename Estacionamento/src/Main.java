import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ArrayList<Automovel> automoveis = new ArrayList<Automovel>();
    static ArrayList<Motocicleta> motocicletas = new ArrayList<Motocicleta>();
    static ModeloDAO modelos = new ModeloDAO();

    static ArrayList<VisualizarSimples> simples = new ArrayList<VisualizarSimples>();
    static ArrayList<VisualizarComposto> composto = new ArrayList<VisualizarComposto>();


    public static void main(String[] args) {
        Estacionamento tabelaPrecos = new Estacionamento("Tabela de preços");
        Estacionamento statusCliente = new Estacionamento("Status do cliente");

        double precoManha = 2.0;
        double precoTarde = 1.9;
        double precoNoite = 2.1;
        List<Double> precos = new ArrayList<Double>();
        precos.add(precoManha);
        precos.add(precoTarde);
        precos.add(precoNoite);

        Scanner in = new Scanner(System.in);
        boolean mainMenu = true;
        while (mainMenu) {
            printMainMenu();
            int mainOption = in.nextInt();
            in.nextLine();
            switch (mainOption) {
                case 1:
                    boolean addMenu = true;
                    while (addMenu) {
                        printAddMenu();
                        int addOption = in.nextInt();
                        in.nextLine();
                        switch (addOption) {
                            case 1:
                                System.out.println("Cor:");
                                String corAutomovel = in.nextLine();
                                System.out.println("Modelo:");
                                String modeloAutomovel = in.nextLine();
                                modelos.modelos.add(modeloAutomovel);
                                System.out.println("Fabricante:");
                                String fabricanteAutomovel = in.nextLine();
                                boolean clienteAutomovel = true;
                                boolean validacao = true;
                                while (validacao) {
                                    System.out.println("Cliente:");
                                    System.out.println("[1] - Sim");
                                    System.out.println("[2] - Não");
                                    int option = in.nextInt();
                                    if (option == 1) {
                                        clienteAutomovel = true;

                                        validacao = false;

                                    } else if (option == 2) {
                                        clienteAutomovel = false;

                                        validacao = false;
                                    } else {
                                        System.out.println("Opção invalida!");
                                    }

                                }

                                List<Double> horasA = new ArrayList<Double>();
                                System.out.println("Horas pela manhã:");
                                double horasAM = in.nextDouble();
                                horasA.add(horasAM);
                                System.out.println("Horas pela tarde:");
                                double horasAT = in.nextDouble();
                                horasA.add(horasAT);
                                System.out.println("Horas pela noite:");
                                double horasAN = in.nextDouble();
                                horasA.add(horasAN);
                                Automovel automovel = new Automovel(corAutomovel, modeloAutomovel, fabricanteAutomovel, clienteAutomovel, horasA);
                                if (clienteAutomovel == true) {
                                    automovel.getClienteStatus().vincular();
                                } else {
                                    automovel.getClienteStatus().desvincular();
                                }
                                automoveis.add(automovel);
                                tabelaPrecos.addObserver(automovel);

                                if (clienteAutomovel == true) {
                                    PrecoFinal preco_dia = new PrecoFinal(automovel, horasA, new PrecoDia());
                                    automovel.setPagamento(preco_dia.calculoPrecoFinal());
                                    System.out.println("Veículo cadastrado!");
                                } else {
                                    PrecoFinal preco_hora = new PrecoFinal(automovel, horasA, new PrecoHora(precos));
                                    automovel.setPagamento(preco_hora.calculoPrecoFinal());
                                    System.out.println("Veículo cadastrado!");
                                }


                                VisualizarSimples simplesAutomovel = new VisualizarSimples(modeloAutomovel, automovel.getPagamento());
                                simplesAutomovel.getHoras(horasA);
                                simples.add(simplesAutomovel);

                                VisualizarComposto compostoAutomovel = new VisualizarComposto(modeloAutomovel, automovel.getPagamento());
                                compostoAutomovel.getHoras(horasA);
                                composto.add(compostoAutomovel);


                                addMenu = false;
                                break;

                            case 2:
                                System.out.println("Cor:");
                                String corMotocicleta = in.nextLine();
                                System.out.println("Modelo:");
                                String modeloMotocicleta = in.nextLine();
                                modelos.modelos.add(modeloMotocicleta);
                                System.out.println("Fabricante:");
                                String fabricanteMotocicleta = in.nextLine();
                                boolean clienteMotocicleta = true;
                                validacao = true;
                                while (validacao) {
                                    System.out.println("Cliente:");
                                    System.out.println("[1] - Sim");
                                    System.out.println("[2] - Não");
                                    int option = in.nextInt();
                                    if (option == 1) {
                                        clienteMotocicleta = true;


                                        validacao = false;
                                    } else if (option == 2) {
                                        clienteMotocicleta = false;


                                        validacao = false;
                                    } else {
                                        System.out.println("Opção invalida!");
                                    }
                                }
                                List<Double> horasM = new ArrayList<Double>();
                                System.out.println("Horas pela manhã:");
                                double horasMM = in.nextDouble();
                                horasM.add(horasMM);
                                System.out.println("Horas pela tarde:");
                                double horasMT = in.nextDouble();
                                horasM.add(horasMT);
                                System.out.println("Horas pela noite:");
                                double horasMN = in.nextDouble();
                                horasM.add(horasMN);
                                Motocicleta motocicleta = new Motocicleta(corMotocicleta, modeloMotocicleta, fabricanteMotocicleta, clienteMotocicleta, horasM);
                                if (clienteMotocicleta == true) {
                                    motocicleta.getClienteStatus().vincular();
                                } else {
                                    motocicleta.getClienteStatus().desvincular();
                                }
                                motocicletas.add(motocicleta);
                                tabelaPrecos.addObserver(motocicleta);

                                if (clienteMotocicleta == true) {
                                    PrecoFinal preco_dia = new PrecoFinal(motocicleta, horasM, new PrecoDia());
                                    motocicleta.setPagamento(preco_dia.calculoPrecoFinal());
                                    System.out.println("Veículo cadastrado!");
                                } else {
                                    PrecoFinal preco_hora = new PrecoFinal(motocicleta, horasM, new PrecoHora(precos));
                                    motocicleta.setPagamento(preco_hora.calculoPrecoFinal());
                                    System.out.println("Veículo cadastrado!");
                                }

                                VisualizarSimples simplesMotocicleta = new VisualizarSimples(modeloMotocicleta, motocicleta.getPagamento());
                                simplesMotocicleta.getHoras(horasM);
                                simples.add(simplesMotocicleta);

                                VisualizarComposto compostoMotocicleta = new VisualizarComposto(modeloMotocicleta, motocicleta.getPagamento());
                                compostoMotocicleta.getHoras(horasM);
                                composto.add(compostoMotocicleta);


                                addMenu = false;
                                break;

                            case 0:
                                addMenu = false;
                                break;

                            default:
                                System.out.println("Opção invalida!");
                                break;
                        }
                    }
                    break;

                case 2:
                    if (automoveis.size() < 1) {
                        System.out.println("Nenhum automóvel no momento!");
                    } else {
                        System.out.println("----------------------Automóveis----------------------");
                        for (int indexVeiculo = 0; indexVeiculo < automoveis.size(); indexVeiculo++) {
                            System.out.println("Cor: " + automoveis.get(indexVeiculo).getCor());
                            System.out.println("Modelo: " + automoveis.get(indexVeiculo).getModelo());
                            System.out.println("Fabricante: " + automoveis.get(indexVeiculo).getFabricante());
                            System.out.println("Cliente: " + automoveis.get(indexVeiculo).getCliente());

                            automoveis.get(indexVeiculo).getClienteStatus().consultarCliente();

                            System.out.println("Total de horas: " + automoveis.get(indexVeiculo).getHoras());
                            System.out.println("Valor a ser pago:" + automoveis.get(indexVeiculo).getPagamento());
                            System.out.println("Taxa de risco diário:" + automoveis.get(indexVeiculo).calcularTaxaRisco());
                            System.out.println("Taxa de risco semanal:" + automoveis.get(indexVeiculo).calcularTaxaRiscoSemanal());
                            System.out.println();
                        }
                    }
                    if (motocicletas.size() < 1) {
                        System.out.println("Nenhuma motocicleta no momento!");
                    } else {
                        System.out.println("---------------------Motocicletas---------------------");
                        for (int indexVeiculo = 0; indexVeiculo < motocicletas.size(); indexVeiculo++) {
                            System.out.println("Cor: " + motocicletas.get(indexVeiculo).getCor());
                            System.out.println("Modelo: " + motocicletas.get(indexVeiculo).getModelo());
                            System.out.println("Fabricante: " + motocicletas.get(indexVeiculo).getFabricante());
                            System.out.println("Cliente: " + motocicletas.get(indexVeiculo).getCliente());

                            motocicletas.get(indexVeiculo).getClienteStatus().consultarCliente();

                            System.out.println("Total de horas: " + motocicletas.get(indexVeiculo).getHoras());
                            System.out.println("Valor a ser pago:" + motocicletas.get(indexVeiculo).getPagamento());
                            System.out.println("Taxa de risco diário:" + motocicletas.get(indexVeiculo).calcularTaxaRisco());
                            System.out.println("Taxa de risco semanal:" + motocicletas.get(indexVeiculo).calcularTaxaRiscoSemanal());
                            System.out.println();
                        }
                    }
                    System.out.println("--------------------Estacionamento--------------------");
                    break;
                case 3:
                    double precoManhaUpdate = 0;
                    double precoTardeUpdate = 0;
                    double precoNoiteUpdate = 0;
                    System.out.println("-------------------Tabela de preços-------------------");
                    System.out.println("Preço pela Manhã: " + precos.get(0));
                    System.out.println("Preço pela Tarde: " + precos.get(1));
                    System.out.println("Preço pela Noite: " + precos.get(2));
                    System.out.println("--------------------Estacionamento--------------------");
                    System.out.println();
                    boolean tabela = true;
                    while (tabela) {
                        System.out.println("Deseja alterar a tabela:");
                        System.out.println("[1] - Sim");
                        System.out.println("[2] - Não");
                        int tableOption = in.nextInt();
                        if (tableOption == 1) {
                            System.out.println("Preço pela Manhã: ");
                            precoManhaUpdate = in.nextDouble();
                            precos.set(0, precoManhaUpdate);

                            System.out.println("Preço pela Tarde: ");
                            precoTardeUpdate = in.nextDouble();
                            precos.set(1, precoTardeUpdate);

                            System.out.println("Preço pela Noite: ");
                            precoNoiteUpdate = in.nextDouble();
                            precos.set(2, precoNoiteUpdate);
                            System.out.println("Tabela atualizada!");
                            if (automoveis.size() > 0 || motocicletas.size() > 0) {
                                tabelaPrecos.notify("Os preços foram alterados!");
                            }
                            tabela = false;
                        } else if (tableOption == 2) {
                            tabela = false;
                        } else {
                            System.out.println("Opção invalida!");
                        }

                    }
                    break;

                case 4:
                    if (automoveis.size() > 0 || motocicletas.size() > 0) {
                        boolean procurar = true;
                        while (procurar) {
                            System.out.println("Modelo a ser procurado: ");
                            String modeloProcura = in.next();
                            AbstractModelo modelo = ModeloDAO.getModelo(modeloProcura);
                            System.out.println("-----------------------Modelo's-----------------------");
                            System.out.println(modelo.getModelo());
                            System.out.println("--------------------Estacionamento--------------------");
                            System.out.println("Deseja procurar novamente:");
                            System.out.println("-[1] - Sim");
                            System.out.println("-[2] - Não");
                            int procurarOption = in.nextInt();
                            switch (procurarOption) {
                                case 1:
                                    break;
                                case 2:
                                    procurar = false;
                                    break;
                                default:
                                    System.out.println("Opção invalida!");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Nenhum modelo no momento!");
                    }
                    break;
                case 5:
                    boolean configurar = true;
                    while (configurar) {
                        System.out.println("Tipo do veículo que deseja configurar:");
                        System.out.println("-[1] - Automóvel");
                        System.out.println("-[2] - Motocicleta");
                        System.out.println("-[0] - Sair");
                        int configurarOption = in.nextInt();
                        switch (configurarOption) {
                            case 1:
                                if (automoveis.size() < 1) {
                                    System.out.println("-----------------------Clientes-----------------------");
                                    System.out.println("Nenhum automóvel no momento!");
                                    System.out.println("--------------------Estacionamento--------------------");
                                } else {
                                    System.out.println("-----------------------Clientes-----------------------");
                                    for (int indexAutomovel = 0; indexAutomovel < automoveis.size(); indexAutomovel++) {
                                        System.out.println("Índice [" + indexAutomovel + "]");
                                        System.out.println("Automóveis");
                                        System.out.println("Cor: " + automoveis.get(indexAutomovel).getCor());
                                        System.out.println("Modelo: " + automoveis.get(indexAutomovel).getModelo());
                                        System.out.println("Cliente: " + automoveis.get(indexAutomovel).getCliente());
                                        automoveis.get(indexAutomovel).getClienteStatus().consultarCliente();
                                        System.out.println();
                                    }
                                    System.out.println("--------------------Estacionamento--------------------");
                                    System.out.println("Índice a ser alterado:");
                                    int indiceConfigurar = in.nextInt();
                                    if (indiceConfigurar >= 0 && indiceConfigurar < automoveis.size()) {
                                        boolean status = true;
                                        while (status) {
                                            System.out.println("Atualizar o status do cliente para:");
                                            System.out.println("-[1] - ATIVO");
                                            System.out.println("-[2] - INATIVO");
                                            System.out.println("-[0] - Sair");
                                            int option = in.nextInt();
                                            if (option == 1) {
                                                if (automoveis.get(indiceConfigurar).getCliente() == true) {
                                                    automoveis.get(indiceConfigurar).getClienteStatus().consultarCliente();
                                                    status = false;
                                                } else {
                                                    automoveis.get(indiceConfigurar).getClienteStatus().vincular();
                                                    automoveis.get(indiceConfigurar).setCliente(true);
                                                    automoveis.get(indiceConfigurar).getClienteStatus().consultarCliente();
                                                    statusCliente.addObserver(automoveis.get(indiceConfigurar));
                                                    statusCliente.notify("O status do cliente sofreu uma alteração!");
                                                    status = false;
                                                }
                                            } else if (option == 2) {
                                                if (automoveis.get(indiceConfigurar).getCliente() == false) {
                                                    automoveis.get(indiceConfigurar).getClienteStatus().consultarCliente();
                                                    status = false;
                                                } else {
                                                    automoveis.get(indiceConfigurar).getClienteStatus().desvincular();
                                                    automoveis.get(indiceConfigurar).setCliente(false);
                                                    automoveis.get(indiceConfigurar).getClienteStatus().consultarCliente();
                                                    statusCliente.addObserver(automoveis.get(indiceConfigurar));
                                                    statusCliente.notify("O status do cliente sofreu uma alteração!");
                                                    status = false;
                                                }
                                            } else if (option == 0) {
                                                status = false;
                                            } else {
                                                System.out.println("Opção invalida!");
                                            }
                                        }

                                    } else {
                                        System.out.println("Índice invalido!");
                                    }

                                }
                                break;

                            case 2:
                                if (motocicletas.size() < 1) {
                                    System.out.println("-----------------------Clientes-----------------------");
                                    System.out.println("Nenhuma motocicleta no momento!");
                                    System.out.println("--------------------Estacionamento--------------------");
                                } else {
                                    System.out.println("-----------------------Clientes-----------------------");
                                    for (int indexMotocicleta = 0; indexMotocicleta < motocicletas.size(); indexMotocicleta++) {
                                        System.out.println("Índice [" + indexMotocicleta + "]");
                                        System.out.println("Motocicletas");
                                        System.out.println("Cor: " + motocicletas.get(indexMotocicleta).getCor());
                                        System.out.println("Modelo: " + motocicletas.get(indexMotocicleta).getModelo());
                                        System.out.println("Cliente: " + motocicletas.get(indexMotocicleta).getCliente());
                                        motocicletas.get(indexMotocicleta).getClienteStatus().consultarCliente();
                                        System.out.println();
                                    }
                                    System.out.println("--------------------Estacionamento--------------------");
                                    System.out.println("Índice a ser alterado:");
                                    int indiceConfigurar = in.nextInt();
                                    if (indiceConfigurar >= 0 && indiceConfigurar < motocicletas.size()) {
                                        boolean status = true;
                                        while (status) {
                                            System.out.println("Atualizar o status do cliente para:");
                                            System.out.println("-[1] - ATIVO");
                                            System.out.println("-[2] - INATIVO");
                                            System.out.println("-[0] - Sair");
                                            int option = in.nextInt();
                                            if (option == 1) {
                                                if (motocicletas.get(indiceConfigurar).getCliente() == true) {
                                                    motocicletas.get(indiceConfigurar).getClienteStatus().consultarCliente();
                                                    status = false;
                                                } else {
                                                    motocicletas.get(indiceConfigurar).getClienteStatus().vincular();
                                                    motocicletas.get(indiceConfigurar).setCliente(true);
                                                    motocicletas.get(indiceConfigurar).getClienteStatus().consultarCliente();
                                                    statusCliente.addObserver(motocicletas.get(indiceConfigurar));
                                                    statusCliente.notify("O status do cliente sofreu uma alteração!");
                                                    status = false;
                                                }
                                            } else if (option == 2) {
                                                if (motocicletas.get(indiceConfigurar).getCliente() == false) {
                                                    motocicletas.get(indiceConfigurar).getClienteStatus().consultarCliente();
                                                    status = false;
                                                } else {
                                                    motocicletas.get(indiceConfigurar).getClienteStatus().desvincular();
                                                    motocicletas.get(indiceConfigurar).setCliente(false);
                                                    motocicletas.get(indiceConfigurar).getClienteStatus().consultarCliente();
                                                    statusCliente.addObserver(motocicletas.get(indiceConfigurar));
                                                    statusCliente.notify("O status do cliente sofreu uma alteração!");
                                                    status = false;
                                                }
                                            } else if (option == 0) {
                                                status = false;
                                            } else {
                                                System.out.println("Opção invalida!");
                                            }
                                        }

                                    } else {
                                        System.out.println("Índice invalido!");
                                    }

                                }

                                break;
                            case 0:
                                configurar = false;
                                break;
                            default:
                                System.out.println("Opção invalida!");
                                break;
                        }

                    }
                    break;
                case 6:
                    boolean visualizar = true;
                    while (visualizar) {
                        System.out.println("Tipo de visualização:");
                        System.out.println("-[1] - Simples");
                        System.out.println("-[2] - Composta");
                        System.out.println("-[0] - Sair");
                        int visualizarOption = in.nextInt();
                        switch (visualizarOption) {
                            case 1:
                                if (simples.size() > 0) {
                                    System.out.println("-----------------Visualização Simples-----------------");
                                    for (int i = 0; i < simples.size(); i++) {
                                        System.out.println("Modelo: " + simples.get(i).getModelo());
                                        System.out.println("Total de horas: " + simples.get(i).horasSimples);
                                        System.out.println("Preço a ser pago: " + simples.get(i).getPreco());
                                        System.out.println();
                                    }
                                    System.out.println("--------------------Estacionamento--------------------");
                                } else {
                                    System.out.println("Nenhum veículo no momento!");
                                    break;
                                }
                                break;
                            case 2:
                                if (composto.size() > 0) {
                                    System.out.println("-----------------------Composto-----------------------");
                                    System.out.println("Todos os Modelos:");
                                    for (int i = 0; i < composto.size(); i++) {
                                        for (int j = 0; j < composto.get(i).modelos.size(); j++) {
                                            System.out.println(composto.get(i).modelos.get(j));
                                        }
                                    }

                                    double precoCompostoGeral = 0;
                                    for (int i = 0; i < composto.size(); i++) {
                                        precoCompostoGeral += composto.get(i).precoComposto;
                                    }
                                    double horasCompostoGeral = 0;
                                    for (int i = 0; i < composto.size(); i++) {
                                        horasCompostoGeral += composto.get(i).horasComposto;
                                    }
                                    System.out.println("Total de horas: " + horasCompostoGeral);
                                    System.out.println("Preço Total: " + precoCompostoGeral);


                                    System.out.println("--------------------Estacionamento--------------------");
                                } else {
                                    System.out.println("Nenhum veículo no momento!");
                                    break;
                                }

                                break;
                            case 0:
                                visualizar = false;
                                break;
                            default:
                                System.out.println("Opção invalida!");
                                break;
                        }


                    }
                    break;
                case 7:
                    try {
                        System.out.print("------------------------Filial------------------------");
                        System.out.println();
                        System.out.println("Cidade: ");
                        String cidadeInput = in.nextLine();
                        PesquisarCidade cidades = new Interior(new Capital(new Metropole(null)));
                        Cidade sample = cidades.pesquisar(cidadeInput);
                        System.out.println("Temos uma filial na cidade de " + sample.getConteudo() + ".");
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    }
                    System.out.println("--------------------Estacionamento--------------------");
                    break;
                case 0:
                    mainMenu = false;
                    System.out.println("Até a próxima.");
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }
    }

    static void printMainMenu() {
        System.out.println("---------------Sistema de gerenciamento---------------");
        System.out.println("-[1] - Cadastrar");
        System.out.println("-[2] - Visualizar");
        System.out.println("-[3] - Tabela de preços");
        System.out.println("-[4] - Procurar por modelo");
        System.out.println("-[5] - Configurar clientes");
        System.out.println("-[6] - Visão geral");
        System.out.println("-[7] - Procurar filiais");
        System.out.println("-[0] - Sair");
        System.out.println("--------------------Estacionamento--------------------");
        System.out.println("Digite sua opção:");
    }

    static void printAddMenu() {
        System.out.println("------------------Cadastrar veículos------------------");
        System.out.println("-[1] - Automóvel");
        System.out.println("-[2] - Motocicleta");
        System.out.println("-[0] - Sair");
        System.out.println("--------------------Estacionamento--------------------");
        System.out.println("Digite sua opção:");
    }
}