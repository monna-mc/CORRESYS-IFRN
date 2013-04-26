//git

package beans;

import dao.RedacaoJpaController;
import dao.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Aluno;
import modelo.Corretor;
import modelo.Redacao;
import org.primefaces.model.UploadedFile;


/**
 * @author Monnalisa Christina
 * ManagedBean do Aluno - projeto Corresys versão 1.0
 * data:25/03/2013
 */
@ManagedBean
@RequestScoped
public class RedacaoMB {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CORRESYS_1.0PU");
    RedacaoJpaController dao = new RedacaoJpaController(emf);
    private String mensagem = "";
    private List<Redacao> redacoes = new ArrayList<Redacao>();
    private Redacao redacao = new Redacao();
    private UploadedFile foto;
    private String  redacaoPesquisado;
    
    
    public RedacaoMB() {
        
    }
    
    public void upload() {  
        if(getFoto() != null) {  
            FacesMessage msg = new FacesMessage(null, "Succesful" + getFoto().getFileName() + " is uploaded.");  
            FacesContext.getCurrentInstance().addMessage(null, msg);  
        }  
    }
    
    public UploadedFile getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(UploadedFile foto) {
        this.foto = foto;
    }
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public void pesquisarRedacoes() {
        redacoes = new ArrayList<Redacao>();
        for (Redacao r : dao.findRedacaoEntities()) {
            if ((r.getTitulo().toLowerCase().contains(redacaoPesquisado) || (r.getTema().toLowerCase().contains(redacaoPesquisado)))){
                redacoes.add(r);
                
            }
        }
        setRedacaoPesquisado("");
    }
    
    public String getRedacaoPesquisado() {
        return redacaoPesquisado;
    }

    public void setRedacaoPesquisado(String redPesquisado) {
        this.redacaoPesquisado = redPesquisado;
    }
    
    //metodo de inserção no banco de dados
    public void inserir() {
        try{
            dao.create(redacao);
            this.setMensagem(this.redacao.getTitulo() + " cadastrado(a) com sucesso! ");
            redacao = new Redacao();
        }catch(Exception ex){
            setMensagem(this.redacao.getTitulo()+"já existe no sistema, cadastro não realizado!");
            Logger.getLogger(RedacaoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pesquisar();
    }
    
    public void carregar(Long id) {
        Redacao r = dao.findRedacao(id);
        redacao.setTema(r.getTema());
        redacao.setTitulo(r.getTitulo());
        redacao.setNota(r.getNota());
        redacao.setStatus(r.getStatus());
        redacao.setMatriculaCorretor(r.getMatriculaCorretor());
        redacao.setMatriculaAluno(r.getMatriculaAluno());
        //redacao.setImagem(r.getImagem());

        if (redacao == null) {
            redacao = new Redacao();
        }
    }
    
    public int pesquisar() {
        redacoes = dao.findRedacaoEntities();
        return redacoes.size();
       
    }
    
    public String getMensagemExclusao() {
        return mensagem;
    }

    public void setMensagemExclusao(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public void excluir() {
        try {
            dao.destroy(redacao.getId());
            setMensagemExclusao(this.redacao.getTitulo() + "  foi excluído(a) com sucesso!");
            redacao = new Redacao();
        } catch (NonexistentEntityException ex) {
            this.setMensagemExclusao("id não existe");
            Logger.getLogger(RedacaoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void alterar() throws Exception {
        try {
            dao.edit(redacao);
            setMensagemAlteracao(this.redacao.getTitulo() + " foi alterado(a) com sucesso!");
            redacao = new Redacao();
        } catch (NonexistentEntityException ex) {
            this.setMensagemAlteracao("id não existe");
            Logger.getLogger(RedacaoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public String getMensagemAlteracao() {
        return mensagem;
    }

    public void setMensagemAlteracao(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public Redacao getRedacao() {
        return redacao;
    }

    public void setRedacao(Redacao redacao) {
        this.redacao = redacao;
    }

    public List<Redacao> getRedList() {
        return redacoes;
    }
    
    
}