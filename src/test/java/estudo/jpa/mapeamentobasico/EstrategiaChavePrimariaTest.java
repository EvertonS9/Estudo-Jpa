package estudo.jpa.mapeamentobasico;

import estudo.jpa.EntityManagerTest;
import estudo.jpa.model.*;
import org.junit.Assert;
import org.junit.Test;

public class EstrategiaChavePrimariaTest extends EntityManagerTest {

    @Test
    public void testarEstrategiaAutoEmCategoria(){
        Categoria categoria = new Categoria();
        categoria.setNome("Eletrônicos");

        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categoriaVerificacao = entityManager.find(Categoria.class, categoria.getId());
        Assert.assertNotNull(categoriaVerificacao);
    }
    @Test
    public void testarEstrategiaSequenceEmCliente(){
        Cliente cliente = new Cliente();
        cliente.setNome("Jasmin");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao);
    }

    @Test
    public void testarEstrategiaTableEmEstoque(){
        Estoque estoque = new Estoque();
        estoque.setQuatidade(10);

        entityManager.getTransaction().begin();
        entityManager.persist(estoque);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Estoque estoqueVerificacao = entityManager.find(Estoque.class, estoque.getId());
        Assert.assertNotNull(estoqueVerificacao);
    }

    @Test
    public void testarEstrategiaIdentityEmPedido(){
        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao);
    }

}
