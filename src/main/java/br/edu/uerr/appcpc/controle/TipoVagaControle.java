/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.controle;

import br.edu.uerr.appcpc.modelo.TipoVaga;
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
public class TipoVagaControle extends AbstractControle implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(TipoVaga entity) throws Exception {
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

    public void remove(TipoVaga entity) throws Exception {
        try {
            TipoVaga aux = entityManager.find(TipoVaga.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public TipoVaga pegaTipoVagaId(Integer id) throws Exception {
        try {
            TipoVaga aux = entityManager.find(TipoVaga.class, id);
            return aux;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

    public TipoVaga pegaTipoVagaPeloCpf(String cpf) throws Exception {
        try {
            String sql = "select * from cargo where cpf='" + cpf + "'";
            Query query = entityManager.createNativeQuery(sql, TipoVaga.class);
            query.setParameter("cpf", cpf);

            return (TipoVaga) query.getSingleResult();
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }
    }

    public List<TipoVaga> findAll() throws Exception {
        try {
            List<TipoVaga> listaTipoVaga = new ArrayList<>();
            String sql = "select * from cargo";
            listaTipoVaga = executaSqlNativo(sql, TipoVaga.class, entityManager);
            return listaTipoVaga;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }
}
