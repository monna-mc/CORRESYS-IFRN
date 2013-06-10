/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import auxiliar.EMF;
import auxiliar.FacesUtil;
import dao.AlunoJpaController;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Aluno;

/**
 *
 * @author Monnalisa Medeiros
 */
@ManagedBean
@SessionScoped
public class LoginAlunoMB {

    private Aluno aluno = new Aluno();
    
    private String matricula ="";
    
    private String senha="";
    
    private AlunoJpaController dao = new AlunoJpaController(EMF.getEntityManagerFactory());
    
    private boolean logado = false;
    
    private String mensagem;
    
    
    public LoginAlunoMB() {
    }
    
    public boolean validarLogin(){
        Aluno a = dao.findAluno(matricula , senha);
        if (a != null){
            aluno = a;
            AlunoMB umb = FacesUtil.getAlunoMB();
            umb.setAluno(aluno);
      
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
    
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
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
     * @return a página inicial da sessao do aluno.
     */
    public String logar(){
       boolean aux = validarLogin(); 
        if (aux== true){         
            return "/aluno.xhtml";
        } else {
            FacesUtil.adicionarMensagem("formEntrarAlu", "Matrícula e senha não conferem !");
            return null;
        }
    }
    
    /**
     * 
     * @return a página inicial.
     */
    public String deslogarA(){
        setDeslogado();
        aluno = new Aluno();
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