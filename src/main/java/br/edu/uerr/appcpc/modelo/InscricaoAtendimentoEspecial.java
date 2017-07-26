/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.modelo;

import java.io.Serializable;
import javax.enterprise.context.Dependent;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpcarlos
 */
@Dependent
@Entity
@Table(name = "incricao_atendimento_especial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InscricaoAtendimentoEspecial.findAll", query = "SELECT i FROM InscricaoAtendimentoEspecial i")
    , @NamedQuery(name = "InscricaoAtendimentoEspecial.findById", query = "SELECT i FROM InscricaoAtendimentoEspecial i WHERE i.id = :id")})
public class InscricaoAtendimentoEspecial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_inscricao", referencedColumnName = "id")
    @ManyToOne
    private Inscricao idInscricao;
    @JoinColumn(name = "id_tipo_atendimento_especial", referencedColumnName = "id")
    @ManyToOne
    private TipoAtendimentoEspecial idTipoAtendimentoEspecial;

    public InscricaoAtendimentoEspecial() {
    }

    public InscricaoAtendimentoEspecial(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Inscricao getIdInscricao() {
        return idInscricao;
    }

    public void setIdInscricao(Inscricao idInscricao) {
        this.idInscricao = idInscricao;
    }

    public TipoAtendimentoEspecial getIdTipoAtendimentoEspecial() {
        return idTipoAtendimentoEspecial;
    }

    public void setIdTipoAtendimentoEspecial(TipoAtendimentoEspecial idTipoAtendimentoEspecial) {
        this.idTipoAtendimentoEspecial = idTipoAtendimentoEspecial;
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
        if (!(object instanceof InscricaoAtendimentoEspecial)) {
            return false;
        }
        InscricaoAtendimentoEspecial other = (InscricaoAtendimentoEspecial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.appcpc.modelo.IncricaoAtendimentoEspecial[ id=" + id + " ]";
    }
    
}
