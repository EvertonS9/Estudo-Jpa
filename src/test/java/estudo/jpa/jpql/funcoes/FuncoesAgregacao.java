package estudo.jpa.jpql.funcoes;

import estudo.jpa.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class FuncoesAgregacao extends EntityManagerTest {

    @Test
    public void aplicarFuncaoAgregacao() {
        // avg, count, min, max, sum

        //sum retorna a soma de todos os registros
        //retorna o mesmo tipo da propriedade (bigDecimal)

        String jpql = "select sum(p.total) from Pedido p";

        TypedQuery<Number> typedQuery = entityManager.createQuery(jpql, Number.class);

        List<Number> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

        lista.forEach(obj -> System.out.println(obj));
    }
    @Test
    public void avgAgregacao(){
        //media dos registros
        //retorna tipo double

        String jpql = "select avg(p.total) from Pedido p";

        TypedQuery<Number> typedQuery = entityManager.createQuery(jpql, Number.class);

        List<Number> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

        lista.forEach(obj -> System.out.println(obj));
    }
    @Test
    public void countAgregacao(){
        //conta a quantidade de registros retornados
        //retorna tipo long

        String jpql = "select count(p.dataCriacao) from Pedido p";

        TypedQuery<Number> typedQuery = entityManager.createQuery(jpql, Number.class);

        List<Number> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

        lista.forEach(obj -> System.out.println(obj));
    }
    @Test
    public void minAgregacao(){
        //Retorna o valor minimo
        //retorna o mesmo tipo da propriedade (bigDecimal)

        String jpql = "select min(p.total) from Pedido p";

        TypedQuery<Number> typedQuery = entityManager.createQuery(jpql, Number.class);

        List<Number> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

        lista.forEach(obj -> System.out.println(obj));
    }
    @Test
    public void maxAgregacao(){
        //retorna o valor maximo
        //retorna o mesmo tipo da propriedade (bigDecimal)

        String jpql = "select max(p.total) from Pedido p";

        TypedQuery<Number> typedQuery = entityManager.createQuery(jpql, Number.class);

        List<Number> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

        lista.forEach(obj -> System.out.println(obj));
    }
}
