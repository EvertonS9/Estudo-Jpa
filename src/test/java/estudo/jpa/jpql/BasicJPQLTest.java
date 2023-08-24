package estudo.jpa.jpql;

import estudo.jpa.EntityManagerTest;
import estudo.jpa.model.Pedido;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;

public class BasicJPQLTest extends EntityManagerTest {

    @Test
    public void buscarPorIdentificador() {
        // entityManager.find(Pedido.class, 1)

        TypedQuery<Pedido> typedQuery = entityManager
                .createQuery("select p from Pedido p where p.id = 1", Pedido.class);

        Pedido pedido = typedQuery.getSingleResult();
        Assert.assertNotNull(pedido);

        //List<Pedido> lista = typedQuery.getResultList();
        //Assert.assertFalse(lista.isEmpty());
    }
}
