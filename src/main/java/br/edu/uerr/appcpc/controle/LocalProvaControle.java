/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.controle;

import br.edu.uerr.appcpc.modelo.LocalProva;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author fpcarlos
 */
@Stateless
public class LocalProvaControle extends AbstractControle implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(LocalProva entity) throws Exception {
        try {
            if (entity.getId() != null && entity.getId() > 0) {
                entityManager.merge(entity);
            } else {
                entityManager.persist(entity);
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public void remove(LocalProva entity) throws Exception {
        try {
            LocalProva aux = entityManager.find(LocalProva.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public LocalProva pegaLocalProvaId(Integer id) throws Exception {
        try {
            LocalProva aux = entityManager.find(LocalProva.class, id);
            return aux;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

    
    public List<LocalProva> findAll() throws Exception {
        try {
            List<LocalProva> listaLocalProva = new ArrayList<>();
            String sql = "select * from local_prova";
            listaLocalProva = executaSqlNativo(sql, LocalProva.class, entityManager);
            return listaLocalProva;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }
}
