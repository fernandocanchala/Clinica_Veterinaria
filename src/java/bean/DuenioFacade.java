/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Duenio;

/**
 *
 * @author FERNANDO
 */
@Stateless
public class DuenioFacade extends AbstractFacade<Duenio> {
    @PersistenceContext(unitName = "VeterinariaOrgPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DuenioFacade() {
        super(Duenio.class);
    }
    
}
