/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.modelo;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
@Table(name = "pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")
    , @NamedQuery(name = "Pessoa.findById", query = "SELECT p FROM Pessoa p WHERE p.id = :id")
    , @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome = :nome")
    , @NamedQuery(name = "Pessoa.findByNomeSocial", query = "SELECT p FROM Pessoa p WHERE p.nomeSocial = :nomeSocial")
    , @NamedQuery(name = "Pessoa.findByDataNascimento", query = "SELECT p FROM Pessoa p WHERE p.dataNascimento = :dataNascimento")
    , @NamedQuery(name = "Pessoa.findBySexo", query = "SELECT p FROM Pessoa p WHERE p.sexo = :sexo")
    , @NamedQuery(name = "Pessoa.findByEscolaridade", query = "SELECT p FROM Pessoa p WHERE p.escolaridade = :escolaridade")
    , @NamedQuery(name = "Pessoa.findByNomePai", query = "SELECT p FROM Pessoa p WHERE p.nomePai = :nomePai")
    , @NamedQuery(name = "Pessoa.findByNomeMae", query = "SELECT p FROM Pessoa p WHERE p.nomeMae = :nomeMae")
    , @NamedQuery(name = "Pessoa.findByCpf", query = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf")
    , @NamedQuery(name = "Pessoa.findByRg", query = "SELECT p FROM Pessoa p WHERE p.rg = :rg")
    , @NamedQuery(name = "Pessoa.findByEmail", query = "SELECT p FROM Pessoa p WHERE p.email = :email")
    , @NamedQuery(name = "Pessoa.findByCelular", query = "SELECT p FROM Pessoa p WHERE p.celular = :celular")
    , @NamedQuery(name = "Pessoa.findByTelefone", query = "SELECT p FROM Pessoa p WHERE p.telefone = :telefone")
    , @NamedQuery(name = "Pessoa.findBySenha", query = "SELECT p FROM Pessoa p WHERE p.senha = :senha")    
    , @NamedQuery(name = "Pessoa.findByCep", query = "SELECT p FROM Pessoa p WHERE p.cep = :cep")
    , @NamedQuery(name = "Pessoa.findByLogradouro", query = "SELECT p FROM Pessoa p WHERE p.logradouro = :logradouro")
    , @NamedQuery(name = "Pessoa.findByComplemento", query = "SELECT p FROM Pessoa p WHERE p.complemento = :complemento")
    , @NamedQuery(name = "Pessoa.findByBairro", query = "SELECT p FROM Pessoa p WHERE p.bairro = :bairro")
    , @NamedQuery(name = "Pessoa.findByCidade", query = "SELECT p FROM Pessoa p WHERE p.cidade = :cidade")
    , @NamedQuery(name = "Pessoa.findByUf", query = "SELECT p FROM Pessoa p WHERE p.uf = :uf")
    , @NamedQuery(name = "Pessoa.findByNumero", query = "SELECT p FROM Pessoa p WHERE p.numero = :numero")
    , @NamedQuery(name = "Pessoa.findByDataHotaAlteracao", query = "SELECT p FROM Pessoa p WHERE p.dataHotaAlteracao = :dataHotaAlteracao")
    , @NamedQuery(name = "Pessoa.findByDataHoraCadastro", query = "SELECT p FROM Pessoa p WHERE p.dataHoraCadastro = :dataHoraCadastro")})
public class Pessoa implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private List<EnderecoPessoa> enderecoPessoaList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @Size(max = 2147483647)
    @Column(name = "nome_social")
    private String nomeSocial;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "sexo")
    private Character sexo;
    @Size(max = 200)
    @Column(name = "nome_pai")
    private String nomePai;
    @Size(max = 200)
    @Column(name = "nome_mae")
    private String nomeMae;
    @Size(max = 20)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 50)
    @Column(name = "rg")
    private String rg;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 200)
    @Column(name = "email")
    private String email;
    @Size(max = 20)
    @Column(name = "celular")
    private String celular;
    @Size(max = 20)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 250)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_hota_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHotaAlteracao;
    @Size(max = 100)
    @Column(name = "escolaridade")
    private String escolaridade;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @OneToMany(mappedBy = "idPessoa")
    private List<Inscricao> inscricaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private List<ArquivoPessoa> arquivoPessoaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private List<Requerimento> requerimentoList;
    @OneToMany(mappedBy = "idPessoa")
    private List<GrupoUsuario> grupoUsuarioList;

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
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 2)
    @Column(name = "uf")
    private String uf;
    @Size(max = 20)
    @Column(name = "numero")
    private String numero;

    public Pessoa() {
    }

    public Pessoa(Integer id) {
        this.id = id;
    }

    public Pessoa(Integer id, Date dataHotaAlteracao, Date dataHoraCadastro) {
        this.id = id;
        this.dataHotaAlteracao = dataHotaAlteracao;
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public String getSenhaMD5(String aux) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        //md.update(senhaAtual.getBytes());
        byte[] result = md.digest(aux.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
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

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataHotaAlteracao() {
        return dataHotaAlteracao;
    }

    public void setDataHotaAlteracao(Date dataHotaAlteracao) {
        this.dataHotaAlteracao = dataHotaAlteracao;
    }

    public Date getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(Date dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    @XmlTransient
    public List<Inscricao> getInscricaoList() {
        return inscricaoList;
    }

    public void setInscricaoList(List<Inscricao> inscricaoList) {
        this.inscricaoList = inscricaoList;
    }

    @XmlTransient
    public List<ArquivoPessoa> getArquivoPessoaList() {
        return arquivoPessoaList;
    }

    public void setArquivoPessoaList(List<ArquivoPessoa> arquivoPessoaList) {
        this.arquivoPessoaList = arquivoPessoaList;
    }

    @XmlTransient
    public List<Requerimento> getRequerimentoList() {
        return requerimentoList;
    }

    public void setRequerimentoList(List<Requerimento> requerimentoList) {
        this.requerimentoList = requerimentoList;
    }

    @XmlTransient
    public List<GrupoUsuario> getGrupoUsuarioList() {
        return grupoUsuarioList;
    }

    public void setGrupoUsuarioList(List<GrupoUsuario> grupoUsuarioList) {
        this.grupoUsuarioList = grupoUsuarioList;
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
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.appcpc.modelo.Pessoa[ id=" + id + " ]";
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @XmlTransient
    public List<EnderecoPessoa> getEnderecoPessoaList() {
        return enderecoPessoaList;
    }

    public void setEnderecoPessoaList(List<EnderecoPessoa> enderecoPessoaList) {
        this.enderecoPessoaList = enderecoPessoaList;
    }

}
