package br.com.IgorCoura;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Conta> contas = new ArrayList<Conta>();
        Usuario u1 = new Usuario("Jose","123","498530","jose@email.com");
        Usuario u2 = new Usuario("Maria","789","456789","maria@email.com");

        Conta c1 = new Conta(u1, 1, 1);
        Conta c2 = new Conta(u2, 1, 2);
        contas.add(c1);
        contas.add(c2);
        c1.depositar(5000);
        c2.depositar(2000);
        System.out.println("c1: "+c1.getSaldo());
        System.out.println("c2: "+c2.getSaldo());
        String qRcode= Transacoes.gerarQRcode(c1, 500);
        System.out.println("Qr: " + qRcode);
        c2.pagamentoQRcode(qRcode, contas);
        System.out.println("c1: "+c1.getSaldo());
        System.out.println("c2: "+c2.getSaldo());

    }
}
