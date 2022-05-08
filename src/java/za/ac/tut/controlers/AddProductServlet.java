 
package za.ac.tut.controlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.client.Client;
import za.ac.tut.client.ClientFacadeLocal;
import za.ac.tut.product.Product;

 
public class AddProductServlet extends HttpServlet {

    @EJB
    private ClientFacadeLocal clientFacade;

    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
         String[] id  =  request.getParameterValues("productId");
         String[] name = request.getParameterValues("productName");
         String[] quantity = request.getParameterValues("quantity");
         
         List <Product>products = generateProducts( id, name,  quantity);
         
        int clientId = (Integer)session.getAttribute("clientId");
         
         Client client=clientFacade.findClient(clientId);
        // if client want to add products again (after) after the 1st time 
         if(client.getProducts()!=null){
             
         List <Product>OldProducts=client.getProducts();
         
             for(int i=0; i<products.size();i++){
             
             OldProducts.add(products.get(i));
             }
             
             client.setProducts(OldProducts);
         
         }else{
         
           client.setProducts(products);
         
         }
         
         clientFacade.editClient(client);
         
         RequestDispatcher disp = request.getRequestDispatcher("menu.html");
        disp.forward(request, response);
        
         
    }
    
    
    
    
    
    public List<Product>  generateProducts(String[] id,String[] name, String[] quantity){
    
       List<Product> products = new ArrayList<>(); 
       Product product = new Product();
       
       for(int i=0; i<id.length;i++){
       
           product.setId(Long.parseLong(id[i]));
           product.setName(name[i]);
           product.setQuantity(Integer.parseInt(quantity[i]));
           
           products.add(product);
           
       }
        return products;
    }
 

}
