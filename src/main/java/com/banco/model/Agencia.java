package main.java.com.banco.model;

import java.util.List;

public class Agencia {
    private List<Conta> contas;
    private int numero;
    private Banco banco;
    private String endereco;

    public Agencia(List<Conta> contas, int numero, Banco banco, String endereco) {
        this.contas = contas;
        this.numero = numero;
        this.banco = banco;
        this.endereco = endereco;
    }

    public Conta buscarContaPorId(int id) {
        return contas.stream().filter(conta -> conta.getId() == id).findFirst().orElse(null);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void listaDeContas() {
        contas.forEach(conta -> System.out.println("Conta ID: " + conta.getId() + ", Saldo: " + conta.getSaldo()));
    }
}
