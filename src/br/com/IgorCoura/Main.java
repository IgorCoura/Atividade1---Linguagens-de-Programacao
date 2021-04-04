/**
 *  @autor Igor de Brito Coura 19.00165-7
**/

package br.com.IgorCoura;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Conta> contas = new ArrayList<Conta>();

        //Criando Usuarios
        Usuario u1 = new Usuario("Jose","123","498530","jose@email.com");
        Usuario u2 = new Usuario("Maria","789","456789","maria@email.com");
        Usuario u3 = new Usuario("Mendonsa","555","1027486","mendonsa@email.com");

        //Criando Contas
        Conta c1 = new Conta(u1, 1, 1);
        Conta c2 = new Conta(u2, 1, 2);
        Conta c3 = new Conta(u3, 2, 3);

        //Adicionando contas a lista
        contas.add(c1);
        contas.add(c2);
        contas.add(c3);

        //Depositando
        c1.depositar(1000);
        c2.depositar(250);
        c3.depositar(3000);

        //Check salddo
        System.out.println(c1.getUsuario().getNome() +": "+c1.getSaldo());
        System.out.println(c2.getUsuario().getNome()+": "+c2.getSaldo());
        System.out.println(c3.getUsuario().getNome() +": "+c3.getSaldo());

        //Criando QRcode
        String qrJose = Transacoes.gerarQRcode(c1, 250);
        System.out.println("QrJose: " + qrJose);

        //Realizando pagamentos pelo qrCode
        String respMaria = Transacoes.pagamentoQRcode(qrJose, c2, contas);
        String respMendonsa = Transacoes.pagamentoQRcode(qrJose, c3, contas);
        System.out.println("Resp Maria: " + respMaria);
        System.out.println("Resp Mendonsa: " +respMendonsa);

        //Check saldo
        System.out.println(c1.getUsuario().getNome() +": "+c1.getSaldo());
        System.out.println(c2.getUsuario().getNome()+": "+c2.getSaldo());
        System.out.println(c3.getUsuario().getNome() +": "+c3.getSaldo());

        //Criando QRcode
        String qrMaria = Transacoes.gerarQRcode(c2, 1000);
        System.out.println("QrMaria: "+ qrMaria);

        //Realizando pagamento pelo qrCode
        respMendonsa = Transacoes.pagamentoQRcode(qrMaria, c3, contas);
        System.out.println("Resp Mendonsa: " +respMendonsa);

        //Check salddo
        System.out.println(c1.getUsuario().getNome() +": "+c1.getSaldo());
        System.out.println(c2.getUsuario().getNome()+": "+c2.getSaldo());
        System.out.println(c3.getUsuario().getNome() +": "+c3.getSaldo());


    }
}
