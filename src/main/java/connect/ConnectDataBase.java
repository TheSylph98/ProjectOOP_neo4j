package connect;

import java.util.*;  
import org.neo4j.driver.v1.*;

import data.CreateEntityAll;
import data.CreateLocation;
import data.CreatePerson;
import data.CreateRelation;

public class ConnectDataBase {
	Driver driver;
	List<String> list=new ArrayList<String>();  
	public final static ConnectDataBase connection = new ConnectDataBase("bolt://localhost:11007", "neo4j", "123456789");
	
	public ConnectDataBase(String uri, String user, String password)
	    {
	        driver =  GraphDatabase.driver(uri, AuthTokens.basic(user, password));
	    }
	
	  // tao thuc the
	    public void createEntity(List<String> list) {	    	
	    	 String query = "CREATE " + String.join(", ", list);
	        try (Session session = driver.session())
	        {	            
	            try (Transaction tx = session.beginTransaction())
	            {
	                tx.run(query);
	                tx.success(); 
	            }
	        }
	    }
	    // tao quan he 
	    public void CreateRel(String rel) {
		try {
			try (Session session = driver.session())
	        {	            
	            try (Transaction tx = session.beginTransaction())
	            {
	                tx.run(rel);
	                tx.success(); 
	            }
	        }
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
	    }
		}
	   
	    public void close()
	    {
	        // Closing a driver immediately shuts down all open connections.
	        driver.close();
	    }
	    
	    public static void main( String[] args ) {
	   
    			ConnectDataBase connect = new ConnectDataBase("bolt://localhost:11007", "neo4j", "123456789");
    			QueryData query = new QueryData();
    			QuerySimpleData querysimple = new QuerySimpleData();
    		//	CreateEntityAll entity= new  CreateEntityAll();
    		 //  	 entity.CreateEntityA(1,1,1,1,1,1);
    			querysimple.queryall();
    		//	query.queryall();
    		//	CreateRelation rel = new CreateRelation();
    		//	rel.CreateRelationship();
    			connect.close();
	    }	
}
