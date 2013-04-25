//git
package beans;

import dao.AlunoJpaController;
import dao.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
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
    private String alunoPesquisado;
    
    public AlunoMB() {
        pesquisar();
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public String getMensagemExclusao() {
        return mensagem;
    }

    public void setMensagemExclusao(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public String getMensagemAlteracao() {
        return mensagem;
    }

    public void setMensagemAlteracao(String mensagem) {
        this.mensagem = mensagem;
    }
    
    //metodo de inserção no banco de dados
    public void inserir() {
        try{
            dao.create(aluno);
            this.setMensagem(this.aluno.getNome() + " cadastrado(a) com sucesso! ");
            aluno = new Aluno();
        }catch(Exception ex){
            setMensagem(this.aluno.getNome()+"já existe no sistema, cadastro não realizado!");
            Logger.getLogger(AlunoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pesquisar();
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
            setMensagemExclusao(this.aluno.getNome() + "  foi excluído(a) com sucesso!");
            aluno= new Aluno();
        } catch (NonexistentEntityException ex) {
            this.setMensagemExclusao("id não existe");
            Logger.getLogger(AlunoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void alterar() throws Exception {
        try {
            dao.edit(aluno);
            setMensagemAlteracao(this.aluno.getNome() + " foi alterado(a) com sucesso!");
            aluno = new Aluno();
        } catch (NonexistentEntityException ex) {
            this.setMensagemAlteracao("id não existe");
            Logger.getLogger(AlunoMB.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public int pesquisar() {
        alunos = dao.findAlunoEntities();
        return alunos.size();
    }
    
    
    public void pesquisarAlunos() {
        alunos = new ArrayList<Aluno>();
        for (Aluno a : dao.findAlunoEntities()) {
            if ((a.getMatricula().toLowerCase().contains(alunoPesquisado) || (a.getNome().toLowerCase().contains(alunoPesquisado)))){
                alunos.add(a);
                
            }
        }
        setAlunoPesquisado("");
    }
    
    
    
    public List<Aluno> pesquisarAluno() {
        return dao.findAlunoEntities();
    }
    
    public String getAlunoPesquisado() {
        return alunoPesquisado;
    }

    public void setAlunoPesquisado(String alunoPesquisado) {
        this.alunoPesquisado = alunoPesquisado;
    }
}
