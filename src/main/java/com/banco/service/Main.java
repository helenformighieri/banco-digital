package main.java.com.banco.service;

import main.java.com.banco.model.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Banco banco = criarBanco("LuaBank");
        Agencia agencia = criarAgencia(banco, "Rua de Crystal, 123");

        Cliente cliente1 = criarCliente("Sol Maria", banco);
        Cliente cliente2 = criarCliente("Lua Maria", banco);

        ContaCorrente cc = criarContaCorrente(cliente1);
        ContaPoupanca poupanca = criarContaPoupanca(cliente1);

        realizarOperacoesBancarias(cc, poupanca);

        atualizarDadosCliente(cliente1, "Lua Maria");
        consultarSaldoTotal(cliente1);

        realizarTransacao(banco, cc, poupanca, 100);

        agencia.buscarContaPorId(1);
        agencia.removerConta(cc);

        agencia.adicionarConta(cc);
        agencia.adicionarConta(poupanca);

        agencia.listaDeContas();

        Cartao cartao = new Cartao("1234 5678 9012 3456", "12/25", "123", 5000, 1000);
        realizarOperacoesCartao(cartao);
    }

    private static Banco criarBanco(String nome) {
        Banco banco = new Banco();
        banco.setNome(nome);
        return banco;
    }

    private static Agencia criarAgencia(Banco banco, String endereco) {
        Agencia agencia = new Agencia(new ArrayList<>(), 1, banco, endereco);
        banco.setAgencias(List.of(agencia));
        return agencia;
    }

    private static Cliente criarCliente(String nome, Banco banco) {
        Cliente cliente = new Cliente(new ArrayList<>());
        cliente.setNome(nome);
        banco.adicionarCliente(cliente);
        return cliente;
    }

    private static ContaCorrente criarContaCorrente(Cliente cliente) {
        ContaCorrente cc = new ContaCorrente(cliente);
        cliente.adicionarConta(cc);
        return cc;
    }

    private static ContaPoupanca criarContaPoupanca(Cliente cliente) {
        ContaPoupanca poupanca = new ContaPoupanca(cliente);
        cliente.adicionarConta(poupanca);
        return poupanca;
    }

    private static void realizarOperacoesBancarias(ContaCorrente cc, ContaPoupanca poupanca) {
        cc.depositar(1000);
        cc.sacar(200);
        cc.transferir(300, poupanca);
        cc.consultarExtrato();
        poupanca.consultarExtrato();
    }

    private static void atualizarDadosCliente(Cliente cliente, String novoNome) {
        cliente.atualizarDados(novoNome);
    }

    private static void consultarSaldoTotal(Cliente cliente) {
        double saldoTotal = cliente.consultarSaldoTotal();
        System.out.println("Saldo total: " + saldoTotal);
    }

    private static void realizarTransacao(Banco banco, ContaCorrente cc, ContaPoupanca poupanca, double valor) {
        Transacao transacao = new Transacao(1, "Corrente", new Date(), cc.getId(), poupanca.getId(), valor, banco);
        transacao.executarTransacao();
        cc.consultarExtrato();
        poupanca.consultarExtrato();
        transacao.estornarTransacao();
        cc.consultarExtrato();
        poupanca.consultarExtrato();
    }

    private static void realizarOperacoesCartao(Cartao cartao) {
        cartao.realizarCompra(200);
        cartao.consultarSaldo();
        cartao.pagarFatura(300);
        cartao.consultarSaldo();
    }
}
