
package teste;

import beans.CorretorMB;
import modelo.Corretor;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Monnalisa Medeiros
 */
public class manterCorretorMBTeste {
    
    public manterCorretorMBTeste() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void incluirCorretor() {
         Corretor corretor = new Corretor();
         corretor.setNome("Monnalisa");
         corretor.setMatricula("2011111111");
         corretor.setEmail("monna-mc@hotmail.com");
         corretor.setSenha("teste");
         
         CorretorMB cor = new CorretorMB();
         cor.setCorretor(corretor);
         cor.inserir();
         cor.getMensagem();
         assertEquals("Monnalisa cadastrado(a) com sucesso!", cor.getMensagem());
     }
     
     @Test
     public void excluirCorretor(){
         Corretor corretor = new Corretor();
         int id = 951;
         corretor.setId((long)id);
         corretor.setNome("Monnalisa");
         CorretorMB cor = new CorretorMB();
         cor.setCorretor(corretor);
         cor.excluir();
         cor.getMensagemExclusao();
         assertEquals("Monnalisa foi excluido(a) com sucesso!", cor.getMensagemExclusao());
     }
     
     @Test
     public void alterarCorretor() throws Exception{
         Corretor corretor = new Corretor();
         int id = 1001;
         corretor.setId((long)id);
         corretor.setNome("Monnalisa Medeiros");
         CorretorMB cor = new CorretorMB();
         cor.setCorretor(corretor);
         cor.alterar();
         assertEquals("Monnalisa Medeiros foi alterado(a) com sucesso!", cor.getMensagemAlteracao());
     }
}