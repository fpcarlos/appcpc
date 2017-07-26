/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.controle;


import br.edu.uerr.appcpc.modelo.ArquivoRequerimento;
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
public class ArquivoRequerimentoControle extends AbstractControle implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(ArquivoRequerimento entity) throws Exception{
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
    
    
    public void remover(ArquivoRequerimento entity) throws Exception{
        try {
            ArquivoRequerimento aux = entityManager.find(ArquivoRequerimento.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    
    public ArquivoRequerimento pegaCargoId(Integer id) throws Exception {
        try {
            ArquivoRequerimento aux = entityManager.find(ArquivoRequerimento.class, id);
            return aux;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }
    
    public List<ArquivoRequerimento> findAll() throws Exception {
        try {
            List<ArquivoRequerimento> listaArquivoRequerimento = new ArrayList<>();
            String sql = "select * from arquivo_requerimento";
            listaArquivoRequerimento = executaSqlNativo(sql, ArquivoRequerimento.class, entityManager);
            return listaArquivoRequerimento;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }
    
}
