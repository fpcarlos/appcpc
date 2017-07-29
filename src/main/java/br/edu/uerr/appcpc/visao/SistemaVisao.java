/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.visao;

import br.edu.uerr.appcpc.controle.SistemaControle;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author fpcarlos
 */
@Startup
@Singleton
@Named("sistemaVisao")
public class SistemaVisao extends AbstractVisao implements Serializable {

    @EJB
    private SistemaControle sistemaControle;

    private List<String> tipoEscolaridadeList;
    private Map<String, String> tipoEscolaridadeMap = new HashMap<String, String>();

    @PostConstruct
    public void init() {
        try {
            getTipoEscolaridadeList();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String pegaContextoAplicacao() {
        String contextPath = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
        return contextPath + "/";
    }

    public List<String> getTipoEscolaridadeList() {
        try {
            if (tipoEscolaridadeList == null || tipoEscolaridadeList.size() < 1) {
                tipoEscolaridadeList = sistemaControle.getTipoEscolaridade();
                tipoEscolaridadeMap = new HashMap<String, String>();
                for (String x : tipoEscolaridadeList) {
                    tipoEscolaridadeMap.put(x.concat(x), x.concat(x));

                }

            }

            return tipoEscolaridadeList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setTipoEscolaridadeList(List<String> tipoEscolaridade) {
        this.tipoEscolaridadeList = tipoEscolaridadeList;
    }

    public Map<String, String> getTipoEscolaridadeMap() {
        return tipoEscolaridadeMap;
    }

    public void setTipoEscolaridadeMap(Map<String, String> tipoEscolaridadeMap) {
        this.tipoEscolaridadeMap = tipoEscolaridadeMap;
    }

}
