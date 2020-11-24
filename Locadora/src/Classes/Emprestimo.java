package Classes;
import java.util.*;

public class Emprestimo {
    private ArrayList<Mídia> arrayMidiasEmprestimo = new ArrayList<Mídia>();
    private Cliente cliente;
    private int ano;
    private int mes;
    private int dia;
    private String codigo;
    private double multa;
    private double valorMidia;
    private double valorTotal;
    private boolean devolvido;
    

    public Emprestimo(ArrayList<Mídia> midiasEmprestimo, Cliente cliente, String codigo, int ano, int mes, int dia){
        this.codigo = codigo;
        this.arrayMidiasEmprestimo = midiasEmprestimo;
        this.cliente = cliente;
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.valorMidia = valorMidia;
        this.multa = multa;
        this.valorTotal = multa + valorMidia;
        this.devolvido = false;
    }
    
    public Emprestimo() {  
    }
    
    //Verifica se o cliente existe
    public boolean verificaCliente(ArrayList<Cliente> arrayCliente){
        Scanner leitor = new Scanner(System.in);
        boolean achouCliente = false;
        String nome;
        
        System.out.println("Digite o nome do cliente que realizará o empréstimo: ");
        nome = leitor.nextLine();
        
        for (int k = 0; k < arrayCliente.size(); k++) {
            Cliente c = arrayCliente.get(k);
                if(c.getNome().equals(nome)){
                   this.cliente = c;
                   achouCliente = true;
                }         
        }
        if(achouCliente == false) {
              System.out.println("Cliente não encontrado!"); 
        }
        return achouCliente;
    }
    
    //Cadastro do empréstimo
    public Emprestimo cadastrarEmprestimo(ArrayList<Cliente> arrayCliente, ArrayList<Mídia> arrayMidia){
        Scanner leitor = new Scanner(System.in);
        int numMidias;
        double aux = 0;
        String midiaAux, nome;
        boolean achouMidia = false, achouCliente = false;
        
        System.out.println("Digite o código do empréstimo: ");
        this.codigo = leitor.nextLine();
        System.out.println("Digite o ano do empréstimo: ");
        this.ano = leitor.nextInt();
        System.out.println("Digite o mês do empréstimo: ");
        this.mes = leitor.nextInt();
        System.out.println("Digite o dia do empréstimo: ");
        this.dia = leitor.nextInt();
        System.out.println("Digite o numéro de mídias para empréstimo: ");
        numMidias = leitor.nextInt();
        
        //Verifica se a mídia existe e cria um array com as mídias do empréstimo
        for(int i = 0; i < numMidias; i++, achouMidia = false) {
            System.out.println("Digite o título da midia: ");
            midiaAux = leitor.next(); 
           
            for(int j = 0; j < arrayMidia.size(); j++) {
                Mídia m = (Mídia) arrayMidia.get(j);
                if(midiaAux.equals(m.getTitulo())){
                    arrayMidiasEmprestimo.add(m);
                    achouMidia = true;
                    aux += m.getPreco();
                    System.out.println("Mídia acrescentada"); 
                }
            }
            
            if(achouMidia == false) {
                System.out.println("Mídia não encontrada!"); 
                i--;
            } 
        }
        
        this.valorMidia = aux;
        setValorMidia(this.valorMidia);
        
        System.out.println("Valor do empréstimo da(s) mídia(s): R$" + this.valorMidia);
        Emprestimo e = new Emprestimo(this.arrayMidiasEmprestimo, this.cliente, this.codigo, this.ano, this.mes, this.dia);

        System.out.println("\nEmpréstimo cadastrado com sucesso!!");
        System.out.println("Você terá uma semana de praso para a devolução, após isso uma multa de R$1,00 será cobrada a cada dia de atraso.");
        System.out.println("Caso o empréstimo dure mais de 30 dias, a multa passará a possuir um valor fixo de R$100,00.");
        return e;
    }
    
