import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    public static ArrayList<OrdemServico> oss = new ArrayList<>();
    public static ArrayList<Peca> pecas = new ArrayList<>();
    public static ArrayList<Veiculo> veiculos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 1;
        do{
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1 - Cliente");
            System.out.println("2 - Funcionário");
            System.out.println("3 - Peças");
            System.out.println("4 - Ordem de Serviço");
            System.out.println("5 - Veículo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    menuCrud("Cliente", sc);
                    break;
                case 2:
                    menuCrud("Funcionário", sc);
                    break;
                case 3:
                    menuCrud("Peças", sc);
                    break;
                case 4:
                    menuCrud("Ordem de Serviço", sc);
                    break;
                case 5:
                    menuCrud("Veículo", sc);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while(op != 0);

    }

    public static void menuCrud(String entidade, Scanner sc) {
        int opcao;
        do {
            System.out.println("=== CRUD de " + entidade + " ===");
            System.out.println("1 - Criar " + entidade);
            System.out.println("2 - Listar " + entidade + "s");
            System.out.println("3 - Atualizar " + entidade);
            System.out.println("4 - Deletar " + entidade);
            if (entidade.equals("Ordem de Serviço")) {
                System.out.println("5 - Consultar OS por Veículo");
                System.out.println("6 - Consultar OS por Funcionário");
            }
            System.out.print("0 - Voltar ao menu principal\nEscolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    if (entidade.equals("Cliente")) {
                        Cliente.criarCliente(sc, clientes);
                    } else if (entidade.equals("Funcionário")) {
                        Funcionario.criarFunc(sc, funcionarios);
                    } else if (entidade.equals("Peças")) {
                        Peca.criarPeca(sc, pecas);
                    } else if (entidade.equals("Ordem de Serviço")) {
                        OrdemServico.criarOs(sc, oss);
                    } else if (entidade.equals("Veículo")) {
                        Veiculo.criarVeiculo(sc, veiculos);
                    }
                    break;

                case 2:
                    if (entidade.equals("Cliente")) {
                        Cliente.listarClientes(clientes);
                    } else if (entidade.equals("Funcionário")) {
                        Funcionario.listarFunc(funcionarios);
                    } else if (entidade.equals("Peças")) {
                        Peca.listarPecas(pecas);
                    } else if (entidade.equals("Ordem de Serviço")) {
                        OrdemServico.listarOs(oss);
                    } else if (entidade.equals("Veículo")) {
                        Veiculo.listarVeiculos(veiculos);
                    }
                    break;

                case 3:
                    if (entidade.equals("Cliente")) {
                        Cliente.atualizarCliente(sc);
                    } else if (entidade.equals("Funcionário")) {
                        Funcionario.atualizarFunc(sc);
                    } else if (entidade.equals("Peças")) {
                        Peca.atualizarPeca(sc);
                    } else if (entidade.equals("Ordem de Serviço")) {
                        OrdemServico.atualizarrOS(sc, oss);
                    } else if (entidade.equals("Veículo")) {
                        Veiculo.atualizarVeiculo(sc);
                    }
                    break;

                case 4:
                    if (entidade.equals("Cliente")) {
                        Cliente.deletarCliente(sc, clientes);
                    } else if (entidade.equals("Funcionário")) {
                        Funcionario.deletarFunc(sc, funcionarios);
                    } else if (entidade.equals("Peças")) {
                        Peca.deletarPeca(sc, pecas);
                    } else if (entidade.equals("Ordem de Serviço")) {
                        OrdemServico.deletarOs(sc, oss);
                    } else if (entidade.equals("Veículo")) {
                        Veiculo.deletarVeiculo(sc, veiculos);
                    }
                    break;

                case 5:
                    if (entidade.equals("Ordem de Serviço")) {
                        OrdemServico.consultarServicos(sc, oss);
                    } else {
                        System.out.println("Opção inválida! Tente novamente.");
                    }
                    break;

                case 6:
                    if (entidade.equals("Ordem de Serviço")) {
                        OrdemServico.consultaOsFunc(sc, oss);
                    } else {
                        System.out.println("Opção inválida! Tente novamente.");
                    }
                    break;

                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println();

        } while (opcao != 0);
    }
}
