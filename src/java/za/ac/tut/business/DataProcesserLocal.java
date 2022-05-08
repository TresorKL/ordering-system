 
package za.ac.tut.business;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.client.Client;

 
@Local
public interface DataProcesserLocal {
    
    public int generateUnitqueRandomId();
    
    public int generateRandomNum();
}
