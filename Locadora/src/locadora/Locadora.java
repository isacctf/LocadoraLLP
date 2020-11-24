package locadora;

import Classes.*;
import java.util.*;
import java.util.ArrayList;

public class Locadora {

    public static int MenuPrincipal() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("\nEscolha uma Opção ");
        System.out.println("1. Cliente");
        System.out.println("2. Mídia");
        System.out.println("3. Empréstimo");
        System.out.println("0. Sair");
        return Integer.parseInt(leitor.nextLine());
    }

    public static int SubmenuMídia() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("\nMÍDIA");
        System.out.println("Escolha uma opção: ");
        System.out.println("1. Cadastrar");
        System.out.println("2. Excluir");
        System.out.println("3. Consultar");
        System.out.println("4. Relatório");
        System.out.println("5. Voltar ao menu principal");
        return Integer.parseInt(leitor.nextLine());
    }

    public static int SubmenuCliente() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("\nCLIENTE");
        System.out.println("O cliente é: \n"
                + "1. Pessoa física\n"
                + "2. Pessoa jurídica\n"
                + "3. Voltar ao menu principal\n");
        return Integer.parseInt(leitor.nextLine());
    }

    public static int SubmenuPessoaFisica() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("\nCLIENTE - PESSOA FÍSICA");
        System.out.println("1. Cadastrar");
        System.out.println("2. Excluir");
        System.out.println("3. Consultar");
        System.out.println("4. Relatório");
        System.out.println("5. Voltar ao menu Cliente");
        System.out.println(" ");
        return Integer.parseInt(leitor.nextLine());
    }

    public static int SubmenuPessoaJuridica() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("\nCLIENTE - PESSOA JURÍDICA");
        System.out.println("1. Cadastrar");
        System.out.println("2. Excluir");
        System.out.println("3. Consultar");
        System.out.println("4. Relatório");
        System.out.println("5. Voltar ao menu Cliente");
        return Integer.parseInt(leitor.nextLine());
    }

    public static int SubmenuEmprestimo() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("\nEMPRÉSTIMO");
        System.out.println("Escolha uma das opções:"
                + "\n1. Cadastro"
                + "\n2. Devolução"
                + "\n3. Relatório"
                + "\n4. Voltar ao Menu Principal\n");
        return Integer.parseInt(leitor.nextLine());
    }

    public static void inicializaObjetos(ArrayList<Cliente> arrayCliente, ArrayList<Mídia> arrayMidia) {
        PessoaFisica cla = new PessoaFisica("111.111.111-11", "MG-nseioq", "01", "Clara", "nseioqehisso", "seila", "Raposos", "Minas Gerais", "91111-1111", "11.111-111", 1);
        arrayCliente.add(cla);
        PessoaFisica isa = new PessoaFisica("157.513.476-14", "MG-nseioq", "02", "Isadora", "nseioqehisso", "Graça", "Belo Horizonte", "Minas Gerais", "97514-8366", "31.140-020", 2);
        arrayCliente.add(isa);
        PessoaFisica let = new PessoaFisica("333.333.333-33", "MG-nseioq", "03", "Leticia", "nseioqehisso", "seila", "Ibirité", "Minas Gerais", "93333-3333", "33.333-333", 3);
        arrayCliente.add(let);
        PessoaFisica mar = new PessoaFisica("444.444.444-44", "MG-nseioq", "04", "MariaFernanda", "nseioqehisso", "seila", "Raposos", "Minas Gerais", "94444-4444", "44.444-444", 4);
        arrayCliente.add(mar);

        Mídia tita = new Mídia(1, "Titanic", "Um barco afunda após bater em um iceberg.", "Romance", "Sim", 5.00);
        arrayMidia.add(tita);
        Mídia aveng = new Mídia(2, "VingadoresUltimato", "Depois do Thanos acabar com metade das criaturas vivas, os Vingadores tentam reverter o ocorrido.", "Ficção Científica", "Sim", 60.00);
        arrayMidia.add(aveng);
        Mídia your = new Mídia(3, "YourName", "Duas pessoas são coenctadas através das imagens de seus sonhos", "Romance", "Não", 30.00);
        arrayMidia.add(your);
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int continuar = 1, opcMenuPrinc = 0, opcSubMidia = 0, opcSubCliente = 0, opcSubEmprestimo = 0,
            OpcMenupessoJ = 0, OpcMenupessoF = 0;

        Mídia mid = new Mídia();
        Emprestimo emprestimo = new Emprestimo();
        PessoaJuridica pJuridica = new PessoaJuridica();
        PessoaFisica pFisica = new PessoaFisica();

        ArrayList<Mídia> arrayMidia = new ArrayList<Mídia>();
        ArrayList<Cliente> arrayCliente = new ArrayList<Cliente>();
        ArrayList<Emprestimo> arrayEmprestimo = new ArrayList<Emprestimo>();
        
        inicializaObjetos(arrayCliente, arrayMidia);

        do {
            opcMenuPrinc = MenuPrincipal();
            switch (opcMenuPrinc) {
                case 1:
                    do {
                    opcSubCliente = SubmenuCliente();    
                        switch (opcSubCliente) {
                            case 1:
                                do {
                                    OpcMenupessoF = SubmenuPessoaFisica();
                                    switch (OpcMenupessoF) {
                                        case 1:
                                            arrayCliente.add(pFisica.cadastraClienteFisico());
                                            break;

                                        case 2:
                                            pFisica.excluirClienteFisico(arrayCliente);
                                            break;

                                        case 3:
                                            pFisica.consultaClienteFisico(arrayCliente);
                                            break;

                                        case 4:
                                            pFisica.relatorioClienteFisico(arrayCliente);
                                            break;

                                        case 5:
                                            System.out.println("Voltando ao menu cliente...");
                                            OpcMenupessoF = 8;
                                            break;
                                        
                                        default:
                                            System.out.println("Opção selecionada não existe, tente novamente.");

                                    }
                                } while (OpcMenupessoF != 8);

                            break;

                            case 2:
                                do {
                                    OpcMenupessoJ = SubmenuPessoaJuridica();
                                    switch (OpcMenupessoJ) {
                                        case 1:
                                            arrayCliente.add(pJuridica.cadastraClienteJuridico());
                                            break;

                                        case 2:
                                            pJuridica.excluiClienteJuridico(arrayCliente);
                                            break;

                                        case 3:
                                            pJuridica.consultaClienteJuridico(arrayCliente);
                                            break;

                                        case 4:
                                            pJuridica.relatorioClienteJuridico(arrayCliente);
                                            break;

                                        case 5:
                                            System.out.println("Voltando ao menu cliente...");
                                            break;
                                        
                                        default:
                                            System.out.println("Opção selecionada não existe, tente novamente.");
                                            break;
                                    }
                                } while (OpcMenupessoJ != 5);
                            break;    

                            case 3:
                                System.out.println("Voltando ao menu principal...");
                                break;
                            default:
                                System.out.println("Pessoa selecionada não existe, tente novamente.");
                                break;
                        }
                    } while (opcSubCliente != 3);
                    break;

                case 2:
                    do {
                        opcSubMidia = SubmenuMídia();
                        switch (opcSubMidia) {
                            case 1:
                                arrayMidia.add(mid.CadastrarMidia(arrayMidia));
                                break;

                            case 2:
                                mid.ExcluirMidia(arrayMidia);
                                break;

                            case 3:
                                mid.ConsultarMidia(arrayMidia);
                                break;

                            case 4:
                                mid.RelatoriosMidias(arrayMidia);
                                break;

                            case 5:
                                System.out.println("Voltando ao menu principal...");
                                break;
                            default:
                                System.out.println("Opção selecionada não existe, tente novamente.");
                                break;
                        }
                    } while (opcSubMidia != 5);

                    break;

                case 3:
                    boolean achouCliente;
                    
                    do {
                        opcSubEmprestimo = SubmenuEmprestimo();
                        switch (opcSubEmprestimo) {
                            case 1:
                                achouCliente = emprestimo.verificaCliente(arrayCliente);
                                
                                if(achouCliente == true)
                                   arrayEmprestimo.add(emprestimo.cadastrarEmprestimo(arrayCliente, arrayMidia));  
                                else
                                    System.out.println("Não foi possível realizar o cadastro!");
                                
                                break;

                            case 2:
                                emprestimo.devolucaoEmprestimo(arrayEmprestimo);
                                break;

                            case 3:
                                emprestimo.relatorioEmprestimoCliente(arrayEmprestimo);
                                break;

                            case 4:
                                System.out.println("Voltando ao menu principal...");
                                break;

                            default:
                                System.out.println("Opção selecionada não existe, tente novamente.");
                                break;
                        }
                    } while (opcSubEmprestimo != 4);
                    break;

                case 0:
                    continuar = 0;
                    System.out.println("Saindo..");
                    break;
            }

        } while (continuar!= 0);

    }

}
