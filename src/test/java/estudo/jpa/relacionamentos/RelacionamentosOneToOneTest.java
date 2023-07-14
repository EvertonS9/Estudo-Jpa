package estudo.jpa.relacionamentos;

import estudo.jpa.EntityManagerTest;
import estudo.jpa.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

public class RelacionamentosOneToOneTest extends EntityManagerTest {

    @Test
    public void VerificarRelacionamento(){
        Pedido pedido = entityManager.find(Pedido.class, 1);

        PagamentoCartao pagamentoCartao = new PagamentoCartao();
        pagamentoCartao.setNumero("154");
        pagamentoCartao.setStatus(StatusPagamento.PROCESSANDO);
        pagamentoCartao.setPedido(pedido);

        entityManager.getTransaction().begin();
        entityManager.persist(pagamentoCartao);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerficacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerficacao.getPagamento());
    }
    @Test
    public void VerificarRelacionamentoNotaFiscal(){
        Pedido pedido = entityManager.find(Pedido.class, 1);

        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setXml("CAV");
        notaFiscal.setDataEmissao(new Date());
        notaFiscal.setPedido(pedido);

        entityManager.getTransaction().begin();
        entityManager.persist(notaFiscal);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerficacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerficacao.getNotaFiscal());
    }
}
