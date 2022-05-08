/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.client;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tresorkl
 */
@Local
public interface ClientFacadeLocal {

    List<Client> findAllClient();
    
     void addClient(Client client);
     
     Client findClient(Object id);
     
     void editClient(Client client);
    
    void create(Client client);

    void edit(Client client);

    void remove(Client client);

    Client find(Object id);

    List<Client> findAll();

    List<Client> findRange(int[] range);

    int count();
    
}
