package main.java.com.banco.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    private static int contadorDeIds = 1;

    private int id;
    private Cliente cliente;
    private double saldo;
    private List<String> extrato;

    public Conta(Cliente cliente) {
        this.id = contadorDeIds++;
        this.cliente = cliente;
        this.saldo = 0.0;
        this.extrato = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void adicionarExtrato(String operacao) {
        extrato.add(operacao);
    }

    public void consultarExtrato() {
        System.out.println("Extrato da Conta " + id + ": ");
        extrato.forEach(System.out::println);
    }

    public void depositar(double valor) {
        saldo += valor;
        adicionarExtrato("Depósito: +" + valor);
    }

    public void sacar(double valor) {
        saldo -= valor;
        adicionarExtrato("Saque: -" + valor);
    }

    public void transferir(double valor, Conta destino) {
        this.sacar(valor);
        destino.depositar(valor);
        adicionarExtrato("Transferência para Conta " + destino.getId() + ": -" + valor);
        destino.adicionarExtrato("Transferência recebida da Conta " + this.getId() + ": +" + valor);
    }

    public abstract void imprimirExtrato();

    protected void imprimirInfosComuns() {
    }
}
