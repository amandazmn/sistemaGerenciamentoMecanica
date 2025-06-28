import java.util.ArrayList;
import java.util.Scanner;

public class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private int chassi;
    private String motor;
    private Cliente cliente;

    public static void criarVeiculo(Scanner sc, ArrayList<Veiculo> veiculos) {
        Veiculo v = new Veiculo();

        System.out.println("Informe placa: ");
        v.setPlaca(sc.nextLine());
        System.out.println("Informe marca: ");
        v.setMarca(sc.nextLine());
        System.out.println("Informe modelo: ");
        v.setModelo(sc.nextLine());
        System.out.println("Informe ano: ");
        v.setAno(Integer.parseInt(sc.nextLine()));
        System.out.println("Informe chassi: ");
        v.setChassi(Integer.parseInt(sc.nextLine()));
        System.out.println("Informe motor: ");
        v.setMotor(sc.nextLine());
        System.out.println("Informe cpf/cnpj do cliente proprietário: ");
        Cliente c = Cliente.buscarCliPorCpfCnpj(sc.nextLine());
        if (c != null) {
            v.setCliente(c);
        }

        veiculos.add(v);
        System.out.println("Veiculo inserido com sucesso!\n" + v.toString());
    }

    public static void atualizarVeiculo(Scanner sc) {
        Veiculo v = new Veiculo();

        System.out.println("Informe a placa do veiculo a ser editado: ");
        String placa = sc.nextLine();
        v = buscarVeiculoPelaPlaca(placa);

        if (v != null) {
            System.out.println("Atualize as informações");
            System.out.println("Placa: " + v.getPlaca());
            String pl = sc.nextLine();
            if (pl != null && !pl.isEmpty() && !pl.equals("0")) {
                v.setPlaca(pl);
            }

            System.out.println("Marca: " + v.getMarca());
            String marca = sc.nextLine();
            if (marca != null && !marca.isEmpty() && !marca.equals("0")) {
                v.setMarca(marca);
            }

            System.out.println("Modelo: " + v.getModelo());
            String modelo = sc.nextLine();
            if (modelo != null && !modelo.isEmpty() && !modelo.equals("0")) {
                v.setModelo(modelo);
            }

            System.out.println("Ano: " + v.getAno());
            String anoStr = sc.nextLine();
            if (anoStr != null && !anoStr.isEmpty() && !anoStr.equals("0")) {
                v.setAno(Integer.parseInt(anoStr));
            }

            System.out.println("Chassi: " + v.getChassi());
            String chassiStr = sc.nextLine();
            if (chassiStr != null && !chassiStr.isEmpty() && !chassiStr.equals("0")) {
                v.setChassi(Integer.parseInt(chassiStr));
            }

            System.out.println("Motor: " + v.getMotor());
            String motor = sc.nextLine();
            if (motor != null && !motor.isEmpty() && !motor.equals("0")) {
                v.setMotor(motor);
            }

            System.out.println("Cliente atual: " + v.getCliente());
            String cli = sc.nextLine();
            if (cli != null && !cli.isEmpty() && !cli.equals("0")) {
                Cliente c = Cliente.buscarCliPorCpfCnpj(cli);
                if (c != null) {
                    v.setCliente(c);
                }
            }

            System.out.println("Veiculo atualizado com sucesso!\n" + v.toString());
        }
    }

    public static void deletarVeiculo(Scanner sc, ArrayList<Veiculo> veiculos) {
        Veiculo v = new Veiculo();

        System.out.println("Informe a placa do veiculo a ser excluido: ");
        String placa = sc.nextLine();
        v = buscarVeiculoPelaPlaca(placa);

        if (v != null) {
            veiculos.remove(v);
            System.out.println("Veiculo excluido com sucesso!");
        }
    }

    public static void listarVeiculos(ArrayList<Veiculo> veiculos) {
        System.out.println("- - - LISTA DE VEICULOS - - -");
        for (Veiculo v : veiculos) {
            System.out.println(v.toString());
        }
        System.out.println("- - - - - - - - - - - - - - - - -");
    }

    @Override
    public String toString() {
        return "Veiculo: " +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", chassi=" + chassi +
                ", motor='" + motor + '\'' +
                ", cliente=" + cliente;
    }

    public static Veiculo buscarVeiculoPelaPlaca(String placa) {
        ArrayList<Veiculo> veiculos = Main.veiculos;
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }
        System.out.println("Veiculo nao encontrado!");
        return null;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getChassi() {
        return chassi;
    }

    public void setChassi(int chassi) {
        this.chassi = chassi;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
