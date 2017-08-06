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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fpcarlos
 */
@Named
@SessionScoped
public class LoginVisao extends AbstractVisao implements Serializable {

    @EJB
    private PessoaControle pessoaControle;

    private Pessoa pessoa;

    private String usuario = "";
    private String senha = "";

    public LoginVisao() {
        super();
    }

    public String abreLogin() {
        try {

            return redirect("/login.xhtml");
        } catch (Exception e) {
            //showFacesMessage(e.getMessage(), 4);
            return null;
        }
    }

    public String testaLogin() {

        System.out.println("Entrando com ologin");

        try {
            
            pessoa = pessoaControle.pegaCandidatoPeloCpfSenha(usuario, senha);
            //System.out.println(usuario + " " + senha);

            if (pessoa != null) {               
                HttpSession session = UtilSession.getSession();
                session.setAttribute("username", usuario);
                return redirect("/sistema/index.xhtml");
            }
            FacesContext ctx = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário inválido", "Usuário inválido");
            ctx.addMessage(null, msg);
            //return "";  
            return redirect("/index.xhtml");
        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            return null;
        }
    }
    
    

    public String logout() {
        HttpSession session = UtilSession.getSession();
        session.invalidate();
        return redirect("/index.xhtml");
    }
    //gets e sets

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
