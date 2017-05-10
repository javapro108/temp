package web;

import javax.persistence.Persistence;

import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;



public class ODataJPAServiceFactoryImpl extends ODataJPAServiceFactory {
	
	private static final String PUNIT_NAME = "test";
	
	@Override
	public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException {
		ODataJPAContext oDataJPAContext = getODataJPAContext();
		oDataJPAContext.setEntityManagerFactory(Persistence.createEntityManagerFactory("test"));
		oDataJPAContext.setPersistenceUnitName(PUNIT_NAME);	
		return oDataJPAContext;
	}
 
}
