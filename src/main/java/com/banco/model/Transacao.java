package main.java.com.banco.model;

import java.util.Date;

public class Transacao {
    private int id;
    private String tipo;
    private Date data;
    private int contaOrigemId;
    private int contaDestinoId;
    private double valor;
    private Banco banco;

    public Transacao(int id, String tipo, Date data, int contaOrigemId, int contaDestinoId, double valor, Banco banco) {
        this.id = id;
        this.tipo = tipo;
        this.data = data;
        this.contaOrigemId = contaOrigemId;
        this.contaDestinoId = contaDestinoId;
        this.valor = valor;
        this.banco = banco;
    }

    public void executarTransacao() {
        Conta contaOrigem = banco.buscarContaPorId(contaOrigemId);
        Conta contaDestino = banco.buscarContaPorId(contaDestinoId);
        if (contaOrigem != null && contaDestino != null) {
            contaOrigem.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transação realizada: " + tipo + " de R$" + valor + " da conta " + contaOrigemId + " para a conta " + contaDestinoId);
        }
    }

    public void estornarTransacao() {
        Conta contaOrigem = banco.buscarContaPorId(contaOrigemId);
        Conta contaDestino = banco.buscarContaPorId(contaDestinoId);
        if (contaOrigem != null && contaDestino != null) {
            contaDestino.sacar(valor);
            contaOrigem.depositar(valor);
            System.out.println("Transação estornada: " + tipo + " de R$" + valor + " da conta " + contaDestinoId + " para a conta " + contaOrigemId);
        }
    }
}
