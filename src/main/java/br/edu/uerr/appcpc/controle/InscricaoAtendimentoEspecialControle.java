/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.controle;

import br.edu.uerr.appcpc.modelo.InscricaoAtendimentoEspecial;
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
public class InscricaoAtendimentoEspecialControle extends AbstractControle implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(InscricaoAtendimentoEspecial entity) throws Exception {
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

    public void remove(InscricaoAtendimentoEspecial entity) throws Exception {
        try {
            InscricaoAtendimentoEspecial aux = entityManager.find(InscricaoAtendimentoEspecial.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public InscricaoAtendimentoEspecial pegaInscricaoAtendimentoEspecialId(Integer id) throws Exception {
        try {
            InscricaoAtendimentoEspecial aux = entityManager.find(InscricaoAtendimentoEspecial.class, id);
            return aux;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

    public List<InscricaoAtendimentoEspecial> findAll() throws Exception {
        try {
            List<InscricaoAtendimentoEspecial> listaInscricaoAtendimentoEspecial = new ArrayList<>();
            String sql = "select * from inscricao_atendimento_especial";
            listaInscricaoAtendimentoEspecial = executaSqlNativo(sql, InscricaoAtendimentoEspecial.class, entityManager);
            return listaInscricaoAtendimentoEspecial;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }
}
