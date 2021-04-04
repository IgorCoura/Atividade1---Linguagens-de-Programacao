/**
 *  @autor Igor de Brito Coura 19.00165-7
**/

package br.com.IgorCoura;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Criando Usuarios
        Usuario u1 = new Usuario("Jose","123","498530","jose@email.com");
        Usuario u2 = new Usuario("Maria","789","456789","maria@email.com");
        Usuario u3 = new Usuario("Mendonsa","555","1027486","mendonsa@email.com");

        //Criando Contas
        Conta c1 = new Conta(u1, 1, 1);
        Conta c2 = new Conta(u2, 1, 2);
        Conta c3 = new Conta(u3, 2, 3);

        //Adicionando contas a lista
        ListaContas.addConta(c1);
        ListaContas.addConta(c2);
        ListaContas.addConta(c3);

        //Depositando
        c1.depositar(1000);
        c2.depositar(250);
        c3.depositar(3000);


        //Check salddo
        System.out.println(c1.getUsuario().getNome() +": "+c1.getSaldo());
        System.out.println(c2.getUsuario().getNome()+": "+c2.getSaldo());
        System.out.println(c3.getUsuario().getNome() +": "+c3.getSaldo());

        //Teste 1 - Pagamento valido
        System.out.println("\nTeste 1\n");
        //Criando QRcode
        String qrJose = Transacoes.gerarQRcode(c1, 250);
        System.out.println("QrJose: " + qrJose);

        //Realizando pagamentos valido pelo qrCode
        String respMaria = Transacoes.pagamentoQRcode(qrJose, c2);
        String respMendonsa = Transacoes.pagamentoQRcode(qrJose, c3);
        System.out.println("Resp Maria: " + respMaria);
        System.out.println("Resp Mendonsa: " +respMendonsa);

        //Check saldo
        System.out.println(c1.getUsuario().getNome() +": "+c1.getSaldo());
        System.out.println(c2.getUsuario().getNome()+": "+c2.getSaldo());
        System.out.println(c3.getUsuario().getNome() +": "+c3.getSaldo());

        //Teste 2 - Pagamento valido
        System.out.println("\nTeste 2\n");
        //Criando QRcode
        String qrMaria = Transacoes.gerarQRcode(c2, 1000);
        System.out.println("QrMaria: "+ qrMaria);

        //Realizando pagamento valido pelo qrCode
        respMendonsa = Transacoes.pagamentoQRcode(qrMaria, c3);
        System.out.println("Resp Mendonsa: " +respMendonsa);

        //Check salddo
        System.out.println(c1.getUsuario().getNome() +": "+c1.getSaldo());
        System.out.println(c2.getUsuario().getNome()+": "+c2.getSaldo());
        System.out.println(c3.getUsuario().getNome() +": "+c3.getSaldo());

        //Teste 3 - Saldo insuficiente
        System.out.println("\nTeste 3\n");
        //Criando QRcode
        String qrMaria1 = Transacoes.gerarQRcode(c2, 5000);
        System.out.println("QrMaria: "+ qrMaria1);

        //Realizando pagamento valido pelo qrCode
        respMendonsa = Transacoes.pagamentoQRcode(qrMaria1, c3);
        System.out.println("Resp Mendonsa: " +respMendonsa);

        //Check salddo
        System.out.println(c1.getUsuario().getNome() +": "+c1.getSaldo());
        System.out.println(c2.getUsuario().getNome()+": "+c2.getSaldo());
        System.out.println(c3.getUsuario().getNome() +": "+c3.getSaldo());

        //Teste 4 - qrCOde invalido - Id invalido
        System.out.println("\nTeste 4\n");
        //Criando QRcode
        String qrMaria2 = Transacoes.gerarQRcode(c2, 5000);
        qrMaria2 = "2" + qrMaria2; //Alterando o ID
        System.out.println("QrMaria: "+ qrMaria2);

        //Realizando pagamento valido pelo qrCode
        respMendonsa = Transacoes.pagamentoQRcode(qrMaria2, c3);
        System.out.println("Resp Mendonsa: " +respMendonsa);

        //Check salddo
        System.out.println(c1.getUsuario().getNome() +": "+c1.getSaldo());
        System.out.println(c2.getUsuario().getNome()+": "+c2.getSaldo());
        System.out.println(c3.getUsuario().getNome() +": "+c3.getSaldo());

        //Teste 5 - qrCOde invalido - Nome invalido
        System.out.println("\nTeste 5\n");
        //Criando QRcode
        String qrMaria3 = Transacoes.gerarQRcode(c2, 5000);
        qrMaria3 = qrMaria3.replace("a","b"); //Alterando o nome de usuario
        System.out.println("QrMaria: "+ qrMaria3);

        //Realizando pagamento valido pelo qrCode
        respMendonsa = Transacoes.pagamentoQRcode(qrMaria3, c3);
        System.out.println("Resp Mendonsa: " +respMendonsa);

        //Check salddo
        System.out.println(c1.getUsuario().getNome() +": "+c1.getSaldo());
        System.out.println(c2.getUsuario().getNome()+": "+c2.getSaldo());
        System.out.println(c3.getUsuario().getNome() +": "+c3.getSaldo());


    }
}
