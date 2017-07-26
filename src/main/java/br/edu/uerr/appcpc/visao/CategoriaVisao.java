/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.visao;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author fpcarlos
 */
@Named
@SessionScoped
public class CategoriaVisao extends AbstractVisao implements Serializable{
    
    public CategoriaVisao(){
        super();
    }
    
    
    public String abrirCategoria() {
        try {
            return redirect("/publico/categoria.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
}
