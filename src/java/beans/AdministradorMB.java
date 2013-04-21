
package beans;

import dao.AdministradorJpaController;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Administrador; 
import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext; 


/**
 * @author Monnalisa Christina
 * ManagedBean do Administrador - projeto Corresys versão 1.0
 * data:25/03/2013
 */
@ManagedBean
@RequestScoped
public class AdministradorMB {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CORRESYS_1.0PU");
    AdministradorJpaController dao = new AdministradorJpaController(emf);
    private String mensagem = "";
    private List<Administrador> administradores = new ArrayList<Administrador>();
    private Administrador administrador = new Administrador();

    
    public AdministradorMB() {
        
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    //metodo de inserção no banco de dados
    public void inserir() {
        dao.create(administrador);
        this.setMensagem(this.administrador.getNome() + " foi inserido");
        administrador = new Administrador();
    }
    
     public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public List<Administrador> getAdmList() {
        return administradores;
    }
}
