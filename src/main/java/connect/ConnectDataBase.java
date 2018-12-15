package connect;
import java.util.*;  
import static org.neo4j.driver.v1.Values.parameters;
import org.neo4j.driver.v1.*;
import entity.Country;
import entity.Event;
import entity.Location;
import entity.Organization;
import entity.Person;
import entity.Time;

public class ConnectDataBase {
	Driver driver;
	List<String> list=new ArrayList<String>();  
	
	 public ConnectDataBase(String uri, String user, String password)
	    {
	        driver =  GraphDatabase.driver(uri, AuthTokens.basic(user, password));
	    }
	    //
	    public void addPerson(List<String> list ,Person p) {
	    	 String s = "(:Person{dinhdanh: "+ p.getDinhDanh()
	                    + ",name: "+ p.getNhan()
	    			    + ",mota: "+p.getMoTa()
	    			    + ",ngaythang:"+p.getNgayThang()
	    			    + "})";
	         list.add(s);
	    }
	    //
	    public void addLocation(List<String> list ,Location p) {
	    	 String s = "(:Location{dinhdanh: "+ p.getDinhDanh()
	                    + ",name: "+ p.getNhan()
	    			    + ",mota: "+p.getMoTa()
	    			    + ",ngaythang:"+p.getNgayThang()
	    			    + "})";
	         list.add(s);
	    }
	    //
	    public void addEvent(List<String> list ,Event p) {
	    	 String s = "(:Event{dinhdanh: "+ p.getDinhDanh()
	                    + ",name: "+ p.getNhan()
	    			    + ",mota: "+p.getMoTa()
	    			    + ",ngaythang:"+p.getNgayThang()
	    			    + "})";
	         list.add(s);
	    }
	    //
	    public void addCountry(List<String> list ,Country p) {
	    	 String s = "(:Country{dinhdanh: "+ p.getDinhDanh()
	                    + ",name: "+ p.getNhan()
	    			    + ",mota: "+p.getMoTa()
	    			    + ",ngaythang:"+p.getNgayThang()
	    			    + "})";
	         list.add(s);
	    }
	    //
	    public void addOrganization(List<String> list ,Organization p) {
	    	 String s = "(:Organization{dinhdanh: "+ p.getDinhDanh()
	                    + ",name: "+ p.getNhan()
	    			    + ",mota: "+p.getMoTa()
	    			    + ",ngaythang:"+p.getNgayThang()
	    			    + "})";
	         list.add(s);
	    }
	    //
	    public void addTime(List<String> list ,Country p) {
	    	 String s = "(:Time{dinhdanh: "+ p.getDinhDanh()
	                    + ",name: "+ p.getNhan()
	    			    + ",mota: "+p.getMoTa()
	    			    + ",ngaythang:"+p.getNgayThang()
	    			    + "})";
	         list.add(s);
	    }
	    //
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
	    // query
	    public void query1()
	    {
	    	long start = System.currentTimeMillis();
	        try (Session session = driver.session())
	        {
	        	System.out.println("Query1:");
	            StatementResult result = session.run(
	                    "MATCH (a:Person) WHERE a.name STARTS WITH {x} RETURN a.name AS name",
	                    parameters("x","D" ));
	            // Each Cypher execution returns a stream of records.
	            while (result.hasNext())
	            {
	                Record record = result.next();
	                System.out.println(record.get("name").asString());
	            }
	            System.out.println("Time for query: " + (System.currentTimeMillis() - start));
	        }
	    }

	    public void close()
	    {
	        // Closing a driver immediately shuts down all open connections.
	        driver.close();
	    }
	    
	    public static void main(String...args) {
	    	ConnectDataBase con =new ConnectDataBase("bolt://localhost:11007", "neo4j", "123456789");
	    	Person p= new Person("01","Dang Nhat Ta","...","http","...");
	    	//con.addPerson(p);
	    	con.query1();
	    	con.close();
	    }	
}
