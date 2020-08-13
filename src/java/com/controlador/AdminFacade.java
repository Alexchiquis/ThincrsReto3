/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.entidades.Admin;
import com.entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author alexc
 */
@Stateless
public class AdminFacade extends AbstractFacade<Admin> {

    @PersistenceContext(unitName = "prothincrsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
   public Admin loginAdmin(String id){
    Query bd=em.createNamedQuery("Admin.findById",Admin.class).setParameter("id", id);
    List <Admin> listaA = bd.getResultList();
    if(!listaA.isEmpty()){
        return listaA.get(0);
        
    }
    return null;
    
    }

    public AdminFacade() {
        super(Admin.class);
    }
    
}