    //
    public void devolucaoEmprestimo(ArrayList <Emprestimo> arrayEmprestimo) {
        Scanner leitor = new Scanner(System.in);
        Emprestimo emprestimoDevolucao =  new Emprestimo();
        String codigoEmprestimo;
        boolean achouEmprestimo = false;
        int diaA, mesA, anoA, pago;
      
        System.out.println("Digite o código do empréstimo que deseja fazer a devolução:");
        codigoEmprestimo = leitor.nextLine();
        
        for(int i = 0; i < arrayEmprestimo.size(); i++) {
            Emprestimo e = arrayEmprestimo.get(i);
            if(e.getCodigo().equals(codigoEmprestimo)){
                emprestimoDevolucao = e;
                achouEmprestimo = true;
            } 
        }
        
        if(achouEmprestimo == false) {
            System.out.println("Empréstimo não encontrado!"); 
        }
        else if(this.devolvido == false){
            //Solicita a entrada dos dados do dia da devolução
            System.out.println("Insira a data atual:");
            System.out.println("Digite o dia:");
            diaA = leitor.nextInt();
            System.out.println("Digite o mês:");
            mesA = leitor.nextInt();
            System.out.println("Digite o ano:");
            anoA = leitor.nextInt();
            
            //Calcula o valor a ser pago, caso haja multa o valor da mesma é acrescentado
            System.out.println("Valor do aluguel da(s) mídia(s): R$" + this.valorMidia);
            emprestimoDevolucao.calcularMulta(diaA, mesA, anoA);
            if(emprestimoDevolucao.getMulta() != 0.00) 
                System.out.println("Devolução feita após o prazo, valor da multa: R$" + emprestimoDevolucao.getMulta());

            this.valorTotal = this.valorMidia + emprestimoDevolucao.getMulta();
            emprestimoDevolucao.setValorTotal(this.valorTotal);
            System.out.println("Valor total a ser pago: R$" + this.valorTotal);
            
            System.out.println("Valor pago?");
            System.out.println("1. Sim"
                        + "\n2. Não");
            pago = leitor.nextInt();
            
            if(pago == 1)
                emprestimoDevolucao.devolvido = true;
        }
        else 
            System.out.println("Empréstimo já devolvido!");
        
    }
    
    //Calcula o valor da multa de acordo com o tempo de atraso
    public void calcularMulta(int diaA, int mesA, int anoA) {
        int diasFevereiro = 28, diasMes = 0, nDiasPassados = 0, aux = this.dia;
        
        //Verifica se o ano é bissexto
        if((ano%4) == 0) {
            if((ano%100) == 0) {
                if((ano%400) == 0) {
                  diasFevereiro = 29;  
                }
            }
            else {
                diasFevereiro = 29;
            }
        } 
        
        //Define a quantidade de dias do mês
        switch(this.mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                diasMes = 31;
                break;
                
            case 4:
            case 6:
            case 9:
            case 11:
                diasMes = 30;
                break;
                
            case 2:
                diasMes = diasFevereiro;
                break;
        }
        
        //Verifica se a devolução foi realizada antes dos 7 dias
        //Caso ultrapasse esses 7 dis a multa é calculada
        //Caso passe de 30 dias a multa é definida como 100
        if(anoA != this.ano && this.mes != 12) 
            this.multa = 100.00;
        else if(this.mes != mesA - 1 && this.mes != mesA) 
            setMulta(100.00);
        else {
            if(diaA < this.dia) {
                nDiasPassados = diasMes - aux;
                aux = 1;
            }
            
            while(aux != diaA) {
                nDiasPassados++;
                aux ++;
            }
        
            if(nDiasPassados > 7) {
                if(nDiasPassados  > 30) 
                    this.multa = 100.00;       
                else {
                    this.multa = nDiasPassados - 7;
                }
            }
            else
                this.multa = 0.00; 
        }
        System.out.println(nDiasPassados);
    }
    
    //Imprime um empréstimo 
    public void imprimirEmprestimo() {
        System.out.println("Código do empréstimo: " + this.codigo);
        System.out.println("Nome do cliente: " + this.cliente.getNome());
        System.out.println("Data do empréstimo: " + this.dia + " / " + this.mes + " / " + this.ano);
        
        if(this.devolvido == false)
            System.out.println("Empréstimo não devolvido.");
        else
            System.out.println("Empréstimo devolvido.");
        
        System.out.println("Mídia(s):");
        for(int i = 0; i < this.arrayMidiasEmprestimo.size(); i++) {
            Mídia m = arrayMidiasEmprestimo.get(i);
            System.out.println("Título da mídia " + (i+1) +": " + m.getTitulo());
        }
        
    }
    
    //Imprime todos os empréstimos feitos por certo cliente 
    public void relatorioEmprestimoCliente(ArrayList <Emprestimo> arrayEmprestimo) {
        Scanner leitor = new Scanner(System.in);
        boolean clienteEncontrado = false;
        String clienteNome;
        
        System.out.println("Digite o nome do cliente que deseja imprimir os empréstimos");
        clienteNome = leitor.nextLine();
        
        System.out.println("\nEmpréstimos do cliente "+ clienteNome +"\n");
        for (int i = 0; i < arrayEmprestimo.size(); i++) {
            Emprestimo e = arrayEmprestimo.get(i);
            Cliente c = e.getCliente();
            if(c.getNome().equals(clienteNome)){
                clienteEncontrado = true;
                e.imprimirEmprestimo();
            }
        }
        
        if (clienteEncontrado == false)
            System.out.println("Cliente " + clienteNome + " não encontrado!");
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public double getMulta() {
        return multa;
    }
    public void setMulta(double multa) {
        this.multa = multa;
    }
    
    public double getValorMidia() {
        return valorMidia;
    }
    public void setValorMidia(double valorMidia) {
        this.valorMidia = valorMidia;
    }
    
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}

