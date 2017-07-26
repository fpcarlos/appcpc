/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.visao;

import br.edu.uerr.appcpc.controle.EnderecoPessoaControle;
import br.edu.uerr.appcpc.controle.PessoaControle;
import br.edu.uerr.appcpc.modelo.EnderecoPessoa;
import br.edu.uerr.appcpc.modelo.Pessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author fpcarlos
 */
@Named
@SessionScoped
public class PessoaVisao extends AbstractVisao implements Serializable {

    @EJB
    private PessoaControle pessoaControle;

    @EJB
    private EnderecoPessoaControle enderecoPessoaControle;

    private Pessoa pessoa;

    private EnderecoPessoa enderecoPessoa;

    private List<Pessoa> listPessoa = new ArrayList<>();

    private List<EnderecoPessoa> listEnderecoPessoa = new ArrayList<>();

    private String confirmaSenha;

    public PessoaVisao() {
        super();
    }

    public String abrirCadastro() {
        try {
            pessoa = new Pessoa();
            pessoa = pessoaControle.pegaPessoaId(94797);
            //listPessoa = new ArrayList<>();
            //enderecoPessoa = new EnderecoPessoa();
            System.out.println(pessoa.getNome());
            //listEnderecoPessoa = new ArrayList<>();            

            //listPessoa = pessoaControle.findAll();
            //listEnderecoPessoa = enderecoPessoaControle.findAll();
            return redirect("/sistema/usuario/formCandidato.xhtml");
        } catch (Exception e) {
            return null;
        }
    }

    public void salvar() {
        try {
            pessoaControle.salvar(pessoa);

            showFacesMessage("salvo com sucesso!!!", 2);
            pessoa = new Pessoa();
            //listPessoa = new ArrayList<>();
            //listPessoa = pessoaControle.findAll();
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/evento/sistema/usuario/listaUsuarios.xhtml");
            //return redirect("/sistema/usuario/listaUsuarios.xhtml?faces-redirect=true");
        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            //return null;
        }
    }

    public String editar(Pessoa aux) {
        try {
            pessoa = pessoaControle.pegaPessoaId(aux.getId());

            listPessoa = new ArrayList<>();
            listPessoa = pessoaControle.findAll();
            return redirect("/sistema/usuario/formCandidato.xhtml");

        } catch (Exception e) {
            return null;
        }
    }

    public String remover(Pessoa aux) {
        try {
            //pessoaControle.remove(aux);

            showFacesMessage("Impossível remover candidato!!!", 4);
            pessoa = new Pessoa();
            listPessoa = new ArrayList<>();
            listPessoa = pessoaControle.findAll();

            return redirect("/sistema/usuario/formCandidato.xhtml");

        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            return null;
        }
    }

    //Gets e Sets
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getListPessoa() {
        return listPessoa;
    }

    public void setListPessoa(List<Pessoa> listPessoa) {
        this.listPessoa = listPessoa;
    }

    public EnderecoPessoa getEnderecoPessoa() {
        return enderecoPessoa;
    }

    public void setEnderecoPessoa(EnderecoPessoa enderecoPessoa) {
        this.enderecoPessoa = enderecoPessoa;
    }

    public List<EnderecoPessoa> getListEnderecoPessoa() {
        return listEnderecoPessoa;
    }

    public void setListEnderecoPessoa(List<EnderecoPessoa> listEnderecoPessoa) {
        this.listEnderecoPessoa = listEnderecoPessoa;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

}
