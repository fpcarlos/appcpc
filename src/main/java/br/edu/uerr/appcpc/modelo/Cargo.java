/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c")
    , @NamedQuery(name = "Cargo.findById", query = "SELECT c FROM Cargo c WHERE c.id = :id")
    , @NamedQuery(name = "Cargo.findByNome", query = "SELECT c FROM Cargo c WHERE c.nome = :nome")
    , @NamedQuery(name = "Cargo.findByNomeCurto", query = "SELECT c FROM Cargo c WHERE c.nomeCurto = :nomeCurto")
    , @NamedQuery(name = "Cargo.findByQtdVaga", query = "SELECT c FROM Cargo c WHERE c.qtdVaga = :qtdVaga")
    , @NamedQuery(name = "Cargo.findByValorVaga", query = "SELECT c FROM Cargo c WHERE c.valorVaga = :valorVaga")
    , @NamedQuery(name = "Cargo.findByStatus", query = "SELECT c FROM Cargo c WHERE c.status = :status")})
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @Size(max = 200)
    @Column(name = "nome_curto")
    private String nomeCurto;
    @Column(name = "qtd_vaga")
    private Integer qtdVaga;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_vaga")
    private BigDecimal valorVaga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(mappedBy = "idCargo")
    private List<Inscricao> inscricaoList;
    @JoinColumn(name = "id_certame", referencedColumnName = "id")
    @ManyToOne
    private Certame idCertame;
    @JoinColumn(name = "id_tipo_vaga", referencedColumnName = "id")
    @ManyToOne
    private TipoVaga idTipoVaga;

    public Cargo() {
    }

    public Cargo(Integer id) {
        this.id = id;
    }

    public Cargo(Integer id, int status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCurto() {
        return nomeCurto;
    }

    public void setNomeCurto(String nomeCurto) {
        this.nomeCurto = nomeCurto;
    }

    public Integer getQtdVaga() {
        return qtdVaga;
    }

    public void setQtdVaga(Integer qtdVaga) {
        this.qtdVaga = qtdVaga;
    }

    public BigDecimal getValorVaga() {
        return valorVaga;
    }

    public void setValorVaga(BigDecimal valorVaga) {
        this.valorVaga = valorVaga;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public List<Inscricao> getInscricaoList() {
        return inscricaoList;
    }

    public void setInscricaoList(List<Inscricao> inscricaoList) {
        this.inscricaoList = inscricaoList;
    }

    public Certame getIdCertame() {
        return idCertame;
    }

    public void setIdCertame(Certame idCertame) {
        this.idCertame = idCertame;
    }

    public TipoVaga getIdTipoVaga() {
        return idTipoVaga;
    }

    public void setIdTipoVaga(TipoVaga idTipoVaga) {
        this.idTipoVaga = idTipoVaga;
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
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.appcpc.modelo.Cargo[ id=" + id + " ]";
    }
    
}
