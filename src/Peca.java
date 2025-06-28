import java.util.ArrayList;
import java.util.Scanner;

public class Peca {
    private int id;
    private String marca;
    private double valor;
    private String desc;

    public static void criarPeca(Scanner sc, ArrayList<Peca> pecas) {
        Peca p = new Peca();

        p.setId(pecas.size() + 1);
        System.out.println("Informe marca: ");
        p.setMarca(sc.nextLine());
        System.out.println("Informe descrição: ");
        p.setDesc(sc.nextLine());
        System.out.println("Informe valor: ");
        p.setValor(Double.parseDouble(sc.nextLine()));

        pecas.add(p);

        System.out.println("Peca inserida com sucesso!\n" + p.toString());
    }

    public static void atualizarPeca(Scanner sc) {
        Peca p = new Peca();

        System.out.println("Informe o id da peca a ser editada: ");
        int id = Integer.parseInt(sc.nextLine());
        p = buscarPecaPorId(id);

        if (p != null) {
            System.out.println("Atualize as informações");
            System.out.println("Marca: " + p.getMarca());
            String marca = sc.nextLine();
            if (marca != null && !marca.isEmpty() && !marca.equals("0")) {
                p.setMarca(marca);
            }

            System.out.println("Descrição: " + p.getDesc());
            String desc = sc.nextLine();
            if (desc != null && !desc.isEmpty() && !desc.equals("0")) {
                p.setDesc(desc);
            }

            System.out.println("Valor: " + p.getValor());
            String valorStr = sc.nextLine();
            if (valorStr != null && !valorStr.isEmpty() && !valorStr.equals("0")) {
                p.setValor(Double.parseDouble(valorStr));
            }

            System.out.println("Peca atualizada com sucesso!\n" + p.toString());
        }
    }

    public static void deletarPeca(Scanner sc, ArrayList<Peca> pecas) {
        Peca p = new Peca();

        System.out.println("Informe o id da peca a ser excluida: ");
        int id = Integer.parseInt(sc.nextLine());
        p = buscarPecaPorId(id);

        if (p != null) {
            pecas.remove(p);
            System.out.println("Peca excluida com sucesso!");
        }
    }

    public static void listarPecas(ArrayList<Peca> pecas) {
        System.out.println("- - - LISTA DE PECAS - - -");
        for (Peca p : pecas) {
            System.out.println(p.toString());
        }
        System.out.println("- - - - - - - - - - - - -");
    }

    public static Peca buscarPecaPorId(int id) {
        ArrayList<Peca> pecas = Main.pecas;
        for (Peca p : pecas) {
            if (p.getId() == id) {
                return p;
            }
        }
        System.out.println("Peca nao encontrada!");
        return null;
    }

    @Override
    public String toString() {
        return "Peca: " +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", desc='" + desc + '\'' +
                ", valor=" + valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
