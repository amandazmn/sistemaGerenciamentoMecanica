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

    public static void consultarServicos(Scanner sc, ArrayList<OrdemServico> oss){
        Veiculo v = new Veiculo();
        System.out.println("Placa veiculo a ser consultado: ");
        String placa = sc.nextLine();

        v = v.buscarVeiculoPelaPlaca(placa);

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

    public static void consultaOsFunc(Scanner sc, ArrayList<OrdemServico> oss){
        Funcionario f = new Funcionario();
        System.out.println("Cpf funcionario a ser consultado: ");
        String cpf = sc.nextLine();

        f = Funcionario.buscarFuncPorCpf(cpf);

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

    public static void criarOs(Scanner sc, ArrayList<OrdemServico> oss){
        OrdemServico os = new OrdemServico();
        Cliente c = new Cliente();
        Veiculo v = new Veiculo();
        Funcionario f = new Funcionario();
        Peca p = new Peca();
        ArrayList<ItemOS> pecasOs = new ArrayList<>();
        ItemOS itemOS;

        int nOs = oss.size() + 1;
        System.out.println("Criando os n " + nOs);
        os.setOs(nOs);
        System.out.println("Informe cpf/cnpj cliente: ");
        c = Cliente.buscarCliPorCpfCnpj(sc.nextLine());
        if (c == null){
            return;
        }
        os.setCliente(c);
        System.out.println("Informe placa veiculo: ");
        v = Veiculo.buscarVeiculoPelaPlaca(sc.nextLine());
        if (v == null){
            return;
        }
        os.setVeiculo(v);
        System.out.println("Informe km veiculo: ");
        os.setKm(Integer.parseInt(sc.nextLine()));
        System.out.println("Informe cpf funcionario: ");
        f = Funcionario.buscarFuncPorCpf(sc.nextLine());
        if (f == null){
            return;
        }
        os.setResponsavel(f);

        System.out.println("- - Pecas - -\nobs: Para terminar a insercao de pecas digite -1");
        int id = 0;
        do{
            System.out.println("Informe id da peca: ");
            id = Integer.parseInt(sc.nextLine());
            p = Peca.buscarPecaPorId(id);
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

    public static void atualizarrOS(Scanner sc, ArrayList<OrdemServico> oss){
        OrdemServico os = new OrdemServico();

        System.out.println("Informe o numero da os a ser editada: ");
        int nOs = Integer.parseInt(sc.nextLine());
        os = oss.get(nOs);

        if(os != null) {
            System.out.println("Atualize as informações");
            System.out.println("Cliente: " + os.getCliente().getCpf() + " / " + os.getCliente().getCnpj());
            String cli = sc.nextLine();
            if (cli != null && !cli.isEmpty() && !cli.equals("0")) {
                Cliente cliNovo = new Cliente();
                cliNovo = Cliente.buscarCliPorCpfCnpj(cli);
                if(cliNovo != null){
                    os.setCliente(cliNovo);
                }
            }

            System.out.println("Veiculo: " + os.getVeiculo().getPlaca());
            String placa = sc.nextLine();
            if (placa != null && !placa.isEmpty() && !placa.equals("0")) {
                Veiculo v = new Veiculo();
                v = Veiculo.buscarVeiculoPelaPlaca(placa);
                if(v != null){
                    os.setVeiculo(v);
                }
            }

            System.out.println("Km do veiculo (para não alterar digite -1): " + os.getKm());
            int km = Integer.parseInt(sc.nextLine());
            if (km >= 0) {
                os.setKm(km);
            }

            System.out.println("Deseja atualizar as pecas da os (0 - nao | 1 - sim): ");
            int op = Integer.parseInt(sc.nextLine());
            if(op == 1){
                for(ItemOS i : os.getPecasOs()){
                    System.out.println("Id peca: " + i.getPeca().getId());
                    int id = Integer.parseInt(sc.nextLine());
                    if (id != 0){
                        Peca p = new Peca();
                        p = Peca.buscarPecaPorId(id);
                        if (p != null){
                            System.out.println("Informe quantidade: ");
                            ItemOS ios = new ItemOS(p, p.getValor(),Integer.parseInt(sc.nextLine()));
                            int index = os.getPecasOs().indexOf(i);
                            os.getPecasOs().set(index, ios);
                        }
                    }
                }
            }

            System.out.println("Cpf Responsavel: " + os.getResponsavel().getCpf() + " | " + os.getResponsavel().getNome());
            String cpf = sc.nextLine();
            if (cpf != null && !cpf.isEmpty() && !cpf.equals("0")) {
                Funcionario f = new Funcionario();
                f = Funcionario.buscarFuncPorCpf(cpf);
                if(f != null){
                    os.setResponsavel(f);
                }
            }

            System.out.println("Descrição: " + os.getDesc());
            String desc = sc.nextLine();
            if (desc != null && !desc.isEmpty() && !desc.equals("0")) {
                os.setDesc(desc);
            }

            System.out.println("Obs: " + os.getDesc());
            String obs = sc.nextLine();
            if (obs != null && !obs.isEmpty() && !obs.equals("0")) {
                os.setObs(obs);
            }

            System.out.println("Valor: R$" + os.getValor());
            Double valor = Double.parseDouble(sc.nextLine());
            if (valor != 0) {
                os.setValor(valor);
            }

            System.out.println("OS atualizada com sucesso!\n" + os.toString());
        }
    }

    public static void listarOs(ArrayList<OrdemServico> oss) {
        System.out.println("- - - LISTA DE ORDENS DE SERVIÇO - - -");
        for (OrdemServico os : oss) {
            System.out.println(os.toString());
        }
        System.out.println("- - - - - - - - - - - - - - - - - - -");
    }


    public static void deletarOs(Scanner sc, ArrayList<OrdemServico> oss){
        OrdemServico os = new OrdemServico();

        System.out.println("Informe a numero da os a ser excluido: ");
        int num = Integer.parseInt(sc.nextLine());
        os = buscarOs(num);

        if (os != null) {
            oss.remove(os);
            System.out.println("OS excluido com sucesso!");
        }
    }

    public static OrdemServico buscarOs(int numero) {
        ArrayList<OrdemServico> oss = Main.oss;
        for (OrdemServico os : oss) {
            if (os.getOs() == numero) {
                return os;
            }
        }
        System.out.println("Ordem de Serviço informada não existe!");
        return null;
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
