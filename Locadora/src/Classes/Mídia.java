package Classes;

import java.util.*;

public class Mídia {

    private int codigo;
    private String titulo;
    private String sipnose;
    private String genero;
    private String dublado;
    private double preco;

    public Mídia(int codigo, String titulo, String sipnose, String genero, String dublado, double preco) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.sipnose = sipnose;
        this.genero = genero;
        this.dublado = dublado;
        this.preco = preco;
    }

    public Mídia() {

    }

    //Cadastrar Mídia no array
    public Mídia CadastrarMidia(ArrayList midias) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Título: ");
        this.titulo = leitor.nextLine();
        System.out.println("Sipnose: ");
        this.sipnose = leitor.nextLine();
        System.out.println("Gênero: ");
        this.genero = leitor.nextLine();
        System.out.println("Dublado: ");
        this.dublado = leitor.nextLine();
        System.out.println("Preço: ");
        this.preco = leitor.nextDouble();
        System.out.println("Código: ");
        this.codigo = leitor.nextInt();
        System.out.println(" ");

        Mídia mid = new Mídia(this.codigo, this.titulo, this.sipnose, this.genero, this.dublado,
                this.preco);
        return mid;
    }

    //Excluir Mídia do array
    public void ExcluirMidia(ArrayList midia) {
        Scanner leitor = new Scanner(System.in);
        int codigo, opc;
        boolean achouMidia = false;

        System.out.println("Insira o código da mídia: ");
        codigo = leitor.nextInt();
        for (int i = 0; i < midia.size(); i++) {
            Mídia m = (Mídia) midia.get(i);
            if (codigo == m.getCodigo()) {
                System.out.println(" ");
                achouMidia = true;
                System.out.println("Realmente deseja excluir essa mídia?");
                System.out.println("1. Sim");
                System.out.println("2. Não");
                opc = leitor.nextInt();
                
                if (opc == 1) {
                    midia.remove(m);
                    System.out.println("Mídia excluída!");
                } else {
                    System.out.println("Mídia não foi excluída!");
                }
            } 
        }
        if(achouMidia == false)
            System.out.println("Mídia não encontrada!");
    }

    //Consultar Mídia no array
    public void ConsultarMidia(ArrayList midia) {
        Scanner leitor = new Scanner(System.in);
        int codigo;
        boolean achouMidia= false;

        System.out.println("Digite o código da mídia: ");
        codigo = leitor.nextInt();
        for (int i = 0; i < midia.size(); i++) {
            Mídia mid = (Mídia) midia.get(i);
            if (codigo == mid.getCodigo()) {
                mid.ImprimirMídia();
                achouMidia = true;
            } 
        }
        if(achouMidia == false)
            System.out.println("Mídia não encontrada!");
    }

    public void RelatoriosMidias(ArrayList midia) {
        for (int i = 0; i < midia.size(); i++) {
            Mídia mid = (Mídia) midia.get(i);
            if (mid instanceof Mídia) {
                mid.ImprimirMídia();
            } else {
                System.out.println("Lista vazia!");
            }
        }
    }

    //Imprimir Mídia
    public void ImprimirMídia() {

        System.out.println("Código: " + this.codigo);
        System.out.println("Título: " + this.titulo);
        System.out.println("Sipnose: " + this.sipnose);
        System.out.println("Gênero: " + this.genero);
        System.out.println("Dublado: " + this.dublado);
        System.out.println("Preço: " + this.preco);

        System.out.println(" ");
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSipnose() {
        return sipnose;
    }

    public String getGenero() {
        return genero;
    }

    public String getDublado() {
        return dublado;
    }

    public double getPreco() {
        return preco;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSipnose(String sipnose) {
        this.sipnose = sipnose;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDublado(String dublado) {
        this.dublado = dublado;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
