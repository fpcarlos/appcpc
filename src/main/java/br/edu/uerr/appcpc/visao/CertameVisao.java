/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.visao;

import br.edu.uerr.appcpc.controle.CertameControle;
import br.edu.uerr.appcpc.modelo.Certame;
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
public class CertameVisao extends AbstractVisao implements Serializable{
    @EJB
    private CertameControle certameControle;
    
    private Certame certame;
    
    private List<Certame> listCertame = new ArrayList<>();
    
    public CertameVisao(){
        super();
    }

    
    public String abrirCadastro(){
        try {
           certame = new Certame(); 
           listCertame = new ArrayList<>();
           listCertame=certameControle.findAll();
            
        return redirect("/admin/certame/formCertame.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public void salvar(){
        try {
            certameControle.salvar(certame);
            showFacesMessage("salvo com sucesso!!!", 2);
            certame=new Certame();
            listCertame = new ArrayList<>();
            listCertame=certameControle.findAll();
           
        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
        }
    }
    
    public String editar(Certame aux){
        try {
            certame=certameControle.pegaCertameId(aux.getId());
            
        return redirect("/admin/certame/formCertame.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    
    
    
    
    public Certame getCertame() {
        return certame;
    }

    public void setCertame(Certame certame) {
        this.certame = certame;
    }

    public List<Certame> getListCertame() {
        return listCertame;
    }

    public void setListCertame(List<Certame> listCertame) {
        this.listCertame = listCertame;
    }
    
    
    
    
    
    
    
}
