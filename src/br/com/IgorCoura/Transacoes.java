/**
 *  @autor Igor de Brito Coura 19.00165-7
 **/
package br.com.IgorCoura;
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

    public static String pagamentoQRcode(String QRcode, Conta conta){
        String[] dados = QRcode.split(";");                                             // Divide os dados
        int id = Integer.parseInt(dados[0]);                                                  //transforma o id de string para inteiro
        Conta contaDestino = ListaContas.getConta( (c)->{return  c.getIdConta() == id && c.getUsuario().getNome().equals(dados[1]);}); // Busca conta de acordo com id e nome igual ao do qrCode
        if(contaDestino != null){                                                                //Caso a procura de conta não retorne nada o qrCode informado é invalido
            if(conta.sacar(Double.parseDouble(dados[2]))){                                       //Tenta retira o dinheiro da conta pagadora e caso consiga deposita na conta destino.
                contaDestino.depositar(Double.parseDouble(dados[2]));
                return "Pagamento de "+ dados[2] +" realizado com sucesso";
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
