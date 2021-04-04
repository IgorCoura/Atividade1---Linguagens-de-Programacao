/**
 *  @autor Igor de Brito Coura 19.00165-7
 **/
package br.com.IgorCoura;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListaContas {
    //Class responsavel por gerenciar todas as contas existentes em tempo de execução
    private static List<Conta> contas = new ArrayList<Conta>();

    public static void addConta(Conta conta){
        contas.add(conta);                      //Add conta na lista de contas;
    }

    public static Conta getConta(Function<Conta, Boolean> pre){
        Conta contaDestino = null;             //Criando contaDestino
        for(Conta c : contas){
            if(pre.apply(c)){                  //Procura a conta com a função passada como parametro
                contaDestino = c;
            }
        }
        return contaDestino;                    //Retorna a conta
    }


}
