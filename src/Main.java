import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    public static ArrayList<ItemOS> itensOS;
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
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    if (entidade.equals("Cliente")) {
                        Cliente.criarCliente(sc, clientes);
                    } else if (entidade.equals("Funcionário")) {
                        Funcionario.criarFunc(sc, funcionarios);
                    } else if (entidade.equals("Peças")) {
                        System.out.println("Executando criação de Peça...");
                        // Pecas.criar();
                    } else if (entidade.equals("Ordem de Serviço")) {
                        System.out.println("Executando criação de Ordem de Serviço...");
                        // OrdemServico.criar();
                    } else if (entidade.equals("Veículo")) {
                        System.out.println("Executando criação de Veículo...");
                        // Veiculo.criar();
                    }
                    break;

                case 2:
                    if (entidade.equals("Cliente")) {
                        Cliente.listarClientes(clientes);
                    } else if (entidade.equals("Funcionário")) {
                        Funcionario.listarFunc(funcionarios);
                    } else if (entidade.equals("Peças")) {
                        System.out.println("Listando Peças...");
                    } else if (entidade.equals("Ordem de Serviço")) {
                        System.out.println("Listando Ordens de Serviço...");
                    } else if (entidade.equals("Veículo")) {
                        System.out.println("Listando Veículos...");
                    }
                    break;

                case 3:
                    if (entidade.equals("Cliente")) {
                        Cliente.atualizarCliente(sc, clientes);
                    } else if (entidade.equals("Funcionário")) {
                        Funcionario.atualizarFunc(sc, funcionarios);
                    } else if (entidade.equals("Peças")) {
                        System.out.println("Atualizando Peça...");
                    } else if (entidade.equals("Ordem de Serviço")) {
                        System.out.println("Atualizando Ordem de Serviço...");
                    } else if (entidade.equals("Veículo")) {
                        System.out.println("Atualizando Veículo...");
                    }
                    break;

                case 4:
                    if (entidade.equals("Cliente")) {
                        Cliente.deletarCliente(sc, clientes);
                    } else if (entidade.equals("Funcionário")) {
                        Funcionario.deletarFunc(sc, funcionarios);
                    } else if (entidade.equals("Peças")) {
                        System.out.println("Deletando Peça...");
                    } else if (entidade.equals("Ordem de Serviço")) {
                        System.out.println("Deletando Ordem de Serviço...");
                    } else if (entidade.equals("Veículo")) {
                        System.out.println("Deletando Veículo...");
                    }
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println(); // linha em branco

        } while (opcao != 0);
    }
}
