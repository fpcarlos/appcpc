/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.controle;

import br.edu.uerr.appcpc.modelo.TipoArquivo;
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
public class TipoArquivoControle extends AbstractControle implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(TipoArquivo entity) throws Exception {
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

    public void remove(TipoArquivo entity) throws Exception {
        try {
            TipoArquivo aux = entityManager.find(TipoArquivo.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public TipoArquivo pegaTipoArquivoId(Integer id) throws Exception {
        try {
            TipoArquivo aux = entityManager.find(TipoArquivo.class, id);
            return aux;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

    public List<TipoArquivo> findAll() throws Exception {
        try {
            List<TipoArquivo> listaTipoArquivo = new ArrayList<>();
            String sql = "select * from tipo_arquivo";
            listaTipoArquivo = executaSqlNativo(sql, TipoArquivo.class, entityManager);
            return listaTipoArquivo;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }
}
