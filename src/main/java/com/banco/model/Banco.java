package main.java.com.banco.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Cliente> clientes;
    private List<Conta> contas;
    private List<Agencia> agencias;

    public Banco() {
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
        this.agencias = new ArrayList<>();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void setAgencias(List<Agencia> agencias) {
        this.agencias = agencias;
    }

    public Conta buscarContaPorId(int contaOrigemId) {
        return null;
    }
}
