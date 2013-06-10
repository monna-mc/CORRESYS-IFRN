/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import auxiliar.EMF;
import auxiliar.FacesUtil;
import dao.AdministradorJpaController;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Administrador;

/**
 *
 * @author Monnalisa Medeiros
 */
@ManagedBean
@SessionScoped
public class LoginAdmMB {

    private Administrador administrador = new Administrador();
    
    private String matricula ="";
    
    private String senha="";
    
    private AdministradorJpaController dao = new AdministradorJpaController(EMF.getEntityManagerFactory());
    
    private boolean logado = false;
    
    private String mensagem ;
    
    
    public LoginAdmMB() {
    }
    
    public boolean validarLogin(){
        Administrador adm = dao.findAdm(matricula , senha);
        if (adm != null){
            administrador = adm;
            AdministradorMB umb = FacesUtil.getAdministradorMB();
            umb.setAdministrador(administrador);
            
            return true;
        } else {
            return false;
        }
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * @return the logado
     */
    public boolean isLogado() {
        return logado;
    }
    
    /**
     * setLogado como verdadeiro. 
     */
    private void setLogado(){
        logado = true;
    }
    
    /**
     * setDeslogado como falso.
     */
    private void setDeslogado(){
        logado = false;
    }
    
    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    /**
     * 
     * @return a página inicial da sessao do administrador.
     */
    public String logar(){
       boolean aux = validarLogin(); 
        if (aux== true){
            return "sucesso";
        } else {
            FacesUtil.adicionarMensagem("formEntrarAdm", "Matrícula e senha não conferem !");
            return null;
        }
    }
    
    /**
     * 
     * @return a página inicial.
     */
    public String deslogar(){
        setDeslogado();
        administrador = new Administrador();
        matricula = null;        
        senha = null;
        return "/homeCorresys.xhtml";
    }
    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}