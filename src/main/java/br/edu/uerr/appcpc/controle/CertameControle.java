/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.controle;

import br.edu.uerr.appcpc.modelo.Certame;
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
public class CertameControle extends AbstractControle implements Serializable{
    
    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(Certame entity) throws Exception {
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

    public void remove(Certame entity) throws Exception {
        try {
            Certame aux = entityManager.find(Certame.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public Certame pegaCertameId(Integer id) throws Exception {
        try {
            Certame aux = entityManager.find(Certame.class, id);
            return aux;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }
    
    public Certame pegaCertamePeloCpf(String cpf) throws Exception{
        try {
            String sql = "select * from certame where cpf='" + cpf + "'";
            Query query = entityManager.createNativeQuery(sql,Certame.class);
            query.setParameter("cpf", cpf);
            
            return (Certame) query.getSingleResult();
         } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }
    }

    public List<Certame> findAll() throws Exception {
        try {
            List<Certame> listaCertame = new ArrayList<>();
            String sql = "select * from certame";
            listaCertame = executaSqlNativo(sql, Certame.class, entityManager);
            return listaCertame;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

}
