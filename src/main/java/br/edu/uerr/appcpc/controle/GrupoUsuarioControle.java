/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.controle;

import br.edu.uerr.appcpc.modelo.GrupoUsuario;
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
public class GrupoUsuarioControle extends AbstractControle implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(GrupoUsuario entity) throws Exception {
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

    public void remove(GrupoUsuario entity) throws Exception {
        try {
            GrupoUsuario aux = entityManager.find(GrupoUsuario.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public GrupoUsuario pegaGrupoUsuarioId(Integer id) throws Exception {
        try {
            GrupoUsuario aux = entityManager.find(GrupoUsuario.class, id);
            return aux;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

    public GrupoUsuario pegaGrupoUsuarioPeloCpf(String vnomeUsuario) throws Exception {
        try {
            String sql = "select * from grupo_usuario where nome_usuario='" + vnomeUsuario + "'";
            Query query = entityManager.createNativeQuery(sql, GrupoUsuario.class);
            query.setParameter("vnomeUsuario", vnomeUsuario);

            return (GrupoUsuario) query.getSingleResult();
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }
    }

    public List<GrupoUsuario> findAll() throws Exception {
        try {
            List<GrupoUsuario> listaGrupoUsuario = new ArrayList<>();
            String sql = "select * from grupo_usuario";
            listaGrupoUsuario = executaSqlNativo(sql, GrupoUsuario.class, entityManager);
            return listaGrupoUsuario;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }
}
