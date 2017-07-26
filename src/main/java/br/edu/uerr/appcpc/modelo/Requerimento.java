/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fpcarlos
 */
@Dependent
@Entity
@Table(name = "requerimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requerimento.findAll", query = "SELECT r FROM Requerimento r")
    , @NamedQuery(name = "Requerimento.findById", query = "SELECT r FROM Requerimento r WHERE r.id = :id")
    , @NamedQuery(name = "Requerimento.findByAssunto", query = "SELECT r FROM Requerimento r WHERE r.assunto = :assunto")
    , @NamedQuery(name = "Requerimento.findByTextoRequerimento", query = "SELECT r FROM Requerimento r WHERE r.textoRequerimento = :textoRequerimento")
    , @NamedQuery(name = "Requerimento.findByDataHoraCadastro", query = "SELECT r FROM Requerimento r WHERE r.dataHoraCadastro = :dataHoraCadastro")
    , @NamedQuery(name = "Requerimento.findByDataHoraAlteracao", query = "SELECT r FROM Requerimento r WHERE r.dataHoraAlteracao = :dataHoraAlteracao")})
public class Requerimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 250)
    @Column(name = "assunto")
    private String assunto;
    @Size(max = 2147483647)
    @Column(name = "texto_requerimento")
    private String textoRequerimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_hora_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraAlteracao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRequerimento")
    private List<ArquivoRequerimento> arquivoRequerimentoList;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa idPessoa;

    public Requerimento() {
    }

    public Requerimento(Integer id) {
        this.id = id;
    }

    public Requerimento(Integer id, Date dataHoraCadastro, Date dataHoraAlteracao) {
        this.id = id;
        this.dataHoraCadastro = dataHoraCadastro;
        this.dataHoraAlteracao = dataHoraAlteracao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getTextoRequerimento() {
        return textoRequerimento;
    }

    public void setTextoRequerimento(String textoRequerimento) {
        this.textoRequerimento = textoRequerimento;
    }

    public Date getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(Date dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public Date getDataHoraAlteracao() {
        return dataHoraAlteracao;
    }

    public void setDataHoraAlteracao(Date dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
    }

    @XmlTransient
    public List<ArquivoRequerimento> getArquivoRequerimentoList() {
        return arquivoRequerimentoList;
    }

    public void setArquivoRequerimentoList(List<ArquivoRequerimento> arquivoRequerimentoList) {
        this.arquivoRequerimentoList = arquivoRequerimentoList;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
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
        if (!(object instanceof Requerimento)) {
            return false;
        }
        Requerimento other = (Requerimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.appcpc.modelo.Requerimento[ id=" + id + " ]";
    }
    
}
