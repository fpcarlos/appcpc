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
@Table(name = "local_prova")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocalProva.findAll", query = "SELECT l FROM LocalProva l")
    , @NamedQuery(name = "LocalProva.findById", query = "SELECT l FROM LocalProva l WHERE l.id = :id")
    , @NamedQuery(name = "LocalProva.findByNome", query = "SELECT l FROM LocalProva l WHERE l.nome = :nome")
    , @NamedQuery(name = "LocalProva.findByQtdSalas", query = "SELECT l FROM LocalProva l WHERE l.qtdSalas = :qtdSalas")
    , @NamedQuery(name = "LocalProva.findByQtdCandidatoSala", query = "SELECT l FROM LocalProva l WHERE l.qtdCandidatoSala = :qtdCandidatoSala")
    , @NamedQuery(name = "LocalProva.findByCep", query = "SELECT l FROM LocalProva l WHERE l.cep = :cep")
    , @NamedQuery(name = "LocalProva.findByEndereco", query = "SELECT l FROM LocalProva l WHERE l.endereco = :endereco")
    , @NamedQuery(name = "LocalProva.findByTelefone", query = "SELECT l FROM LocalProva l WHERE l.telefone = :telefone")
    , @NamedQuery(name = "LocalProva.findByEmail", query = "SELECT l FROM LocalProva l WHERE l.email = :email")})
public class LocalProva implements Serializable {

    @OneToMany(mappedBy = "idLocalProva")
    private List<Inscricao> inscricaoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @Column(name = "qtd_salas")
    private Integer qtdSalas;
    @Column(name = "qtd_candidato_sala")
    private Integer qtdCandidatoSala;
    @Size(max = 20)
    @Column(name = "cep")
    private String cep;
    @Size(max = 2147483647)
    @Column(name = "endereco")
    private String endereco;
    @Size(max = 50)
    @Column(name = "telefone")
    private String telefone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 250)
    @Column(name = "email")
    private String email;

    public LocalProva() {
    }

    public LocalProva(Integer id) {
        this.id = id;
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

    public Integer getQtdSalas() {
        return qtdSalas;
    }

    public void setQtdSalas(Integer qtdSalas) {
        this.qtdSalas = qtdSalas;
    }

    public Integer getQtdCandidatoSala() {
        return qtdCandidatoSala;
    }

    public void setQtdCandidatoSala(Integer qtdCandidatoSala) {
        this.qtdCandidatoSala = qtdCandidatoSala;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(object instanceof LocalProva)) {
            return false;
        }
        LocalProva other = (LocalProva) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.appcpc.modelo.LocalProva[ id=" + id + " ]";
    }

    @XmlTransient
    public List<Inscricao> getInscricaoList() {
        return inscricaoList;
    }

    public void setInscricaoList(List<Inscricao> inscricaoList) {
        this.inscricaoList = inscricaoList;
    }
    
}
