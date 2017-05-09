package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.ObjectAddress;
import model.ObjectAddressKey;

public class JPATest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

}
