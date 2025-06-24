import java.util.ArrayList;
import java.util.Scanner;

public class OrdemServico {
    private int os;
    private Cliente cliente;
    private Veiculo veiculo;
    private int km;
    private ArrayList<ItemOS> pecasOs;
    private Funcionario responsavel;
    private String desc;
    private String obs;
    private double valor;

    public void consultarServicos(Scanner sc, ArrayList<OrdemServico> oss, ArrayList<Veiculo> veiculos){
        Veiculo v = new Veiculo();
        System.out.println("Placa veiculo a ser consultado: ");
        String placa = sc.nextLine();

        v = v.buscarVeiculoPelaPlaca(veiculos, placa);

        double total = 0;
        ArrayList<OrdemServico> osVeiculo = new ArrayList<>();
        if (v != null){
            for (OrdemServico os : oss){
                if (os.getVeiculo().equals(v)){
                    osVeiculo.add(os);
                    total = total + os.getValor();
                }
            }
        }

        System.out.println(osVeiculo.size() + " ordens de servico para o veiculo " + placa + "\nDetalhes das OS: " + osVeiculo.toString());
        System.out.println("\nTotal valor investido: " + total);

    }

    public void consultaOsFunc(Scanner sc, ArrayList<OrdemServico> oss, ArrayList<Funcionario> funcionarios){
        Funcionario f = new Funcionario();
        System.out.println("Cpf funcionario a ser consultado: ");
        String cpf = sc.nextLine();

        f = Funcionario.buscarFuncPorCpf(cpf, funcionarios);

        double total = 0;
        ArrayList<OrdemServico> osFunc = new ArrayList<>();
        if (f != null){
            for (OrdemServico os : oss){
                if (os.getResponsavel().equals(f)){
                    osFunc.add(os);
                    total = total + os.getValor();
                }
            }
        }

        System.out.println(f.getNome() + " foi responsavel por " + osFunc.size() + " ordens de servico\nDetalhes das OS: " + osFunc.toString());
        System.out.println("\nTotal valor das os's: " + total);
    }

    public void criarOs(Scanner sc, ArrayList<OrdemServico> oss, ArrayList<Cliente> clientes, ArrayList<Veiculo> veiculos, ArrayList<Funcionario> funcionarios, ArrayList<Peca> pecas){
        OrdemServico os = new OrdemServico();
        Cliente c = new Cliente();
        Veiculo v = new Veiculo();
        Funcionario f = new Funcionario();
        Peca p = new Peca();
        ArrayList<ItemOS> pecasOs = new ArrayList<>();
        ItemOS itemOS;

        System.out.println("Informe os: ");
        os.setOs(Integer.parseInt(sc.nextLine()));
        System.out.println("Informe cpf/cnpj cliente: ");
        c = Cliente.buscarCliPorCpfCnpj(sc.nextLine(), clientes);
        if (c == null){
            return;
        }
        os.setCliente(c);
        System.out.println("Informe placa veiculo: ");
        v = v.buscarVeiculoPelaPlaca(veiculos, sc.nextLine());
        if (v == null){
            return;
        }
        os.setVeiculo(v);
        System.out.println("Informe km veiculo: ");
        os.setKm(Integer.parseInt(sc.nextLine()));
        System.out.println("Informe cpf funcionario: ");
        f = Funcionario.buscarFuncPorCpf(sc.nextLine(), funcionarios);
        if (f == null){
            return;
        }
        os.setResponsavel(f);

        System.out.println("- - Pecas - -\nobs: Para terminar a insercao de pecas digite -1");
        int id = 0;
        do{
            System.out.println("Informe id da peca: ");
            id = Integer.parseInt(sc.nextLine());
            p = p.buscarPecaPorId(id, pecas);
            if(p != null){
                System.out.println("Informe quantidade: ");
                itemOS = new ItemOS(p, p.getValor(), Integer.parseInt(sc.nextLine()));
                pecasOs.add(itemOS);
            }
        }while(id != -1);

        System.out.println("Informe descricao: ");
        os.setDesc(sc.nextLine());
        System.out.println("Informe obs: ");
        os.setObs(sc.nextLine());
        System.out.println("Informe valor: ");
        os.setValor(Double.parseDouble(sc.nextLine()));

        oss.add(os);

        System.out.println("OS inserido com sucesso!\n" + os.toString());
    }

    public void atualizarrOS(){

    }

    public void listarOs(){

    }

    public void deletarOs(){

    }

    @Override
    public String toString() {
        return "OrdemServico: " +
                "os=" + os +
                ", cliente=" + cliente +
                ", veiculo=" + veiculo +
                ", km=" + km +
                ", pecasOs=" + pecasOs +
                ", responsavel=" + responsavel +
                ", desc='" + desc + '\'' +
                ", obs='" + obs + '\'' +
                ", valor=" + valor;
    }

    public int getOs() {
        return os;
    }

    public void setOs(int os) {
        this.os = os;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public ArrayList<ItemOS> getPecasOs() {
        return pecasOs;
    }

    public void setPecasOs(ArrayList<ItemOS> pecasOs) {
        this.pecasOs = pecasOs;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
