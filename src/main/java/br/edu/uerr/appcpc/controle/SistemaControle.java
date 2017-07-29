/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.controle;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fpcarlos
 */
@Stateless
public class SistemaControle extends AbstractControle implements Serializable {

    //@PersistenceContext(unitName = "appcpc")
    @PersistenceContext
    private EntityManager entityManager;

    public List<String> getTipoEscolaridade() {
        try {
            String sql = "select distinct escolaridade as id, escolaridade from pessoa order by 1";
            List<String>   listaEscolaridade = entityManager.createNativeQuery(sql).getResultList();

            return listaEscolaridade;
            
        } catch (Exception e) {
            throw e;
        }
    }

}
