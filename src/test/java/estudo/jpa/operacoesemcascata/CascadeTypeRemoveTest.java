package estudo.jpa.operacoesemcascata;

import estudo.jpa.EntityManagerTest;
import estudo.jpa.model.ItemPedido;
import estudo.jpa.model.ItemPedidoId;
import estudo.jpa.model.Pedido;
import org.junit.Assert;
import org.junit.Test;

public class CascadeTypeRemoveTest extends EntityManagerTest {

    //@Test
    public void removerPedidoEItens() {
        Pedido pedido = entityManager.find(Pedido.class, 1);

        entityManager.getTransaction().begin();
        entityManager.remove(pedido); // Necessário CascadeType.REMOVE no atributo "itens".
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNull(pedidoVerificacao);
    }

    //@Test
    public void removerItemPedidoEPedido() {
        ItemPedido itemPedido = entityManager.find(
                ItemPedido.class, new ItemPedidoId(1, 1));

        entityManager.getTransaction().begin();
        entityManager.remove(itemPedido); // Necessário CascadeType.REMOVE no atributo "pedido".
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, itemPedido.getPedido().getId());
        Assert.assertNull(pedidoVerificacao);
    }
}
