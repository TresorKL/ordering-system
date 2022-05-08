/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.product;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tresorkl
 */
@Local
public interface ProductFacadeLocal {
    
    void removeProduct(Product product);
    void addProduct(Product product);

    void create(Product product);
    
    

    void edit(Product product);

    void remove(Product product);

    Product find(Object id);

    List<Product> findAll();

    List<Product> findRange(int[] range);

    int count();
    
}
