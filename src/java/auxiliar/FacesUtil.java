/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliar;


import beans.AdministradorMB;
import beans.AlunoMB;
import beans.CorretorMB;
import beans.LoginAdmMB;
import beans.LoginAlunoMB;
import beans.LoginCorretorMB;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author guest-nFhnhz
 */
public class FacesUtil {
    
    /**
     * Pega a instância atual do AdministradorMB.
     * @return o AdmiistradorMB da sessão. 
     */
    public static AdministradorMB getAdministradorMB(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application app = facesContext.getApplication();
        AdministradorMB administradorMB = (AdministradorMB) app.evaluateExpressionGet(facesContext, "#{administradorMB}",AdministradorMB.class);
        return administradorMB;
    }
    
    /**
     * Pega a instância atual do LoginAdmMB.
     * @return o LoginAdmMB da sessão. 
     */
    public static LoginAdmMB getLoginAdmMB(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application app = facesContext.getApplication();
        LoginAdmMB loginAdmMB = (LoginAdmMB) app.evaluateExpressionGet(facesContext, "#{loginAdmMB}",LoginAdmMB.class);
        return loginAdmMB;
    }
    
    
     public static AlunoMB getAlunoMB(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application app = facesContext.getApplication();
        AlunoMB alunoMB = (AlunoMB) app.evaluateExpressionGet(facesContext, "#{alunoMB}",AlunoMB.class);
        return alunoMB;
    }
    
    /**
     * Pega a instância atual do LoginAlunoMB.
     * @return o LoginAlunoMB da sessão. 
     */
    public static LoginAlunoMB getLoginAlunoMB(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application app = facesContext.getApplication();
        LoginAlunoMB loginAlunoMB = (LoginAlunoMB) app.evaluateExpressionGet(facesContext, "#{loginAlunoMB}",LoginAlunoMB.class);
        return loginAlunoMB;
    }
    
    public static CorretorMB getCorretorMB(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application app = facesContext.getApplication();
        CorretorMB corretorMB = (CorretorMB) app.evaluateExpressionGet(facesContext, "#{corretorMB}",CorretorMB.class);
        return corretorMB;
    }
    
    
    public static LoginCorretorMB getLoginCorretorMB(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application app = facesContext.getApplication();
        LoginCorretorMB loginCorretorMB = (LoginCorretorMB) app.evaluateExpressionGet(facesContext, "#{loginCorretorMB}", LoginCorretorMB.class);
        return loginCorretorMB;
    }
    
    /**
     * @param id o identificador da tag que receberá a mensagem. Por exemplo: "formCadastro:nome"
     * @param mensagem a mensagem a ser criada.
     */
    public static void adicionarMensagem(String id, String mensagem){
        FacesMessage message = new FacesMessage(mensagem);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(id, message);
    }
    
}