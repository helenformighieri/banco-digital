package main.java.com.banco.model;

import java.util.Date;

public class Transacao {
    private int id;
    private String tipoConta;
    private Date data;
    private int contaOrigem;
    private int contaDestino;
    private double valor;
    private Banco banco;

    public Transacao(int id, String tipoConta, Date data, int contaOrigem, int contaDestino, double valor, Banco banco) {
        this.id = id;
        this.tipoConta = tipoConta;
        this.data = data;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.banco = banco;
    }

    public int getId() {
        return id;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public Date getData() {
        return data;
    }

    public int getContaOrigem() {
        return contaOrigem;
    }

    public int getContaDestino() {
        return contaDestino;
    }

    public double getValor() {
        return valor;
    }

    public void executarTransacao() {
        Conta origem = banco.getContas().stream()
                .filter(conta -> conta.getId() == contaOrigem)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Conta de origem não encontrada"));

        Conta destino = banco.getContas().stream()
                .filter(conta -> conta.getId() == contaDestino)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Conta de destino não encontrada"));

        origem.transferir(valor, destino);
    }

    public void estornarTransacao() {
        Conta origem = banco.getContas().stream()
                .filter(conta -> conta.getId() == contaOrigem)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Conta de origem não encontrada"));

        Conta destino = banco.getContas().stream()
                .filter(conta -> conta.getId() == contaDestino)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Conta de destino não encontrada"));

        destino.transferir(valor, origem);
    }
}