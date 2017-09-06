/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Entity
@Table(name = "certame")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Certame.findAll", query = "SELECT c FROM Certame c")
    , @NamedQuery(name = "Certame.findById", query = "SELECT c FROM Certame c WHERE c.id = :id")
    , @NamedQuery(name = "Certame.findByExercicio", query = "SELECT c FROM Certame c WHERE c.exercicio = :exercicio")
    , @NamedQuery(name = "Certame.findByTitulo", query = "SELECT c FROM Certame c WHERE c.titulo = :titulo")
    , @NamedQuery(name = "Certame.findBySubtitulo", query = "SELECT c FROM Certame c WHERE c.subtitulo = :subtitulo")
    , @NamedQuery(name = "Certame.findByInstituicao", query = "SELECT c FROM Certame c WHERE c.instituicao = :instituicao")
    , @NamedQuery(name = "Certame.findByTipo", query = "SELECT c FROM Certame c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "Certame.findByDataInicioInscricao", query = "SELECT c FROM Certame c WHERE c.dataInicioInscricao = :dataInicioInscricao")
    , @NamedQuery(name = "Certame.findByDataFimInscricao", query = "SELECT c FROM Certame c WHERE c.dataFimInscricao = :dataFimInscricao")
    , @NamedQuery(name = "Certame.findByDataValidadeBoleto", query = "SELECT c FROM Certame c WHERE c.dataValidadeBoleto = :dataValidadeBoleto")
    , @NamedQuery(name = "Certame.findByDataInicioIsencao", query = "SELECT c FROM Certame c WHERE c.dataInicioIsencao = :dataInicioIsencao")
    , @NamedQuery(name = "Certame.findByDataFimIsencao", query = "SELECT c FROM Certame c WHERE c.dataFimIsencao = :dataFimIsencao")
    , @NamedQuery(name = "Certame.findByDataCad", query = "SELECT c FROM Certame c WHERE c.dataCad = :dataCad")
    , @NamedQuery(name = "Certame.findByDataAlt", query = "SELECT c FROM Certame c WHERE c.dataAlt = :dataAlt")
    , @NamedQuery(name = "Certame.findByStatus", query = "SELECT c FROM Certame c WHERE c.status = :status")})
public class Certame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 4)
    @Column(name = "exercicio")
    private String exercicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 2147483647)
    @Column(name = "subtitulo")
    private String subtitulo;
    @Size(max = 2147483647)
    @Column(name = "instituicao")
    private String instituicao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private int tipo;
    @Column(name = "data_inicio_inscricao")
    @Temporal(TemporalType.DATE)
    private Date dataInicioInscricao;
    @Column(name = "data_fim_inscricao")
    @Temporal(TemporalType.DATE)
    private Date dataFimInscricao;
    @Column(name = "data_validade_boleto")
    @Temporal(TemporalType.DATE)
    private Date dataValidadeBoleto;
    @Column(name = "data_inicio_isencao")
    @Temporal(TemporalType.DATE)
    private Date dataInicioIsencao;
    @Column(name = "data_fim_isencao")
    @Temporal(TemporalType.DATE)
    private Date dataFimIsencao;
    @Column(name = "data_cad")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCad;
    @Column(name = "data_alt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlt;
    @Column(name = "status")
    private Integer status;
    @OneToMany(mappedBy = "idCertame")
    private List<Cargo> cargoList;

    public Certame() {
    }

    public Certame(Integer id) {
        this.id = id;
    }

    public Certame(Integer id, String titulo, int tipo) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExercicio() {
        return exercicio;
    }

    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getDataInicioInscricao() {
        return dataInicioInscricao;
    }

    public void setDataInicioInscricao(Date dataInicioInscricao) {
        this.dataInicioInscricao = dataInicioInscricao;
    }

    public Date getDataFimInscricao() {
        return dataFimInscricao;
    }

    public void setDataFimInscricao(Date dataFimInscricao) {
        this.dataFimInscricao = dataFimInscricao;
    }

    public Date getDataValidadeBoleto() {
        return dataValidadeBoleto;
    }

    public void setDataValidadeBoleto(Date dataValidadeBoleto) {
        this.dataValidadeBoleto = dataValidadeBoleto;
    }

    public Date getDataInicioIsencao() {
        return dataInicioIsencao;
    }

    public void setDataInicioIsencao(Date dataInicioIsencao) {
        this.dataInicioIsencao = dataInicioIsencao;
    }

    public Date getDataFimIsencao() {
        return dataFimIsencao;
    }

    public void setDataFimIsencao(Date dataFimIsencao) {
        this.dataFimIsencao = dataFimIsencao;
    }

    public Date getDataCad() {
        return dataCad;
    }

    public void setDataCad(Date dataCad) {
        this.dataCad = dataCad;
    }

    public Date getDataAlt() {
        return dataAlt;
    }

    public void setDataAlt(Date dataAlt) {
        this.dataAlt = dataAlt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @XmlTransient
    public List<Cargo> getCargoList() {
        return cargoList;
    }

    public void setCargoList(List<Cargo> cargoList) {
        this.cargoList = cargoList;
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
        if (!(object instanceof Certame)) {
            return false;
        }
        Certame other = (Certame) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.appcpc.modelo.Certame[ id=" + id + " ]";
    }
    
}
