package br.com.IgorCoura;

public class Conta {
    private int idConta;
    private Usuario cliente;
    private int numero;
    private int agencia;
    private double saldo;

    public Conta(int idConta, Usuario cliente, int numero, int agencia) {
        this.idConta = idConta;
        this.cliente = cliente;
        this.numero = numero;
        this.agencia = agencia;
    }

    public Usuario getUsuario() {
        return cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void setUsuario(Usuario cliente) {
        this.cliente = cliente;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getIdConta() {
        return idConta;
    }

}
