/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.controle;

import br.edu.uerr.appcpc.modelo.SituacaoInscricao;
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
public class SituacaoInscricaoControle extends AbstractControle implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(SituacaoInscricao entity) throws Exception {
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

    public void remove(SituacaoInscricao entity) throws Exception {
        try {
            SituacaoInscricao aux = entityManager.find(SituacaoInscricao.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public SituacaoInscricao pegaSituacaoInscricaoId(Integer id) throws Exception {
        try {
            SituacaoInscricao aux = entityManager.find(SituacaoInscricao.class, id);
            return aux;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

    public List<SituacaoInscricao> findAll() throws Exception {
        try {
            List<SituacaoInscricao> listaSituacaoInscricao = new ArrayList<>();
            String sql = "select * from situacao_inscricao";
            listaSituacaoInscricao = executaSqlNativo(sql, SituacaoInscricao.class, entityManager);
            return listaSituacaoInscricao;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }
}
