package estudo.jpa.mapeamentoavancado;

import estudo.jpa.EntityManagerTest;
import estudo.jpa.model.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class TransientPropertyTest extends EntityManagerTest {

    @Test
    public void validateFirstName() {
        Cliente cliente = entityManager.find(Cliente.class, 2);

        Assert.assertEquals("Vitoria", cliente.getFirstName());
    }
}
