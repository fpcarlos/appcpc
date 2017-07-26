/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.controle;

import br.edu.uerr.appcpc.modelo.TipoAtendimentoEspecial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fpcarlos
 */
@Stateless
public class TipoAtendimentoEspecialControle extends AbstractControle implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(TipoAtendimentoEspecial entity) throws Exception {
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

    public void remove(TipoAtendimentoEspecial entity) throws Exception {
        try {
            TipoAtendimentoEspecial aux = entityManager.find(TipoAtendimentoEspecial.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public TipoAtendimentoEspecial pegaTipoAtendimentoEspecialId(Integer id) throws Exception {
        try {
            TipoAtendimentoEspecial aux = entityManager.find(TipoAtendimentoEspecial.class, id);
            return aux;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

    
    public List<TipoAtendimentoEspecial> findAll() throws Exception {
        try {
            List<TipoAtendimentoEspecial> listaTipoAtendimentoEspecial = new ArrayList<>();
            String sql = "select * from tipo_atenddimento_especial";
            listaTipoAtendimentoEspecial = executaSqlNativo(sql, TipoAtendimentoEspecial.class, entityManager);
            return listaTipoAtendimentoEspecial;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }
}
