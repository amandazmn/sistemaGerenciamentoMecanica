import java.util.ArrayList;

public class Peca {
    private int id;
    private String marca;
    private double valor;
    private String desc;

    public void criarPeca(){

    }

    public void atualizarPeca(){

    }

    public void deletarPeca(){

    }

    public void listarPecas(){

    }

    public Peca buscarPecaPorId(int id, ArrayList<Peca> pecas){
        for (Peca p : pecas){
            if(p.getId() == id){
                return p;
            }
        }
        System.out.println("Peca nao encontrada!");
        return null;
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
