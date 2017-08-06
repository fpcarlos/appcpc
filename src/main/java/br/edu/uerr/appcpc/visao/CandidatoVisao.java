/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.visao;

import br.edu.uerr.appcpc.controle.PessoaControle;
import br.edu.uerr.appcpc.modelo.Pessoa;
import br.edu.uerr.appcpc.util.UtilSession;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fpcarlos
 */
@Named
@SessionScoped
public class CandidatoVisao extends AbstractVisao implements Serializable {

    @EJB
    private PessoaControle pessoaControle;

    private Pessoa pessoa;

    public CandidatoVisao() {
    }

    public String abrirDadosPerfil() {
        try {
            pessoa = new Pessoa();
            HttpSession session = UtilSession.getSession();
            Integer aux = Integer.parseInt(session.getAttribute("userid").toString());

            pessoa = pessoaControle.pegaPessoaId(aux);
            return redirect("/sistema/usuario/formPessoa.xhtml");
        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            return null;
        }
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
