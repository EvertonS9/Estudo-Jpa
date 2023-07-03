package estudo.jpa.initjpa;

import estudo.jpa.EntityManagerTest;
import estudo.jpa.model.Cliente;
import estudo.jpa.model.Produto;
import org.junit.Assert;
import org.junit.Test;

public class PrimeiroCrudTest extends EntityManagerTest {

    @Test
    public void inserirRegistro(){
        Cliente cliente = new Cliente();

        cliente.setId(3);
        cliente.setNome("Xavier");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao);
    }

    @Test
    public void buscarPorIdentificador(){
        Cliente cliente = entityManager.getReference(Cliente.class, 1);

        Assert.assertNotNull(cliente);
        Assert.assertEquals("João", cliente.getNome());
    }

    @Test
    public void atualizarRegistro(){
        Cliente cliente = new Cliente();

        cliente.setId(2);
        cliente.setNome("Joaquina");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificação = entityManager.find(Cliente.class, 2);
        Assert.assertEquals("Joaquina", clienteVerificação.getNome());
    }

    @Test
    public void removerRegistro(){
        Cliente cliente = entityManager.find(Cliente.class, 2);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

        Produto clienteVerificacao = entityManager.find(Produto.class, 2);
        Assert.assertNull(clienteVerificacao);
    }
}
