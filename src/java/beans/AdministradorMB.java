package beans;

import dao.AdministradorJpaController;
import dao.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Administrador;

/**
 * @author Weverton ManagedBean do Administrador - projeto Corresys versão 1.0
 * data:23/04/2013
 */
@ManagedBean
@RequestScoped
public class AdministradorMB {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CORRESYS_1.0PU");
    AdministradorJpaController dao = new AdministradorJpaController(emf);
    private String mensagem = "";
    private List<Administrador> administradores = new ArrayList<Administrador>();
    private Administrador administrador = new Administrador();
    private String administradorPesquisado;

    public AdministradorMB() {

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

    public String getMensagemAlterar() {
        return mensagem;
    }

    public void setMensagemAlterar(String mensagem) {
        this.mensagem = mensagem;
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

    //metodo de inserção no banco de dados
    public void inserir() {
        try {
            dao.create(administrador);
            this.setMensagem(this.administrador.getNome() + " cadastrado(a) com sucesso!");
            administrador = new Administrador();
        } catch (Exception ex) {
            setMensagem(this.administrador.getNome() + "já existe no sistema, cadastro não realizado!");
            Logger.getLogger(AdministradorMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        pesquisar();
    }

    public void alterar() throws Exception {
        try {
            dao.edit(administrador);
            setMensagemAlterar(this.administrador.getNome() + " foi alterado(a) com sucesso!");
            administrador = new Administrador();
        } catch (NonexistentEntityException ex) {
            this.setMensagemAlterar("id não existe");
            Logger.getLogger(AdministradorMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        pesquisar();
    }

    public void excluir() {
        try {
            dao.destroy(administrador.getId());
            setMensagemExclusao(this.administrador.getNome() + " foi excluído(a) com sucesso!");
            administrador = new Administrador();
        } catch (NonexistentEntityException ex) {
            this.setMensagemExclusao("id não existe");
            Logger.getLogger(AdministradorMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        pesquisar();
    }

    public void carregar(Long id) {
        Administrador ad = dao.findAdministrador(id);
        administrador.setMatricula(ad.getMatricula());
        administrador.setNome(ad.getNome());
        administrador.setSenha(ad.getSenha());
        administrador.setEmail(ad.getEmail());
        administrador.setId(ad.getId());

        if (administrador == null) {
            administrador = new Administrador();
        }
    }

    public int pesquisar() {
        setAdministradores(dao.findAdministradorEntities());
        return administradores.size();
    }
    
    
    public void pesquisarAdministradores() {
        setAdministradores(new ArrayList<Administrador>());
        for (Administrador ad : dao.findAdministradorEntities()) {
            if ((ad.getMatricula().toLowerCase().contains(administradorPesquisado) || (ad.getNome().toLowerCase().contains(administradorPesquisado)))){
                administradores.add(ad);
                
            }
        }
        setAdministradorPesquisado("");
    }

    public List<Administrador> pesquisarAdministrador() {
        return dao.findAdministradorEntities();
    }
    
    public String getAdministradorPesquisado() {
        return administradorPesquisado;
    }

    public void setAdministradorPesquisado(String administradorPesquisado) {
        this.administradorPesquisado = administradorPesquisado;
    }

    /**
     * @param administradores the administradores to set
     */
    public void setAdministradores(List<Administrador> administradores) {
        this.administradores = administradores;
    }
}
