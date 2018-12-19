package connect;

import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;


public class QuerySimpleData {
	//truy van co ban 
	  private void querys1()
	  { 		  
		   long start = System.currentTimeMillis();
		   String q = "MATCH (a:Person)"
	    			+ "RETURN a.nhan AS Nhan"
	    			+ " LIMIT 25";
		   System.out.println("25 person: " );
	        try (Session session = ConnectDataBase.connection.driver.session())
	        {
	            StatementResult result = session.run(q);
	            // Each Cypher execution returns a stream of records.
	            while (result.hasNext())
	            {
	                Record record = result.next();
	                System.out.println("-----");
	                 System.out.println("Tên: "+record.get("Nhan").asString());              
	            }
	            System.out.println("Time for query 1: " +(System.currentTimeMillis() - start)+" ms");
	            System.out.println("-------------------------------------------------------------");
	        }
	    }
	  private void querys2()
	  { 		  
		   long start = System.currentTimeMillis();
		   String q = "MATCH (a:Location)"
	    			+ "RETURN a.nhan AS Nhan"
	    			+ " LIMIT 25";
		   System.out.println("25 Location: " );
	        try (Session session = ConnectDataBase.connection.driver.session())
	        {
	            StatementResult result = session.run(q);
	            // Each Cypher execution returns a stream of records.
	            while (result.hasNext())
	            {
	                Record record = result.next();
	                System.out.println("-----");
	                 System.out.println("Tên: "+record.get("Nhan").asString());              
	            }
	            System.out.println("Time for query 2: " +(System.currentTimeMillis() - start)+" ms");
	            System.out.println("-------------------------------------------------------------");
	        }
	    }
	  private void querys3()
	  { 		  
		   long start = System.currentTimeMillis();
		   String q = "MATCH (a:Event)"
	    			+ "RETURN a.nhan AS Nhan"
	    			+ " LIMIT 25";
		   System.out.println("25 Location: " );
	        try (Session session = ConnectDataBase.connection.driver.session())
	        {
	            StatementResult result = session.run(q);
	            while (result.hasNext())
	            {
	                Record record = result.next();
	                System.out.println("-----");
	                 System.out.println("Tên: "+record.get("Nhan").asString());              
	            }
	            System.out.println("Time for query 3: " +(System.currentTimeMillis() - start)+" ms");
	            System.out.println("-------------------------------------------------------------");
	        }
	    }
	  private void querys4()
	  { 		  
		   long start = System.currentTimeMillis();
		   String q = "MATCH (a:Time)"
	    			+ "RETURN a.nhan AS Nhan"
	    			+ " LIMIT 10";
		   System.out.println("10 Time: " );
	        try (Session session = ConnectDataBase.connection.driver.session())
	        {
	            StatementResult result = session.run(q);
	            while (result.hasNext())
	            {
	                Record record = result.next();
	                System.out.println("-----");
	                 System.out.println("Tên: "+record.get("Nhan").asString());              
	            }
	            System.out.println("Time for query 4: " +(System.currentTimeMillis() - start)+" ms");
	            System.out.println("-------------------------------------------------------------");
	        }
	    }
	  private void querys5()
	  { 		  
		   long start = System.currentTimeMillis();
		   String q = "MATCH (a:Country)"
	    			+ "RETURN a.nhan AS Nhan, a.mota AS mmota"
	    			+ " LIMIT 10";
		   System.out.println("10 Country: " );
	        try (Session session = ConnectDataBase.connection.driver.session())
	        {
	            StatementResult result = session.run(q);
	            while (result.hasNext())
	            {
	                Record record = result.next();
	                System.out.println("-----");
	                 System.out.println("Tên: "+record.get("Nhan").asString()+": "+record.get("mota").asString());              
	            }
	            System.out.println("Time for query 5: " +(System.currentTimeMillis() - start)+" ms");
	            System.out.println("-------------------------------------------------------------");
	        }
	    }
	  private void querys6()
	  { 		  
		   long start = System.currentTimeMillis();
		   String q = "MATCH (e:Event)-[r:TO_CHUC_TAI_HO_THIEN_NGA]->(l:Location)"
	    			+ "RETURN e.nhan AS Nhan"
	    			+ " LIMIT 20";
		   System.out.println("Su kien to chuc Ho Thien Nga: " );
	        try (Session session = ConnectDataBase.connection.driver.session())
	        {
	            StatementResult result = session.run(q);
	            while (result.hasNext())
	            {
	                Record record = result.next();
	                System.out.println("-----");
	                 System.out.println(record.get("Nhan").asString());              
	            }
	            System.out.println("Time for query 6: " +(System.currentTimeMillis() - start)+" ms");
	            System.out.println("-------------------------------------------------------------");
	        }
	    }
	  private void querys7()
	  { 		  
		   long start = System.currentTimeMillis();
		   String q = "MATCH (p:Person)-[r:BELONG_VN]->(c:Country)"
	    			+ "RETURN p.nhan AS Nhan"
	    			+ " LIMIT 20";
		   System.out.println("La nguoi VN: " );
	        try (Session session = ConnectDataBase.connection.driver.session())
	        {
	            StatementResult result = session.run(q);
	            while (result.hasNext())
	            {
	                Record record = result.next();
	                System.out.println("-----");
	                 System.out.println(record.get("Nhan").asString());              
	            }
	            System.out.println("Time for query 7: " +(System.currentTimeMillis() - start)+" ms");
	            System.out.println("-------------------------------------------------------------");
	        }
	    }
	     public void queryall() {
	      QuerySimpleData query = new QuerySimpleData();
		  query.querys1(); 
		  query.querys2();
		  query.querys3();
		  query.querys4();
		  query.querys5();
		  query.querys6();
		  query.querys7();
	  }
}
