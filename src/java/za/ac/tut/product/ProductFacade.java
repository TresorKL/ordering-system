/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author tresorkl
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> implements ProductFacadeLocal {

    @PersistenceContext(unitName = "OrderSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }

    @Override
    public void removeProduct(Product product) {
        
        String query = "DELETE FROM JND_CLIENT_PRODUCT WHERE PRODUCT_FK =";
        
        query+=product.getId();
        
        Query q = em.createNamedQuery(query);
        
        int removed = q.executeUpdate();
        
        remove(product);
    }

    @Override
    public void addProduct(Product product) {
       create(product);
    }
    
}
