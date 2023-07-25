package estudo.jpa.mapeamentoavancado;

import estudo.jpa.EntityManagerTest;
import estudo.jpa.model.NotaFiscal;
import estudo.jpa.model.Pedido;
import estudo.jpa.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class SavingFilesTest extends EntityManagerTest {

    @Test
    public void savePhotoProduct(){
        entityManager.getTransaction().begin();
        Produto produto = entityManager.find(Produto.class, 3);
        produto.setFoto(savePhoto());
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, 1);
        Assert.assertNotNull(produtoVerificacao.getFoto());
        Assert.assertTrue(produtoVerificacao.getFoto().length > 0);
    }

    @Test
    public void saveXmlNote() {
        Pedido pedido = entityManager.find(Pedido.class, 1);

        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setPedido(pedido);
        notaFiscal.setDataEmissao(new Date());
        notaFiscal.setXml(loadXmlNote());

        entityManager.getTransaction().begin();
        entityManager.persist(notaFiscal);
        entityManager.getTransaction().commit();

        entityManager.clear();

        NotaFiscal notaFiscalVerificacao = entityManager.find(NotaFiscal.class, notaFiscal.getId());
        Assert.assertNotNull(notaFiscalVerificacao.getXml());
        Assert.assertTrue(notaFiscalVerificacao.getXml().length > 0);


        try {
            OutputStream out = new FileOutputStream(
                    Files.createFile(Paths.get(
                            System.getProperty("user.home") + "/xml.xml")).toFile());
            out.write(notaFiscalVerificacao.getXml());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static byte[] savePhoto(){
        return loadFile("/hyoga.png");
    }

    private static byte[] loadXmlNote(){
        return loadFile("/nota-fiscal.xml");
    }

    private static byte[] loadFile(String nome) {
        try {
            return SavingFilesTest.class.getResourceAsStream(
                    nome).readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
