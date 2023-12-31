package estudo.jpa.mapeamentoavancado;

import estudo.jpa.EntityManagerTest;
import estudo.jpa.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class KeyCompositeTest extends EntityManagerTest {
    @Test
    public void SaveItem(){
        entityManager.getTransaction().begin();

        Cliente cliente = entityManager.find(Cliente.class, 1);
        Produto produto = entityManager.find(Produto.class, 1);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(produto.getPreco());

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setId(new ItemPedidoId());
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);
        itemPedido.setPrecoProduto(produto.getPreco());
        itemPedido.setQuantidade(1);

        entityManager.persist(pedido);
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao);
        Assert.assertFalse(pedidoVerificacao.getItens().isEmpty());
    }

    @Test
    public void searchItem(){
        ItemPedido itemPedido = entityManager.find(
                ItemPedido.class, new ItemPedidoId(1 ,1));
        Assert.assertNotNull(itemPedido);
    }
}
