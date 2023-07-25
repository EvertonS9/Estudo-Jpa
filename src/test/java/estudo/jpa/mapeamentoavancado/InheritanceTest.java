package estudo.jpa.mapeamentoavancado;

import estudo.jpa.EntityManagerTest;
import estudo.jpa.model.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class InheritanceTest extends EntityManagerTest {

    @Test
    public void saveClient(){
        Cliente cliente = new Cliente();
        cliente.setNome("Kushida");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao.getId());
    }
}
