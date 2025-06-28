public class ItemOS {
    private Peca peca;
    private int qtd;
    private double valor;

    public ItemOS(Peca peca, double valor, int qtd) {
        this.peca = peca;
        this.valor = valor;
        this.qtd = qtd;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
