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
@Table(name = "inscricao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscricao.findAll", query = "SELECT i FROM Inscricao i")
    , @NamedQuery(name = "Inscricao.findById", query = "SELECT i FROM Inscricao i WHERE i.id = :id")
    , @NamedQuery(name = "Inscricao.findByNumeroBoleto", query = "SELECT i FROM Inscricao i WHERE i.numeroBoleto = :numeroBoleto")
    , @NamedQuery(name = "Inscricao.findByIdLocalProva", query = "SELECT i FROM Inscricao i WHERE i.idLocalProva = :idLocalProva")
    , @NamedQuery(name = "Inscricao.findBySalaProva", query = "SELECT i FROM Inscricao i WHERE i.salaProva = :salaProva")
    , @NamedQuery(name = "Inscricao.findByDataHoraCadastro", query = "SELECT i FROM Inscricao i WHERE i.dataHoraCadastro = :dataHoraCadastro")
    , @NamedQuery(name = "Inscricao.findByDataHoraAlteracao", query = "SELECT i FROM Inscricao i WHERE i.dataHoraAlteracao = :dataHoraAlteracao")})
public class Inscricao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "numero_boleto")
    private String numeroBoleto;
    @Column(name = "id_local_prova")
    private Integer idLocalProva;
    @Column(name = "sala_prova")
    private Integer salaProva;
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
    @JoinColumn(name = "id_cargo", referencedColumnName = "id")
    @ManyToOne
    private Cargo idCargo;
    @JoinColumn(name = "id_certame", referencedColumnName = "id")
    @ManyToOne
    private Certame idCertame;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    @ManyToOne
    private Pessoa idPessoa;
    @JoinColumn(name = "id_situacao_inscricao", referencedColumnName = "id")
    @ManyToOne
    private SituacaoInscricao idSituacaoInscricao;
    @OneToMany(mappedBy = "idInscricao")
    private List<IncricaoAtendimentoEspecial> incricaoAtendimentoEspecialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInscricao")
    private List<ArquivoCartaoResposta> arquivoCartaoRespostaList;

    public Inscricao() {
    }

    public Inscricao(Integer id) {
        this.id = id;
    }

    public Inscricao(Integer id, Date dataHoraCadastro, Date dataHoraAlteracao) {
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

    public String getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(String numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }

    public Integer getIdLocalProva() {
        return idLocalProva;
    }

    public void setIdLocalProva(Integer idLocalProva) {
        this.idLocalProva = idLocalProva;
    }

    public Integer getSalaProva() {
        return salaProva;
    }

    public void setSalaProva(Integer salaProva) {
        this.salaProva = salaProva;
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

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

    public Certame getIdCertame() {
        return idCertame;
    }

    public void setIdCertame(Certame idCertame) {
        this.idCertame = idCertame;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    public SituacaoInscricao getIdSituacaoInscricao() {
        return idSituacaoInscricao;
    }

    public void setIdSituacaoInscricao(SituacaoInscricao idSituacaoInscricao) {
        this.idSituacaoInscricao = idSituacaoInscricao;
    }

    @XmlTransient
    public List<IncricaoAtendimentoEspecial> getIncricaoAtendimentoEspecialList() {
        return incricaoAtendimentoEspecialList;
    }

    public void setIncricaoAtendimentoEspecialList(List<IncricaoAtendimentoEspecial> incricaoAtendimentoEspecialList) {
        this.incricaoAtendimentoEspecialList = incricaoAtendimentoEspecialList;
    }

    @XmlTransient
    public List<ArquivoCartaoResposta> getArquivoCartaoRespostaList() {
        return arquivoCartaoRespostaList;
    }

    public void setArquivoCartaoRespostaList(List<ArquivoCartaoResposta> arquivoCartaoRespostaList) {
        this.arquivoCartaoRespostaList = arquivoCartaoRespostaList;
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
        if (!(object instanceof Inscricao)) {
            return false;
        }
        Inscricao other = (Inscricao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.appcpc.modelo.Inscricao[ id=" + id + " ]";
    }
    
}
