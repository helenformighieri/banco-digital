package main.java.com.banco.service;

import main.java.com.banco.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.setNome("LuaBank");

        Cliente cliente = new Cliente(new ArrayList<>());
        cliente.setNome("Sol Maria");

        ContaCorrente cc = new ContaCorrente(cliente);
        ContaPoupanca poupanca = new ContaPoupanca(cliente);

        List<Conta> contas = new ArrayList<>();
        contas.add(cc);
        contas.add(poupanca);
        cliente.setContas(contas);

        banco.setContas(contas);


        Agencia agencia = new Agencia(1, banco, "Rua de Crystal, 123", contas);

        cc.depositar(1000);
        cc.sacar(200);
        cc.transferir(300, poupanca);

        cc.consultarExtrato();
        poupanca.consultarExtrato();

        cliente.atualizarDados("Lua Maria");
        System.out.println("Nome atualizado: " + cliente.getNome());

        double saldoTotal = cliente.consultarSaldoTotal();
        System.out.println("Saldo total: " + saldoTotal);

        Transacao transacao = new Transacao(1, "Corrente", new Date(), cc.getId(), poupanca.getId(), 100, banco);
        transacao.executarTransacao();
        cc.consultarExtrato();
        poupanca.consultarExtrato();

        transacao.estornarTransacao();
        cc.consultarExtrato();
        poupanca.consultarExtrato();
    }
}