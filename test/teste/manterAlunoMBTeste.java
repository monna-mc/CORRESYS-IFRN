/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import beans.AlunoMB;
import modelo.Aluno;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Monnalisa
 */
public class manterAlunoMBTeste {
    
    public manterAlunoMBTeste() {
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
     public void incluirAluno() {
         Aluno aluno = new Aluno();
         aluno.setNome("Monnalisa Medeiros");
         aluno.setMatricula("5111111111");
         aluno.setEmail("monna-mc@gmail.com");
         aluno.setSenha("123456");
         aluno.setCurso("BSI");
         aluno.setTurma("3");
         
         AlunoMB a = new AlunoMB();
         a.setAluno(aluno);
         a.inserir();
         a.getMensagem();
         assertEquals("Monnalisa Medeiros cadastrado(a) com sucesso!", a.getMensagem());
     }
     
     @Test
     public void excluirAluno(){
         Aluno aluno = new Aluno();
         int id = 201;
         aluno.setId((long)id);
         aluno.setNome("Monnalsia Medeiros");
         AlunoMB a = new AlunoMB();
         a.setAluno(aluno);
         a.excluir();
         a.getMensagemExclusao();
         assertEquals("Monnalisa foi excluido com sucesso!", a.getMensagemExclusao());
     }
     
     @Test
     public void alterarAluno() throws Exception{
         Aluno aluno = new Aluno();
         int id = 780;
         aluno.setId((long)id);
         aluno.setNome("Monnalisa Medeiros");
         AlunoMB a = new AlunoMB();
         a.setAluno(aluno);
         a.alterar();
         assertEquals("Monnalisa Medeiros informações alteradas com sucesso!", a.getMensagemAlteracao());
     }
}