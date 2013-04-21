
package beans;

import dao.RedacaoJpaController;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Redacao;

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
    
    
    public RedacaoMB() {
        
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    //metodo de inserção no banco de dados
    public void inserir() {
        dao.create(redacao);
        this.setMensagem(this.redacao.getTitulo() + " foi inserido");
        redacao = new Redacao();
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
