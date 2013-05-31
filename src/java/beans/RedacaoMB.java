package beans;

import dao.RedacaoJpaController;
import dao.exceptions.NonexistentEntityException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Redacao;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 * @author Monnalisa Christina ManagedBean do Aluno - projeto Corresys versão
 * 1.0 data:30/05/2013 Inserção de imagem funcionando
 */
@ManagedBean
@SessionScoped
public class RedacaoMB implements Serializable {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CORRESYS_1.0PU");
    RedacaoJpaController dao = new RedacaoJpaController(emf);
    private String mensagem = "";
    private List<Redacao> redacoes = new ArrayList<Redacao>();
    private Redacao redacao = new Redacao();
    private String redacaoPesquisado;
    private UploadedFile foto;
    private DefaultStreamedContent graphicText;

    public RedacaoMB() {
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

    public Redacao getRedacao() {
        return redacao;
    }

    public void setRedacao(Redacao redacao) {
        this.redacao = redacao;
    }

    public List<Redacao> getRedList() {
        return redacoes;
    }

    /**
     * @return the imagem
     */
    public UploadedFile getFoto() {
        return foto;
    }

    /**
     * @param imagem the imagem to set
     */
    public void setFoto(UploadedFile foto) {
        this.foto = foto;
    }

    /**
     * método chamado para fazer upload da imagem e salvar todos os dados no BD.
     */
    public void upload() {
        if (getFoto() != null) {

            byte[] imgNova = foto.getContents();

            redacao.setImagem(imgNova);

            /* dao.create(redacao);
             this.setMensagem(this.redacao.getTitulo() + " cadastrado(a) com sucesso! ");
             redacao = dao.findRedacao(redacao.getId());*/

            try {
                dao.create(redacao);
                this.setMensagem(this.redacao.getTitulo() + " cadastrado(a) com sucesso ! ");
                redacao = new Redacao();
            } catch (Exception ex) {
                setMensagem(this.redacao.getTitulo() + "já existe no sistema, cadastro não realizado!");
                Logger.getLogger(AlunoMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         pesquisar();
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

    public int pesquisar() {
        redacoes = dao.findRedacaoEntities();
        return redacoes.size();

    }

    public void pesquisarRedacoes() {
        redacoes = new ArrayList<Redacao>();
        for (Redacao r : dao.findRedacaoEntities()) {
            if ((r.getTitulo().toLowerCase().contains(redacaoPesquisado) || (r.getTema().toLowerCase().contains(redacaoPesquisado)))) {
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

    /**
     * Esse método é usado pra fazer a imagem ser exibida na tela.
     */
    public StreamedContent getFotoStreamed() {

        if (redacao.getImagem() == null) {
            BufferedImage bufferedImg = new BufferedImage(100, 25, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = bufferedImg.createGraphics();
            g2.drawString("This is a text", 0, 10);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            try {
                ImageIO.write(bufferedImg, "png", os);
            } catch (IOException ex) {
                Logger.getLogger(RedacaoMB.class.getName()).log(Level.SEVERE, null, ex);
            }
            graphicText = new DefaultStreamedContent(new ByteArrayInputStream(os.toByteArray()), "image/png");

            return graphicText;
        }
        //retorna a imagem gravada no BD
        return new DefaultStreamedContent(new ByteArrayInputStream(redacao.getImagem()));
    }
}