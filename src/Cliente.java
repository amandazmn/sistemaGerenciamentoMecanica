import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private String cpf;
    private String cnpj;
    private String nome;
    private String telefone;
    private String endereco;

    public static void criarCliente(Scanner sc, ArrayList<Cliente> clientes){
        Cliente cli = new Cliente();

        System.out.println("Informe cpf: ");
        cli.setCpf(sc.nextLine());
        System.out.println("Informe cnpj: ");
        cli.setCnpj(sc.nextLine());
        System.out.println("Informe nome: ");
        cli.setNome(sc.nextLine());
        System.out.println("Informe telefone: ");
        cli.setTelefone(sc.nextLine());
        System.out.println("Informe endereco: ");
        cli.setEndereco(sc.nextLine());

        clientes.add(cli);

        System.out.println("Cliente inserido com sucesso!\n" + cli.toString());
    }

    public static void atualizarCliente(Scanner sc, ArrayList<Cliente> clientes){
        Cliente cli = new Cliente();

        System.out.println("Informe o cpf/cnpj do cliente a ser editado: ");
        String id = sc.nextLine();
        cli = buscarCliPorCpfCnpj(id, clientes);

        if(cli != null) {

            System.out.println("Atualize as informações");
            System.out.println("Cpf: " + cli.getCpf());
            String cpf = sc.nextLine();
            if (cpf != null && !cpf.isEmpty() && !cpf.equals("0")) {
                cli.setCpf(cpf);
            }
            System.out.println("Cnpj: " + cli.getCnpj());
            String cnpj = sc.nextLine();
            if (cnpj != null && !cnpj.isEmpty() && !cnpj.equals("0")) {
                cli.setCnpj(cnpj);
            }
            System.out.println("Nome: " + cli.getNome());
            String nome = sc.nextLine();
            if (nome != null && !nome.isEmpty() && !nome.equals("0")) {
                cli.setNome(nome);
            }
            System.out.println("Telefone: " + cli.getTelefone());
            String telefone = sc.nextLine();
            if (telefone != null && !telefone.isEmpty() && !telefone.equals("0")) {
                cli.setTelefone(telefone);
            }
            System.out.println("Endereco: " + cli.getEndereco());
            String endereco = sc.nextLine();
            if (endereco != null && !endereco.isEmpty() && !endereco.equals("0")) {
                cli.setEndereco(endereco);
            }

            System.out.println("Cliente atualizado com sucesso!\n" + cli.toString());
        }
    }

    public static void deletarCliente(Scanner sc, ArrayList<Cliente> clientes){
        Cliente cli = new Cliente();

        System.out.println("Informe o cpf/cnpj do cliente a ser excluido: ");
        String id = sc.nextLine();
        cli = buscarCliPorCpfCnpj(id, clientes);

        if(cli != null) {
            clientes.remove(cli);
            System.out.println("Cliente excluido com sucesso!");
        }
    }

    public static void listarClientes(ArrayList<Cliente> clientes){
        System.out.println(" - - - CLIENTES - - - \n");
        for(Cliente c : clientes){
            System.out.println(c.toString());
        }
        System.out.println(" - - - - - - - - - - -\n");
    }

    public static Cliente buscarCliPorCpfCnpj(String id, ArrayList<Cliente> clientes){
        for(Cliente c : clientes){
            if(c.getCpf().equals(id) || c.getCnpj().equals(id)){
                return c;
            }
        }
        System.out.println("Cliente informado nao existe!");
        return null;
    }

    @Override
    public String toString() {
        return "Cliente:" +
                "cpf='" + cpf + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'';
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
