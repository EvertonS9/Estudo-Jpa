package estudo.jpa.mapeamentoavancado;

import estudo.jpa.EntityManagerTest;
import estudo.jpa.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class InheritanceTest extends EntityManagerTest {

    @Test
    public void saveClient(){
        Cliente cliente = new Cliente();
        cliente.setNome("Kushida Sakamoto");
        cliente.setSexo(SexoCliente.MASCULINO);
        cliente.setCpf("258");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao.getId());
    }

    @Test
    public void searchPayment() {
        List<Pagamento> pagamentos = entityManager
                .createQuery("select p from Pagamento p")
                .getResultList();

        Assert.assertFalse(pagamentos.isEmpty());
    }

    @Test
    public void includePaymentOrder() {
        Pedido pedido = entityManager.find(Pedido.class, 1);

        PagamentoCartao pagamentoCartao = new PagamentoCartao();
        pagamentoCartao.setPedido(pedido);
        pagamentoCartao.setStatus(StatusPagamento.PROCESSANDO);
        pagamentoCartao.setNumeroCartao("123");

        entityManager.getTransaction().begin();
        entityManager.persist(pagamentoCartao);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao.getPagamento());
    }
}
