package estudo.jpa.mapeamentoavancado;

import estudo.jpa.EntityManagerTest;
import estudo.jpa.model.Cliente;
import estudo.jpa.model.SexoCliente;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class SecondaryTableTest extends EntityManagerTest {

    @Test
    public void saveClient(){
        Cliente cliente = new Cliente();
        cliente.setNome("Mr.Coca-cola");
        cliente.setCpf("159");
        cliente.setSexo(SexoCliente.MASCULINO);
        cliente.setDataNascimento(LocalDate.of(1996,1,1));

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao.getSexo());
    }
}
