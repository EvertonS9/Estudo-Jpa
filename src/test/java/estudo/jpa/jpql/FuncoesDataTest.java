package estudo.jpa.jpql;

import estudo.jpa.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class FuncoesDataTest extends EntityManagerTest {

    @Test
    public void aplicarFuncaoData(){
        //current_date = data atual
        //current_time = hora minuto e segundo atual
        //current_timestamp = ambos data e hora atuais
        //year = ano / month = mês / day = dia
        //hour = hora / minute = minuto / second = segundo

        String jpql = "select hour(p.dataCriacao), minute(p.dataCriacao), second(p.dataCriacao) from Pedido p";

        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);

        List<Object[]> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

        lista.forEach(arr -> System.out.println(arr[0] + " | " + arr[1] + " | " + arr[2]));
    }
}
