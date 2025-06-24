import java.util.ArrayList;

public class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private int chassi;
    private String motor;
    private Cliente cliente;

    public void criarVeiculo(){

    }

    public void atualizarVeiculo(){

    }

    public void deletarVeiculo(){

    }

    public void listarVeiculos(){

    }

    public Veiculo buscarVeiculoPelaPlaca(ArrayList<Veiculo> veiculos, String placa){
        for(Veiculo v : veiculos){
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
