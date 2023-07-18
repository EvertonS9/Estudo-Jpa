package estudo.jpa.mapeamentobasico;

import estudo.jpa.EntityManagerTest;
import estudo.jpa.model.Cliente;
import estudo.jpa.model.EnderecoEntregaPedido;
import estudo.jpa.model.Pedido;
import estudo.jpa.model.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeamentoObjetoEmbutidoTest extends EntityManagerTest {

    @Test
    public void analisandoMapeamentoObjetoEmbutido(){
        Cliente cliente = entityManager.find(Cliente.class, 1);

        EnderecoEntregaPedido endereco = new EnderecoEntregaPedido();
        endereco.setCep("00000-00");
        endereco.setLogradouro("Rua dos testes");
        endereco.setNumero("123");
        endereco.setBairro("Centro");
        endereco.setCidade("Testelândia");
        endereco.setEstado("TEST");

        Pedido pedido = new Pedido();
        //pedido.setId(1);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(new BigDecimal(250));
        pedido.setEnderecoEntrega(endereco);
        pedido.setCliente(cliente);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerifacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerifacao);
        Assert.assertNotNull(pedidoVerifacao.getEnderecoEntrega());
        Assert.assertNotNull(pedidoVerifacao.getEnderecoEntrega().getCep());
    }
}
