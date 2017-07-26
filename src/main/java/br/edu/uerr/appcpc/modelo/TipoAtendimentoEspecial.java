/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.modelo;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fpcarlos
 */
@Dependent
@Entity
@Table(name = "tipo_atendimento_especial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAtendimentoEspecial.findAll", query = "SELECT t FROM TipoAtendimentoEspecial t")
    , @NamedQuery(name = "TipoAtendimentoEspecial.findById", query = "SELECT t FROM TipoAtendimentoEspecial t WHERE t.id = :id")
    , @NamedQuery(name = "TipoAtendimentoEspecial.findByGrupo", query = "SELECT t FROM TipoAtendimentoEspecial t WHERE t.grupo = :grupo")
    , @NamedQuery(name = "TipoAtendimentoEspecial.findBySubGrupo", query = "SELECT t FROM TipoAtendimentoEspecial t WHERE t.subGrupo = :subGrupo")})
public class TipoAtendimentoEspecial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "grupo")
    private String grupo;
    @Size(max = 200)
    @Column(name = "sub_grupo")
    private String subGrupo;
    @OneToMany(mappedBy = "idTipoAtendimentoEspecial")
    private List<IncricaoAtendimentoEspecial> incricaoAtendimentoEspecialList;

    public TipoAtendimentoEspecial() {
    }

    public TipoAtendimentoEspecial(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSubGrupo() {
        return subGrupo;
    }

    public void setSubGrupo(String subGrupo) {
        this.subGrupo = subGrupo;
    }

    @XmlTransient
    public List<IncricaoAtendimentoEspecial> getIncricaoAtendimentoEspecialList() {
        return incricaoAtendimentoEspecialList;
    }

    public void setIncricaoAtendimentoEspecialList(List<IncricaoAtendimentoEspecial> incricaoAtendimentoEspecialList) {
        this.incricaoAtendimentoEspecialList = incricaoAtendimentoEspecialList;
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
        if (!(object instanceof TipoAtendimentoEspecial)) {
            return false;
        }
        TipoAtendimentoEspecial other = (TipoAtendimentoEspecial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.appcpc.modelo.TipoAtendimentoEspecial[ id=" + id + " ]";
    }
    
}
