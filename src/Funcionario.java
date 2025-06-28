import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario {
    private String cpf;
    private String nome;
    private String telefone;
    private String cargo;

    public static void criarFunc(Scanner sc, ArrayList<Funcionario> funcionarios){
        Funcionario func = new Funcionario();

        System.out.println("Informe cpf: ");
        func.setCpf(sc.nextLine());
        System.out.println("Informe nome: ");
        func.setNome(sc.nextLine());
        System.out.println("Informe telefone: ");
        func.setTelefone(sc.nextLine());
        System.out.println("Informe cargo: ");
        func.setCargo(sc.nextLine());

        funcionarios.add(func);

        System.out.println("Funcionario inserido com sucesso!\n" + func.toString());
    }

    public static void atualizarFunc(Scanner sc){
        Funcionario func = new Funcionario();

        System.out.println("Informe o cpf do funcionario a ser editado: ");
        String id = sc.nextLine();
        func = buscarFuncPorCpf(id);

        if(func != null){
            System.out.println("Atualize as informações");
            System.out.println("Cpf: " + func.getCpf());
            String cpf = sc.nextLine();
            if (cpf != null && !cpf.isEmpty() && !cpf.equals("0")) {
                func.setCpf(cpf);
            }
            System.out.println("Nome: " + func.getNome());
            String nome = sc.nextLine();
            if (nome != null && !nome.isEmpty() && !nome.equals("0")) {
                func.setNome(nome);
            }
            System.out.println("Telefone: " + func.getTelefone());
            String telefone = sc.nextLine();
            if (telefone != null && !telefone.isEmpty() && !telefone.equals("0")) {
                func.setTelefone(telefone);
            }
            System.out.println("Cargo: " + func.getCargo());
            String cargo = sc.nextLine();
            if (cargo != null && !cargo.isEmpty() && !cargo.equals("0")) {
                func.setCargo(cargo);
            }

            System.out.println("Funcionario atualizado com sucesso!\n" + func.toString());
        }
    }

    public static void deletarFunc(Scanner sc, ArrayList<Funcionario> funcionarios){
        Funcionario func = new Funcionario();

        System.out.println("Informe o cpf/cnpj do cliente a ser excluido: ");
        String id = sc.nextLine();
        func = buscarFuncPorCpf(id);

        if(func != null) {
            funcionarios.remove(func);
            System.out.println("Funcionario excluido com sucesso!");
        }
    }

    public static void listarFunc(ArrayList<Funcionario> funcionarios){
        System.out.println("- - - LISTA DE FUNCIONARIOS - - -");
        for(Funcionario f : funcionarios){
            System.out.println(f.toString());
        }
        System.out.println("- - - - - - - - - - - - - - - - -");
    }

    public static Funcionario buscarFuncPorCpf(String cpf){
        ArrayList<Funcionario> funcionarios = Main.funcionarios;
        for(Funcionario f : funcionarios){
            if(f.getCpf().equals(cpf)){
                return f;
            }
        }
        System.out.println("Funcionario informado nao existe!");
        return null;
    }

    @Override
    public String toString() {
        return "Funcionario: " +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cargo='" + cargo + '\'';
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
