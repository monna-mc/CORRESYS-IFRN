
package beans;

import dao.AlunoJpaController;
import dao.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Aluno;

/**
 * @author Monnalisa Christina
 * ManagedBean do Aluno - projeto Corresys versão 1.0
 * data:25/03/2013
 */
@ManagedBean
@RequestScoped
public class AlunoMB {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CORRESYS_1.0PU");
    AlunoJpaController dao = new AlunoJpaController(emf);
    private String mensagem = "";
    private List<Aluno> alunos = new ArrayList<Aluno>();
    private Aluno aluno = new Aluno();
    
    
    public AlunoMB() {
        
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    //metodo de inserção no banco de dados
    public void inserir() {
        dao.create(aluno);
        this.setMensagem(this.aluno.getNome() + " cadastrado(a) com sucesso!");
        aluno = new Aluno();
    }
    
      public  Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Aluno> getAluList() {
        return alunos;
    }
    
    public void excluir() {
        try {
            dao.destroy(aluno.getId());
            setMensagem(this.aluno.getNome() + " foi excluido");
            aluno= new Aluno();
        } catch (NonexistentEntityException ex) {
            this.setMensagem("id não existe");
            Logger.getLogger(AlunoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int pesquisar() {
        alunos = dao.findAlunoEntities();
        return alunos.size();
    }

     public void alterar() throws Exception {
        try {
            dao.edit(aluno);
            setMensagem(this.aluno.getNome() + " foi alterado");
            aluno = new Aluno();
        } catch (NonexistentEntityException ex) {
            this.setMensagem("id não existe");
            Logger.getLogger(CorretorMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void carregar(Long id) {
        Aluno a = dao.findAluno(id);
        aluno.setMatricula(a.getMatricula());
        aluno.setNome(a.getNome());
        aluno.setSenha(a.getSenha());
        aluno.setEmail(a.getEmail());
        aluno.setCurso(a.getCurso());
        aluno.setTurma(a.getTurma());
        aluno.setId(a.getId());

        if (aluno == null) {
            aluno = new Aluno();
        }
    }
}
