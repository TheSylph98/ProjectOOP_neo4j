package connect;

import static org.neo4j.driver.v1.Values.parameters;

import org.neo4j.driver.v1.*;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

public class QueryData {
	Driver driver;
	// long start = System.currentTimeMillis();
	//query1
	//truy van thong ke
	  public void query1()
	    {
		   long start = System.currentTimeMillis();
	        try (Session session = driver.session())
	        {
	            StatementResult result = session.run(
	                    "MATCH (a:Person) WHERE a.name STARTS WITH {x} RETURN a.name AS name",
	                    parameters("x","N" ));
	            // Each Cypher execution returns a stream of records.
	            while (result.hasNext())
	            {
	                Record record = result.next();
	                System.out.println(record.get("name").asString());                
	            }
	            System.out.println("Time for query: " + (System.currentTimeMillis() - start));
	        }
	    }
	  //query 2
	  public void query2()
	    {
		   long start = System.currentTimeMillis();
		   String s="Da Nang";
	        try (Session session = driver.session())
	        {
	            StatementResult result = session.run(
	                    "MATCH (a:Location) WHERE a.name="+s+" RETURN a.name "
	                    );
	            // Each Cypher execution returns a stream of records.
	            while (result.hasNext())
	            {
	                Record record = result.next();
	             //   System.out.println(record.get("name").asString());
	                System.out.println("Time for query: " + (System.currentTimeMillis() - start));
	            }
	        }
	    }
}
