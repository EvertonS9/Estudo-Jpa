package estudo.jpa.jpql;

import estudo.jpa.EntityManagerTest;
import estudo.jpa.model.Pedido;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class OperadoresLogicosTest extends EntityManagerTest {

    @Test
    public void usarOperadores() {
        String jpql = "select p from Pedido p " +
                " where (p.status = 'AGUARDANDO' or p.status = 'PAGO') and p.total > 100";

        TypedQuery<Pedido> typedQuery = entityManager.createQuery(jpql, Pedido.class);

        List<Pedido> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());
    }
}
