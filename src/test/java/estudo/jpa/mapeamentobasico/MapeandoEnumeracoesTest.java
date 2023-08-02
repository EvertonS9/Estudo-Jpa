package estudo.jpa.mapeamentobasico;

import estudo.jpa.EntityManagerTest;
import estudo.jpa.model.Cliente;
import estudo.jpa.model.SexoCliente;
import org.junit.Assert;
import org.junit.Test;

public class MapeandoEnumeracoesTest extends EntityManagerTest {

    @Test
    public void testarEnum(){
        Cliente cliente = new Cliente();
       // cliente.setId(4);
        cliente.setNome("José Mineiro");
        cliente.setSexo(SexoCliente.MASCULINO);
        cliente.setCpf("158");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao);
    }
}
