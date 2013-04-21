
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Monnalisa Christina
 * Classe redação - projeto Corresys versão 1.0
 * data:25/03/2013
 */

@Entity
public class Redacao implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tema;
    private String titulo;
    private float nota;
    private String status;
    private String matriculaCorretor;
    private String matriculaAluno;

    
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

   
}
