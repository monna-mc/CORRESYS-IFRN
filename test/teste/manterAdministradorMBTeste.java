/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import beans.AdministradorMB;
import modelo.Administrador;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Weverton
 */
public class manterAdministradorMBTeste {
    
    public manterAdministradorMBTeste() {
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
     public void incluirAdministrador() {
         Administrador administrador = new Administrador();
         administrador.setNome("weverton");
         administrador.setMatricula("1111111111");
         administrador.setEmail("weverton-gigante@hotmail.com");
         administrador.setSenha("123456");
         
         AdministradorMB admin = new AdministradorMB();
         admin.setAdministrador(administrador);
         admin.inserir();
         admin.getMensagem();
         assertEquals("weverton cadastrado(a) com sucesso!", admin.getMensagem());
     }
     
     @Test
     public void excluirAdministrador(){
         Administrador administrador = new Administrador();
         int id = 201;
         administrador.setId((long)id);
         administrador.setNome("weverton");
         AdministradorMB admin = new AdministradorMB();
         admin.setAdministrador(administrador);
         admin.excluir();
         admin.getMensagemExclusao();
         assertEquals("weverton foi excluido com sucesso!", admin.getMensagemExclusao());
     }
     
     @Test
     public void alterarAdministrador() throws Exception{
         Administrador administrador = new Administrador();
         int id = 1001;
         administrador.setId((long)id);
         administrador.setNome("weverton soares de sousa");
         AdministradorMB admin = new AdministradorMB();
         admin.setAdministrador(administrador);
         admin.alterar();
         assertEquals("weverton soares de sousa informações alteradas com sucesso!", admin.getMensagemAlterar());
     }
}