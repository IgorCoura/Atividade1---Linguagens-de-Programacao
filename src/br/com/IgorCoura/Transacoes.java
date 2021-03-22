package br.com.IgorCoura;

import javax.swing.*;
import java.util.List;
import java.util.Random;

public class Transacoes {

    private static int getRandomNumberInRanger(int min, int max){
        Random r = new Random();
        return r.nextInt((max-min) +1) + min;
    }

    public static String gerarQRcode(Conta conta, double valor){
        return conta.getIdConta() +";"+ conta.getUsuario().getNome() + ";"+ valor+";"+ getRandomNumberInRanger(1000, 9999);
    }


}
