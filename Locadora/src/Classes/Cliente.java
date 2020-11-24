package Classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    Scanner in = new Scanner(System.in);
    public String codigo, nome, logradouro, bairro, municipio, estado, telefone, cep;
    public int numero;
    final int MAX_MIDIAS = 5;

    // instancia Cliente
    public Cliente(String codigo, String nome, String logradouro, String bairro, String municipio, String estado, String telefone, String cep, int numero) {
        this.codigo = codigo;
        this.nome = nome;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.municipio = municipio;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
        this.numero = numero;
    }

    public Cliente() {
    }

    //Cadastra o cliente
    public void cadastraCliente() {
        System.out.println("Insira o código: ");
        this.codigo = in.next();
        System.out.println("Insira o nome: ");
        this.nome = in.next();
        System.out.println("Insira o telefone: ");
        this.telefone = in.next();
        System.out.println("Insira o logradouro: ");
        this.logradouro = in.next();
        System.out.println("Insira o bairro: ");
        this.bairro = in.next();
        System.out.println("Insira o município: ");
        this.municipio = in.next();
        System.out.println("Insira o estado: ");
        this.estado = in.next();
        System.out.println("Insira o número: ");
        this.numero = in.nextInt();
        System.out.println("Insira o CEP: ");
        this.cep = in.next();
    }

    //verifica cadastros do cliente
    public boolean verificaCadastrosCliente(ArrayList arrayCliente) {
        return arrayCliente.isEmpty();
    }

    //excluí Cliente
    public void excluiCliente(ArrayList arrayCliente, Cliente cliente) {
        System.out.println("\nVocê tem certeza que deseja exluir esse cliente?"
                + "\n1 - SIM"
                + "\n2 - NÃO");
        int opcao = in.nextInt();
        switch (opcao) {
            case 1:
                arrayCliente.remove(cliente);
                System.out.println("\nCliente exluído com sucesso\n");
                break;
            case 2:
                System.out.println("\nOperação cancelada\n");
                break;
        }
    }
    

    //imprime as informações do cliente
    public void imprimeCliente() {
        System.out.println("Código: " + this.codigo);
        System.out.println("Nome: " + this.nome);
        System.out.println("Logradouro: " + this.logradouro);
        System.out.println("Número: " + this.numero);
        System.out.println("Bairro: " + this.bairro);
        System.out.println("Município: " + this.municipio);
        System.out.println("Estado: " + this.estado);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("CEP: " + this.cep);
    }

    //getters e setters
    public Scanner getIn() {
        return in;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
