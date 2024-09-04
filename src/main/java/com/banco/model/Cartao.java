package main.java.com.banco.model;

public class Cartao {
    private String numero;
    private String validade;
    private String cvv;
    private double limite;
    private double saldo;

    public Cartao(String numero, String validade, String cvv, double limite, double saldo) {
        this.numero = numero;
        this.validade = validade;
        this.cvv = cvv;
        this.limite = limite;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public String getValidade() {
        return validade;
    }

    public String getCvv() {
        return cvv;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public void realizarCompra(double valor) {
        if (valor <= saldo + limite) {
            saldo -= valor;
            System.out.println("Compra realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void pagarFatura(double valor) {
        saldo += valor;
    }

    public void consultarSaldo() {
        System.out.printf("Saldo: %.2f%n", saldo);
    }
}
