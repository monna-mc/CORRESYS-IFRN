
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 * @author Monnalisa Christina
 * Classe redação - projeto Corresys versão 1.0
 * data:15/05/2013
 */

@Entity
public class Redacao implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tema;
    private String titulo;
    private float nota = (float) 0.0;//Nota geral da redação
    private String status;
    private String matriculaCorretor;
    private String matriculaAluno;
    private byte[] imagem;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dat;
    private int comp1 = (int) 0;//nota da demonstração de domínio da norma padrão 
    private int comp2 = (int) 0;// nota da compreenção da proposta de redação
    private int comp3 = (int) 0;//nota de interpretação de informações em defesa de um ponto de vista.
    private int comp4 = (int) 0;//nota de Demonstração de conhecimento linguísticos necessários à construção da argumentação
    private int comp5 = (int) 0;// nota da Elaboração de proposta
    
     @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Redacao)) {
            return false;
        }
        Redacao other = (Redacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Redacao[ id=" + id + " ]";
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
     /**
     * @return the tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the nota
     */
    public float getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(float nota) {
        this.nota = nota;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
   
    /**
     * @return the imagem
     */
    public byte[] getImagem() {
        return imagem;
    }

    /**
     * @param imagem the imagem to set
     */
    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    /**
     * @return the dat
     */
    public Date getDat() {
        return dat;
    }

    /**
     * @param dat the dat to set
     */
    public void setDat(Date dat) {
        this.dat = dat;
    }

    /**
     * @return the matriculaCorretor
     */
    public String getMatriculaCorretor() {
        return matriculaCorretor;
    }

    /**
     * @param matriculaCorretor the matriculaCorretor to set
     */
    public void setMatriculaCorretor(String matriculaCorretor) {
        this.matriculaCorretor = matriculaCorretor;
    }

    /**
     * @return the matriculaAluno
     */
    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    /**
     * @param matriculaAluno the matriculaAluno to set
     */
    public void setMatriculaAluno(String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    /**
     * @return the comp1
     */
    public int getComp1() {
        return comp1;
    }

    /**
     * @param comp1 the comp1 to set
     */
    public void setComp1(int comp1) {
        this.comp1 = comp1;
    }

    /**
     * @return the comp2
     */
    public int getComp2() {
        return comp2;
    }

    /**
     * @param comp2 the comp2 to set
     */
    public void setComp2(int comp2) {
        this.comp2 = comp2;
    }

    /**
     * @return the comp3
     */
    public int getComp3() {
        return comp3;
    }

    /**
     * @param comp3 the comp3 to set
     */
    public void setComp3(int comp3) {
        this.comp3 = comp3;
    }

    /**
     * @return the comp4
     */
    public int getComp4() {
        return comp4;
    }

    /**
     * @param comp4 the comp4 to set
     */
    public void setComp4(int comp4) {
        this.comp4 = comp4;
    }

    /**
     * @return the comp5
     */
    public int getComp5() {
        return comp5;
    }

    /**
     * @param comp5 the comp5 to set
     */
    public void setComp5(int comp5) {
        this.comp5 = comp5;
    }
}
