
package beans;

import dao.CorretorJpaController;
import dao.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Corretor;

/**
 * @author Monnalisa Christina
 * ManagedBean do Corretor - projeto Corresys versão 1.0
 * data:25/03/2013
 */
@ManagedBean
@RequestScoped
public class CorretorMB {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CORRESYS_1.0PU");
    CorretorJpaController dao = new CorretorJpaController(emf);
    private String mensagem = "";
    private List<Corretor> corretores = new ArrayList<Corretor>();
    private Corretor corretor = new Corretor();
    
    
    public CorretorMB() {
        
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    //metodo de inserção no banco de dados
    public void inserir() {
        dao.create(corretor);
        this.setMensagem(this.corretor.getNome() + " foi inserido");
        corretor = new Corretor();
    }
    
    public void alterar() throws Exception {
        try {
            dao.edit(corretor);
            setMensagem(this.corretor.getNome() + " foi alterado");
            corretor = new Corretor();
        } catch (NonexistentEntityException ex) {
            this.setMensagem("id não existe");
            Logger.getLogger(CorretorMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir() {
        try {
            dao.destroy(corretor.getId());
            setMensagem(this.corretor.getNome() + " foi excluido");
            corretor = new Corretor();
        } catch (NonexistentEntityException ex) {
            this.setMensagem("id não existe");
            Logger.getLogger(CorretorMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int pesquisar() {
        corretores = dao.findCorretorEntities();
        return corretores.size();
    }

    
    public void carregar(Long id) {
        Corretor c = dao.findCorretor(id);
        corretor.setMatricula(c.getMatricula());
        corretor.setNome(c.getNome());
        corretor.setSenha(c.getSenha());
        corretor.setEmail(c.getEmail());
        corretor.setId(c.getId());

        if (corretor == null) {
            corretor = new Corretor();
        }
    }
    
    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public List<Corretor> getCorrList() {
        return corretores;
    }
}
