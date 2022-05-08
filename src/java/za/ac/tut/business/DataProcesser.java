 
package za.ac.tut.business;

import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import za.ac.tut.client.Client;
import za.ac.tut.client.ClientFacadeLocal;


 
@Stateless
public class DataProcesser implements DataProcesserLocal {

    @EJB
    private ClientFacadeLocal clientFacade;

    
    @Override
    public int generateUnitqueRandomId() {
        
        List<Client>clients = clientFacade.findAllClient();
        
        //genarate a normal random number
        int uniqueId = generateRandomNum();
        
       // check if there are other existing clients 
        if(clients.size()>0){
            
           // iterate through the Ids of all clients 
           for(int i=0; i<clients.size();i++){
        
               // while there are Ids that are equal 
              while(uniqueId == clients.get(i).getId()){
            
                //we generate another random number  
                uniqueId =generateRandomNum();
              }
            
            }
          }
       
        return uniqueId;
    }

    @Override
    public int generateRandomNum() {
      int maxSize=100;
      
      Random random= new Random();
      
      int num = random.nextInt(maxSize + 1 -1)+1;
        
      return num;
    }

    

    
    
}
