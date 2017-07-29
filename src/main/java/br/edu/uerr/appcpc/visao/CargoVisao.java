/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.visao;

import br.edu.uerr.appcpc.controle.CargoControle;
import br.edu.uerr.appcpc.controle.CertameControle;
import br.edu.uerr.appcpc.controle.StatusControle;
import br.edu.uerr.appcpc.controle.TipoVagaControle;
import br.edu.uerr.appcpc.modelo.Cargo;
import br.edu.uerr.appcpc.modelo.Certame;
import br.edu.uerr.appcpc.modelo.Status;
import br.edu.uerr.appcpc.modelo.TipoVaga;
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
public class CargoVisao extends AbstractVisao implements Serializable{
    @EJB
    private CargoControle cargoControle;
    
    @EJB
    private CertameControle certameControle;
    
    @EJB
    private TipoVagaControle tipoVagaControle;
    
    @EJB
    private StatusControle statusControle;
    
    private List<Certame> listCertame = new ArrayList<>();
    
    private List<TipoVaga> listTipoVaga = new ArrayList<>();
    
    private List<Status> listStatus = new ArrayList<>();
        
    
    private Cargo cargo;
    
    private List<Cargo> listCargo = new ArrayList<>();
    
    public CargoVisao(){
        super();
    }

    
    public String abrirCadastro(){
        try {
           cargo = new Cargo(); 
           listCargo = new ArrayList<>();
           listCargo=cargoControle.findAll();
           listCertame = new ArrayList<>();
           listCertame = certameControle.findAll();
           listTipoVaga = new ArrayList<>();
           listTipoVaga = tipoVagaControle.findAll();
           listStatus = new ArrayList<>();
           listStatus = statusControle.findAll();
            
        return redirect("/admin/certame/formCargo.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public void salvar(){
        try {
            cargoControle.salvar(cargo);
            showFacesMessage("salvo com sucesso!!!", 2);
            cargo=new Cargo();
            listCargo = new ArrayList<>();
            listCargo=cargoControle.findAll();
           
        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
        }
    }
    
    public String editar(Cargo aux){
        try {
            cargo=cargoControle.pegaCargoId(aux.getId());
            
        return redirect("/admin/certame/formCargo.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    
    
    
    
    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Cargo> getListCargo() {
        return listCargo;
    }

    public void setListCargo(List<Cargo> listCargo) {
        this.listCargo = listCargo;
    }

    public List<Certame> getListCertame() {
        return listCertame;
    }

    public void setListCertame(List<Certame> listCertame) {
        this.listCertame = listCertame;
    }

    public List<TipoVaga> getListTipoVaga() {
        return listTipoVaga;
    }

    public void setListTipoVaga(List<TipoVaga> listTipoVaga) {
        this.listTipoVaga = listTipoVaga;
    }

    public List<Status> getListStatus() {
        return listStatus;
    }

    public void setListStatus(List<Status> listStatus) {
        this.listStatus = listStatus;
    }
    
    
    
    
    
    
    
}
