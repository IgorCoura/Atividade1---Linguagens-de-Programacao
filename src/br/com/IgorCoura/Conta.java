/**
 *  @autor Igor de Brito Coura 19.00165-7
 **/
package br.com.IgorCoura;

import java.util.List;

public class Conta {
    private static int nextId = 0;
    private int idConta;
    private Usuario cliente;
    private int numero;
    private int agencia;
    private double saldo;

    public Conta(Usuario cliente, int numero, int agencia) {
        this.cliente = cliente;
        this.numero = numero;
        this.agencia = agencia;
        idConta = nextId;
        nextId++;
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

    public void depositar(double valor){
        saldo += valor;
    }

    public boolean sacar(double valor){
        if(saldo >= valor){
            saldo -= valor;
            return true;
        }
        else {
            return false;
        }
    }



}
