
package beans;

import auxiliar.EMF;
import auxiliar.FacesUtil;
import dao.CorretorJpaController;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Corretor;

/**
 *
 * @author Monnalisa Medeiros
 */
@ManagedBean
@SessionScoped
public class LoginCorretorMB {

    private Corretor corretor = new Corretor();
    
    private String matricula ="";
    
    private String senha="";
    
    private CorretorJpaController dao = new CorretorJpaController(EMF.getEntityManagerFactory());
    
    private boolean logado = false;
    
    private String mensagem;
    
    
    public LoginCorretorMB() {
    }
    
    public boolean validarLogin(){
        Corretor c = dao.findCorretor(matricula , senha);
        if (c != null){
            corretor = c;
            CorretorMB umb = FacesUtil.getCorretorMB();
            umb.setCorretor(corretor);
            
            getCorretor().setMatricula(null);
            getCorretor().setSenha(null);
            
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
    
    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
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
     * @return a página inicial da sessao do Corretor.
     */
    public String logar(){
       boolean aux = validarLogin(); 
        if (aux== true){         
            return "/corretor.xhtml";
        } else {
            FacesUtil.adicionarMensagem("formEntrarCor", "Matrícula e senha não conferem !");
            return null;
        }
    }
    
    /**
     * 
     * @return a página inicial.
     */
    public String deslogar(){
        setDeslogado();
        corretor = new Corretor();
        matricula = "";        
        senha = "";
        return "/homeCorretor.xhtml";
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