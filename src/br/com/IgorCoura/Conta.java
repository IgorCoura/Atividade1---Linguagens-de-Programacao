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

    public String pagamentoQRcode(String QRcode, List<Conta> contas){
        String[] dados = QRcode.split(";");
        int id = Integer.parseInt(dados[0]);
        Conta contaDestino = null;
        for(Conta conta : contas){
            if(conta.getIdConta() == id){
                contaDestino = conta;
            }
        }
        if(contaDestino != null){
            if(sacar(Double.parseDouble(dados[2]))){
                contaDestino.depositar(Double.parseDouble(dados[2]));
                return "Pagamento realizado com sucesso";
            }
            else {
                return "Saldo insuficiente";
            }
        }
        else {
            return "Conta inexistente";
        }
    }

}
