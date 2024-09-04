package main.java.com.banco.model;

import java.util.List;

public class Agencia {
    private int id;
    private Banco banco;
    private String endereco;
    private List<Conta> contas;

    public Agencia(int numero, Banco banco, String endereco, List<Conta> contas) {
        this.id = numero;
        this.banco = banco;
        this.endereco = endereco;
        this.contas = contas;
    }

    public int getId() {
        return id;
    }

    public Banco getBanco() {
        return banco;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public List<Conta> listaDeContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }

    public void buscarContaPorId(int id) {
        for (Conta conta : contas) {
            if (conta.getId() == id) {
                System.out.println(conta);
            }
        }
    }
}