/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpcarlos
 */
@Dependent
@Entity
@Table(name = "endereco_pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnderecoPessoa.findAll", query = "SELECT e FROM EnderecoPessoa e")
    , @NamedQuery(name = "EnderecoPessoa.findById", query = "SELECT e FROM EnderecoPessoa e WHERE e.id = :id")
    , @NamedQuery(name = "EnderecoPessoa.findByCep", query = "SELECT e FROM EnderecoPessoa e WHERE e.cep = :cep")
    , @NamedQuery(name = "EnderecoPessoa.findByLogradouro", query = "SELECT e FROM EnderecoPessoa e WHERE e.logradouro = :logradouro")
    , @NamedQuery(name = "EnderecoPessoa.findByComplemento", query = "SELECT e FROM EnderecoPessoa e WHERE e.complemento = :complemento")
    , @NamedQuery(name = "EnderecoPessoa.findByBairro", query = "SELECT e FROM EnderecoPessoa e WHERE e.bairro = :bairro")
    , @NamedQuery(name = "EnderecoPessoa.findByLocalidade", query = "SELECT e FROM EnderecoPessoa e WHERE e.localidade = :localidade")
    , @NamedQuery(name = "EnderecoPessoa.findByUf", query = "SELECT e FROM EnderecoPessoa e WHERE e.uf = :uf")
    , @NamedQuery(name = "EnderecoPessoa.findByIbge", query = "SELECT e FROM EnderecoPessoa e WHERE e.ibge = :ibge")
    , @NamedQuery(name = "EnderecoPessoa.findByGuia", query = "SELECT e FROM EnderecoPessoa e WHERE e.guia = :guia")
    , @NamedQuery(name = "EnderecoPessoa.findByDataHoraAlteracao", query = "SELECT e FROM EnderecoPessoa e WHERE e.dataHoraAlteracao = :dataHoraAlteracao")
    , @NamedQuery(name = "EnderecoPessoa.findByDataHoraCadastro", query = "SELECT e FROM EnderecoPessoa e WHERE e.dataHoraCadastro = :dataHoraCadastro")
    , @NamedQuery(name = "EnderecoPessoa.findByNumero", query = "SELECT e FROM EnderecoPessoa e WHERE e.numero = :numero")})
public class EnderecoPessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "cep")
    private String cep;
    @Size(max = 250)
    @Column(name = "logradouro")
    private String logradouro;
    @Size(max = 100)
    @Column(name = "complemento")
    private String complemento;
    @Size(max = 100)
    @Column(name = "bairro")
    private String bairro;
    @Size(max = 100)
    @Column(name = "localidade")
    private String localidade;
    @Size(max = 2)
    @Column(name = "uf")
    private String uf;
    @Size(max = 100)
    @Column(name = "ibge")
    private String ibge;
    @Size(max = 100)
    @Column(name = "guia")
    private String guia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_hora_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraAlteracao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @Size(max = 20)
    @Column(name = "numero")
    private String numero;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa idPessoa;

    public EnderecoPessoa() {
    }

    public EnderecoPessoa(Integer id) {
        this.id = id;
    }

    public EnderecoPessoa(Integer id, Date dataHoraAlteracao, Date dataHoraCadastro) {
        this.id = id;
        this.dataHoraAlteracao = dataHoraAlteracao;
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGuia() {
        return guia;
    }

    public void setGuia(String guia) {
        this.guia = guia;
    }

    public Date getDataHoraAlteracao() {
        return dataHoraAlteracao;
    }

    public void setDataHoraAlteracao(Date dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
    }

    public Date getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(Date dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
        if (!(object instanceof EnderecoPessoa)) {
            return false;
        }
        EnderecoPessoa other = (EnderecoPessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.appcpc.modelo.EnderecoPessoa[ id=" + id + " ]";
    }
    
}
