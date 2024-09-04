package main.java.com.banco.model;

import java.util.List;

public class Cliente {
    private String nome;
    private List<Conta> contas;

    public Cliente(List<Conta> contas) {
        this.contas = contas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public double consultarSaldoTotal() {
        return contas.stream().mapToDouble(Conta::getSaldo).sum();
    }

    public void atualizarDados(String novoNome) {
        this.nome = novoNome;
    }
}
