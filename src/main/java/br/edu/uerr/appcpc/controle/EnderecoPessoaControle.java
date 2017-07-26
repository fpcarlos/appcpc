/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.controle;

import br.edu.uerr.appcpc.modelo.EnderecoPessoa;
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
public class EnderecoPessoaControle extends AbstractControle implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(EnderecoPessoa entity) throws Exception {
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

    public EnderecoPessoa pegaEnderecoPessoaPeloId(Integer id) throws Exception {
        try {
            EnderecoPessoa aux = entityManager.find(EnderecoPessoa.class, id);
            return aux;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<EnderecoPessoa> findAll() throws Exception {
        try {
            List<EnderecoPessoa> listaEnderecoPessoa = new ArrayList<>();
            String sql = "select * from endereco_pessoa";
            listaEnderecoPessoa = executaSqlNativo(sql, EnderecoPessoa.class, entityManager);
            return listaEnderecoPessoa;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

    public List<EnderecoPessoa> findAllPeloIdPessoa(Integer id) throws Exception {
        try {
            List<EnderecoPessoa> listaEnderecoPessoa = new ArrayList<>();
            String sql = "select * from endereco_pessoa where id_pessoa='" + id + "'";
            listaEnderecoPessoa = executaSqlNativo(sql, EnderecoPessoa.class, entityManager);
            return listaEnderecoPessoa;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

}
