package br.com.IgorCoura;

public class Transacoes {
    private static int getRandomNumberInRanger(int min, int max){
        Random r = new Random();
        return r.nextInt((max-min) +1) + min;
    }

    public static string gerarQRcode(Conta conta, double valor){
        return conta.getIdConta() +";"+ conta.getUsuario().getNome() + ";"+ valor.toString() +";"+ getRandomNumberInRanger(1000, 9999).toString();
    }


}
