/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.controle;

import br.edu.uerr.appcpc.modelo.Pessoa;
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
public class PessoaControle extends AbstractControle implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(Pessoa entity) throws Exception {
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

    public void remove(Pessoa entity) throws Exception {
        try {
            Pessoa aux = entityManager.find(Pessoa.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public Pessoa pegaPessoaId(Integer id) throws Exception {
        try {
            Pessoa aux = entityManager.find(Pessoa.class, id);
            return aux;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

    public Pessoa pegaPessoaPeloCpf(String cpf) throws Exception {
        try {
            String sql = "select * from pessoa where cpf='" + cpf + "' ";
            Query query = entityManager.createNativeQuery(sql, Pessoa.class);
            query.setParameter("cpf", cpf);

            Object result = query.getSingleResult();
            if (result == null) {
                return null;
            }
            return (Pessoa) result;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }
    }

    public List<Pessoa> findAll() throws Exception {
        try {
            List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "select * from pessoa";
            listaPessoa = executaSqlNativo(sql, Pessoa.class, entityManager);
            return listaPessoa;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

    public List<Pessoa> findAllSexo(String s) throws Exception {
        try {
            List<Pessoa> listaPessoaSexo = new ArrayList<>();
            String sql = "select * from pessoa where sexo= '" + s + "'";
            listaPessoaSexo = executaSqlNativo(sql, Pessoa.class, entityManager);
            return listaPessoaSexo;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

    public Pessoa pegaCandidatoPeloCpfSenha(String cpf, String senha) throws Exception {
        try {
            String sql = "select * from pessoa where cpf='" + cpf + "' and senha=md5('" + senha + "') ";
            System.out.println(sql);
            Query query = entityManager.createNativeQuery(sql, Pessoa.class);
            query.setParameter("cpf", cpf);
            query.setParameter("senha", senha);
            Object result = query.getSingleResult();
            if (result == null) {
                return null;
            }
            return (Pessoa) result;
            //return (Candidato) query.getSingleResult();
        } catch (RuntimeException re) {
            throw new Exception(" Erro Candidato não Localizado: " + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }
    }

}
