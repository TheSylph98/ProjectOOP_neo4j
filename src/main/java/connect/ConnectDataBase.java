package connect;

import static org.neo4j.driver.v1.Values.parameters;
import org.neo4j.driver.v1.*;
import entity.Entity;
import entity.Country;
import entity.Event;
import entity.Location;
import entity.Organization;
import entity.Person;
import entity.Time;

public class ConnectDataBase {
	Driver driver;
	 
	 public ConnectDataBase(String uri, String user, String password)
	    {
	        driver =  GraphDatabase.driver(uri, AuthTokens.basic(user, password));
	    }
 // tao ham create Node
	    public void addPerson(Person p)
	    {
	        // Sessions are lightweight and disposable connection wrappers.
	        try (Session session = driver.session())
	        {
	            // Wrapping Cypher in an explicit transaction provides atomicity
	            // and makes handling errors much easier.
	            try (Transaction tx = session.beginTransaction())
	            {
	                tx.run("MERGE (a: Person{dinhdanh: $x,name: $y,mota: $z,link: $t,date: $u})", 
	                		parameters("x", p.getDinhDanh(), "y", p.getNhan(),"z",p.getMoTa(),"t",p.getLink(),"u",p.getNgayThang()));
	                tx.success();  // Mark this write as successful.
	            }
	        }
	    }
	    public void addLocation(Location p)
	    {
	        // Sessions are lightweight and disposable connection wrappers.
	        try (Session session = driver.session())
	        {
	            // Wrapping Cypher in an explicit transaction provides atomicity
	            // and makes handling errors much easier.
	            try (Transaction tx = session.beginTransaction())
	            {
	                tx.run("MERGE (a: Location{dinhdanh: $x,name: $y,mota: $z,link: $t,date: $u})", 
	                		parameters("x", p.getDinhDanh(), "y", p.getNhan(),"z",p.getMoTa(),"t",p.getLink(),"u",p.getNgayThang()));
	                tx.success();  
	            }
	        }
	    }
	    
	    public void addEvent(Event p)
	    {
	        // Sessions are lightweight and disposable connection wrappers.
	        try (Session session = driver.session())
	        {
	            // Wrapping Cypher in an explicit transaction provides atomicity
	            // and makes handling errors much easier.
	            try (Transaction tx = session.beginTransaction())
	            {
	                tx.run("MERGE (a: Event{dinhdanh: $x,name: $y,mota: $z,link: $t,date: $u})", 
	                		parameters("x", p.getDinhDanh(), "y", p.getNhan(),"z",p.getMoTa(),"t",p.getLink(),"u",p.getNgayThang()));
	                tx.success();  // Mark this write as successful.
	            }
	        }
	    }
	    
	    public void addCountry(Country p)
	    {
	        // Sessions are lightweight and disposable connection wrappers.
	        try (Session session = driver.session())
	        {
	            // Wrapping Cypher in an explicit transaction provides atomicity
	            // and makes handling errors much easier.
	            try (Transaction tx = session.beginTransaction())
	            {
	                tx.run("MERGE (a: Country{dinhdanh: $x,name: $y,mota: $z,link: $t,date: $u})", 
	                		parameters("x", p.getDinhDanh(), "y", p.getNhan(),"z",p.getMoTa(),"t",p.getLink(),"u",p.getNgayThang()));
	                tx.success();  // Mark this write as successful.
	            }
	        }
	    }
	    
	    public void addOrganization(Organization p)
	    {
	        // Sessions are lightweight and disposable connection wrappers.
	        try (Session session = driver.session())
	        {
	            // Wrapping Cypher in an explicit transaction provides atomicity
	            // and makes handling errors much easier.
	            try (Transaction tx = session.beginTransaction())
	            {
	                tx.run("MERGE (a: Organization{dinhdanh: $x,name: $y,mota: $z,link: $t,date: $u})", 
	                		parameters("x", p.getDinhDanh(), "y", p.getNhan(),"z",p.getMoTa(),"t",p.getLink(),"u",p.getNgayThang()));
	                tx.success();  // Mark this write as successful.
	            }
	        }
	    }
	    public void addTime(Time p)
	    {
	        // Sessions are lightweight and disposable connection wrappers.
	        try (Session session = driver.session())
	        {
	            // Wrapping Cypher in an explicit transaction provides atomicity
	            // and makes handling errors much easier.
	            try (Transaction tx = session.beginTransaction())
	            {
	                tx.run("MERGE (a: Time{dinhdanh: $x,name: $y,mota: $z,link: $t,date: $u})", 
	                		parameters("x", p.getDinhDanh(), "y", p.getNhan(),"z",p.getMoTa(),"t",p.getLink(),"u",p.getNgayThang()));
	                tx.success();  // Mark this write as successful.
	            }
	        }
	    }
	    // query
	    private void printPeople(String initial)
	    {
	        try (Session session = driver.session())
	        {
	            // Auto-commit transactions are a quick and easy way to wrap a read.
	            StatementResult result = session.run(
	                    "MATCH (a:Person) WHERE a.name STARTS WITH {x} RETURN a.name AS name",
	                    parameters("x", initial));
	            // Each Cypher execution returns a stream of records.
	            while (result.hasNext())
	            {
	                Record record = result.next();
	                // Values can be extracted from a record by index or name.
	                System.out.println(record.get("name").asString());
	            }
	        }
	    }

	    public void close()
	    {
	        // Closing a driver immediately shuts down all open connections.
	        driver.close();
	    }
	    
	    public static void main(String...args) {
	    	ConnectDataBase con =new ConnectDataBase("bolt://localhost:11007", "neo4j", "123456789");
	    	Person p= new Person("01","Dang Nhat Tan","...","http","...");
	    	con.addPerson(p);
	    	con.close();
	    }
	
}
