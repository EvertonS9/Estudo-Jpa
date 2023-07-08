package estudo.jpa.initjpa;

import estudo.jpa.EntityManagerTest;
import estudo.jpa.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacaoComTransacaoTest extends EntityManagerTest {

    public void imperdirOperacaoComBancoDeDados(){
        Produto produto = entityManager.find(Produto.class, 1);
        entityManager.detach(produto);

        entityManager.getTransaction().begin();
        produto.setNome("Kindle Paperwhite 2ª Geração");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertEquals("Kindle", produtoVerificacao.getNome());
    }

    @Test
    public void mostrarDiferencaPersistMerge(){
        //Persist

        Produto produtoPersist = new Produto();

        //produtoPersist.setId(5);
        produtoPersist.setNome("Shun");
        produtoPersist.setDescricao("Corrente de Andrômeda!");
        produtoPersist.setPreco(new BigDecimal(13000));

        entityManager.getTransaction().begin();
        entityManager.persist(produtoPersist);
        produtoPersist.setNome("Shun de Andrômeda");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacaoPersist = entityManager.find(Produto.class, produtoPersist.getId());
        Assert.assertNotNull(produtoVerificacaoPersist);

        //Merge

        Produto produtoMerge = new Produto();

        //produtoMerge.setId(6);
        produtoMerge.setNome("Shiryu");
        produtoMerge.setDescricao("Cólera do Dragão!");
        produtoMerge.setPreco(new BigDecimal(14000));

        entityManager.getTransaction().begin();
        produtoMerge = entityManager.merge(produtoMerge);
        produtoMerge.setNome("Shiryu de Dragão");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacaoMerge = entityManager.find(Produto.class, produtoMerge.getId());
        Assert.assertNotNull(produtoVerificacaoMerge);
    }


    @Test
    public void inserirObjetoComMerge(){
        Produto produto = new Produto();

        //produto.setId(4);
        produto.setNome("Ikki");
        produto.setDescricao("Avê Fenix!");
        produto.setPreco(new BigDecimal(12000));

        entityManager.getTransaction().begin();
        Produto produtoSalvo = entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produtoSalvo.getId());
        Assert.assertNotNull(produtoVerificacao);
    }

    @Test
    public void atualizarObjetoGerenciado(){
        Produto produto = entityManager.find(Produto.class, 1);

        entityManager.getTransaction().begin();
        produto.setNome("Kindle Paperwhite 2ª Geração");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertEquals("Kindle Paperwhite 2ª Geração", produtoVerificacao.getNome());
    }
    @Test
    public void atualizarObjeto(){
        Produto produto = new Produto();

        //produto.setId(1);
        produto.setNome("Kindle Paperwhite");
        produto.setDescricao("Novo Kindle!");
        produto.setPreco(new BigDecimal(599));

        entityManager.getTransaction().begin();
        Produto produtoSalvo = entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produtoSalvo.getId());
        Assert.assertNotNull(produtoVerificacao);
        Assert.assertEquals("Kindle Paperwhite", produtoVerificacao.getNome());
    }

    @Test
    public void removerObjeto(){
        Produto produto = entityManager.find(Produto.class, 3);

        entityManager.getTransaction().begin();
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        Produto produtoVerificacao = entityManager.find(Produto.class, 3);
        Assert.assertNull(produtoVerificacao);

    }
    @Test
    public void inserirOPrimeiroObjeto(){
        Produto produto = new Produto();

        //produto.setId(2);
        produto.setNome("Cavaleiro de ouro");
        produto.setDescricao("Guardiões das doze casas");
        produto.setPreco(new BigDecimal(8001));

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);
    }

    @Test
    public void abrirEFecharATrasacao(){

        //Produto produto = new Produto();

        entityManager.getTransaction().begin();

//        entityManager.persist(produto);
//        entityManager.merge(produto);
//        entityManager.remove(produto);

        entityManager.getTransaction().commit();
    }
}
