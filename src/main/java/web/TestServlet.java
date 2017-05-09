package web;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ObjectAddress;
import model.ObjectAddressKey;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		
		ObjectAddress objectAddress = new ObjectAddress(); 
		
		ObjectAddressKey addressKey = new ObjectAddressKey();

		em.getTransaction().begin();
		
		addressKey.setObjectId(1);
		addressKey.setObjectType("COMPANY");
		objectAddress.setAddressKey(addressKey);
		objectAddress.setFirstName("Tejas");
		objectAddress.setLastName("Patel");
		em.persist(objectAddress);
		
		
		addressKey.setObjectId(2);
		addressKey.setObjectType("COMPANY");
		objectAddress.setAddressKey(addressKey);
		objectAddress.setFirstName("Ripal");
		objectAddress.setLastName("Patel");
		em.persist(objectAddress);
		
		addressKey.setObjectId(3);
		addressKey.setObjectType("COMPANY");
		objectAddress.setAddressKey(addressKey);
		objectAddress.setFirstName("Dhaval");
		objectAddress.setLastName("Patel");			
		em.persist(objectAddress);
		
		em.getTransaction().commit();
		
		
		Query query = em.createQuery( "Select e " + "from OBJECTADDRESS e " );
	      
	    List<ObjectAddress> objectAddressList = (List<ObjectAddress>)query.getResultList( );
		
	    for( ObjectAddress oAddr:objectAddressList ){
	    	System.out.println("First Name:" + oAddr.getFirstName());
	    }
	    
		em.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
