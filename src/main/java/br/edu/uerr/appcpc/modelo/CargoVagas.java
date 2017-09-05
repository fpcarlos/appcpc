/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fpcarlos
 */
@Entity
@Table(name = "cargo_vagas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CargoVagas.findAll", query = "SELECT c FROM CargoVagas c")
    , @NamedQuery(name = "CargoVagas.findById", query = "SELECT c FROM CargoVagas c WHERE c.id = :id")
    , @NamedQuery(name = "CargoVagas.findByQtdVaga", query = "SELECT c FROM CargoVagas c WHERE c.qtdVaga = :qtdVaga")
    , @NamedQuery(name = "CargoVagas.findByValorVaga", query = "SELECT c FROM CargoVagas c WHERE c.valorVaga = :valorVaga")
    , @NamedQuery(name = "CargoVagas.findByStatus", query = "SELECT c FROM CargoVagas c WHERE c.status = :status")})
public class CargoVagas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "qtd_vaga")
    private Integer qtdVaga;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_vaga")
    private BigDecimal valorVaga;
    @Column(name = "status")
    private Integer status;
    @OneToMany(mappedBy = "idCargoVagas")
    private List<Inscricao> inscricaoList;
    @JoinColumn(name = "id_cargo", referencedColumnName = "id")
    @ManyToOne
    private Cargo idCargo;
    @JoinColumn(name = "id_tipo_vaga", referencedColumnName = "id")
    @ManyToOne
    private TipoVaga idTipoVaga;

    public CargoVagas() {
    }

    public CargoVagas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @XmlTransient
    public List<Inscricao> getInscricaoList() {
        return inscricaoList;
    }

    public void setInscricaoList(List<Inscricao> inscricaoList) {
        this.inscricaoList = inscricaoList;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
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
        if (!(object instanceof CargoVagas)) {
            return false;
        }
        CargoVagas other = (CargoVagas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.appcpc.modelo.CargoVagas[ id=" + id + " ]";
    }
    
}
