/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.controlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.address.Address;
import za.ac.tut.business.DataProcesserLocal;
import za.ac.tut.client.Client;
import za.ac.tut.client.ClientFacadeLocal;

/**
 *
 * @author tresorkl
 */
public class RegisterClientServlet extends HttpServlet {

    @EJB
    private ClientFacadeLocal clientFacade;

    @EJB
    private DataProcesserLocal dataProcesser;

   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        List<Client>clients = clientFacade.findAllClient();
        
        //client name
        String name = request.getParameter("userName");
        
        //client address
        Long addressId = Long.parseLong(request.getParameter("addressId"));
        String city = request.getParameter("city");
        String postalCode =  request.getParameter("postalCode");
        
        Address address = new Address();
        
        address.setId(addressId);
        address.setCity(city);
        address.setPostalCode(postalCode);
        
        // 
        
        Client client = new Client();
        
        client.setName(name);
        
        int clientId = dataProcesser.generateRandomNum();
        
        client.setId(clientId);
        
        client.setAddress(address);
        
        clientFacade.addClient(client);
        
        session.setAttribute("currentClient", client);
        
        session.setAttribute("clientId", clientId);
        
        RequestDispatcher disp = request.getRequestDispatcher("registration.jsp");
        disp.forward(request, response);
        
        
    }

    

}
