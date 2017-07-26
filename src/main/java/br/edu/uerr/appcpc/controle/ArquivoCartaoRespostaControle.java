/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.controle;

import br.edu.uerr.appcpc.modelo.ArquivoCartaoResposta;
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
public class ArquivoCartaoRespostaControle extends AbstractControle implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(ArquivoCartaoResposta entity) throws Exception{
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
    
    
    public void remover(ArquivoCartaoResposta entity) throws Exception{
        try {
            ArquivoCartaoResposta aux = entityManager.find(ArquivoCartaoResposta.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    
    public ArquivoCartaoResposta pegaCargoId(Integer id) throws Exception {
        try {
            ArquivoCartaoResposta aux = entityManager.find(ArquivoCartaoResposta.class, id);
            return aux;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }
    
    public List<ArquivoCartaoResposta> findAll() throws Exception {
        try {
            List<ArquivoCartaoResposta> listaArquivoCartaoResposta = new ArrayList<>();
            String sql = "select * from arquivo_cartao_resposta";
            listaArquivoCartaoResposta = executaSqlNativo(sql, ArquivoCartaoResposta.class, entityManager);
            return listaArquivoCartaoResposta;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }
    
}
