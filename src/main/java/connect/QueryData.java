package connect;

import static org.neo4j.driver.v1.Values.parameters;


import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

//truy van thong ke
public class QueryData {
	//query1
	 public void query1()
	 {
		   long start = System.currentTimeMillis();
	        try (Session session = ConnectDataBase.connection.driver.session())
	        {
	            StatementResult result = session.run(
	                    "MATCH (a:Person) WHERE a.name STARTS WITH {x}  RETURN a.name AS name",
	                    parameters("x","H" ));
	            // Each Cypher execution returns a stream of records.
	            while (result.hasNext())
	            {
	                Record record = result.next();
	                System.out.println(record.get("name").asString());                
	            }
	            System.out.println("Time for query 1: " +(System.currentTimeMillis() - start)+"ms");
	        }
	    }
	 // 
	 private void query2(String Ho)
	 { 		  
		   long start = System.currentTimeMillis();
		   String q = "MATCH (e:Person) WHERE e.nhan CONTAINS {Ho} OR e.dinhdanh CONTAINS {Ho} OR e.mota CONTAINS {Ho} OR e.ngaythang CONTAINS {Ho} "
	    			+ "RETURN e.nhan AS Nhan";
		   System.out.println("Người có thông tin trên là "+ Ho +":");
	        try (Session session = ConnectDataBase.connection.driver.session())
	        {
	            StatementResult result = session.run(q,parameters("Ho", Ho));
	            // Each Cypher execution returns a stream of records.
	            while (result.hasNext())
	            {
	                Record record = result.next();
	                System.out.println("-----");
	                 System.out.println("Tên: "+record.get("Nhan").asString());              
	            }
	            System.out.println("Time for query 2: " +(System.currentTimeMillis() - start)+" ms");
	        }
	    }
	 //
	 private  void  query3 (String name) {
		  long start = System.currentTimeMillis();
		   String q = "MATCH (p:Person) WHERE p.name= {name} "
	    			+ "RETURN p.mota AS mota , p.nhan AS nhan  ";
		   System.out.println(name +" có mô tả : ");
	        try (Session session = ConnectDataBase.connection.driver.session())
	        {
	            StatementResult result = session.run(q,parameters("name", name));
	            while (result.hasNext())
	            {
	                Record record = result.next();
	                 System.out.println("Tên : "+ record.get("nhan").asString()+" la: "+record.get("mota").asString());     
	                 System.out.println("-----");
	            }
	            System.out.println("Time for query 3: " +(System.currentTimeMillis() - start)+" ms");
	        } 
	 }
	 //
	 private  void query4(String link) {
		    System.out.println("Những thực thể đề cập đến bài viết trong của link "+link+" là:");
		    long start = System.currentTimeMillis();
	    	String q = "MATCH (per:Person) WHERE per.link = {link}\n" + 
	    			"MATCH (Org:Organization) WHERE Org.link = {link}\n" + 
	    			"MATCH (loca:Location) WHERE loca.link = {link}\n" + 
	    			"MATCH (event:Event) WHERE event.link = {link}\n" + 
	    			"MATCH (country:Country) WHERE country.link = {link}\n" + 
	    			"MATCH (time:Time) WHERE time.link = {link}\n" + 
	    			"WITH DISTINCT per, Org, loca, event,country, time \n" + 
	    			"RETURN per.nhan AS perNhan, Org.nhan AS OrgNhan, loca.nhan AS locaNhan,\n" + 
	    			"event.nhan AS eventNhan, country.nhan AS countryNhan, time.nhan AS timeNhan LIMIT 5\n";
	        try (Session session = ConnectDataBase.connection.driver.session())
	        {
	            StatementResult result = session.run(q,parameters("link", link));
	            while (result.hasNext())
	            {
	                Record record = result.next();
	                 if(record.get("perNhan").asString() != "null") System.out.println("Person: "+record.get("perNhan").asString());
	                 if(record.get("OrgNhan").asString() != "null") System.out.println("Organization: "+record.get("OrgNhan").asString());
	                 if(record.get("locaNhan").asString() != "null") System.out.println("location: "+record.get("locaNhan").asString());
	                 if(record.get("eventNhan").asString() != "null") System.out.println("Event: "+record.get("eventNhan").asString());
	                 if(record.get("countryNhan").asString() != "null") System.out.println("Country: "+record.get("countryNhan").asString());
	                 if(record.get("timeNhan").asString() != "null") System.out.println("Time: "+record.get("timeNhan").asString());
	                 System.out.println("----");
	            }
	            System.out.println("Time for query 4: " +(System.currentTimeMillis() - start)+" ms");
	        } 
	 }
	 //
	 private  void  query5 (String local) {
		  long start = System.currentTimeMillis();
		   String q = "MATCH (p:Person)-[:LIVE]->(l:Location) WHERE l.nhan= {local} "
	    			+ "RETURN p.nhan AS pnhan  ";
		   System.out.println( local +" : ");
	        try (Session session = ConnectDataBase.connection.driver.session())
	        {
	            StatementResult result = session.run(q,parameters("local", local));
	            while (result.hasNext())
	            {
	                Record record = result.next();
	                 System.out.println(record.get("pnhan").asString());     
	                 System.out.println("-----");
	            }
	            System.out.println("Time for query 5: " +(System.currentTimeMillis() - start)+" ms");
	        } 
	 }
	// 
	 private void  query6 (String name) {
		  long start = System.currentTimeMillis();
		   String q = "MATCH (p:Person)-[:LIKE]->(q1:Person) WHERE q.name = {name} "
		   		    + " WITH DISTINCT q1"
	    			+ " RETURN p1.nhan AS pnhan  ";
		   System.out.println( "Nhung nguoi cung nam voi "+name+": ");
	        try (Session session = ConnectDataBase.connection.driver.session())
	        {
	            StatementResult result = session.run(q,parameters("name", name));
	            while (result.hasNext())
	            {
	                Record record = result.next();
	                 System.out.println(record.get("pnhan").asString());     
	                 System.out.println("-----");
	            }
	            System.out.println("Time for query 6: " +(System.currentTimeMillis() - start)+" ms");
	        } 
	 }
	 //
	 private  void  query7 (String local) {
		  long start = System.currentTimeMillis();
		   String q = "MATCH (e:Event)-[:TO_CHUC_TAI]->(l:Location) WHERE l.nhan = {local} "
		   		    + " WITH DISTINCT e,l"
	    			+ " RETURN e.nhan AS enhan  ";
		   System.out.println( "Su kien duoc to chuc tai "+local+": ");
	        try (Session session = ConnectDataBase.connection.driver.session())
	        {
	            StatementResult result = session.run(q,parameters("local", local));
	            while (result.hasNext())
	            {
	                Record record = result.next();
	                 System.out.println(record.get("enhan").asString());     
	                 System.out.println("-----");
	            }
	            System.out.println("Time for query 7: " +(System.currentTimeMillis() - start)+" ms");
	        } 
	 }
	 //
	  public void queryall() {
		  QueryData qre = new QueryData();
		  qre.query1();
		 //qre.query2("Vu");
		 // qre.query3("Vuong");
		 //  qre.query4("https://www.facebook.com");
		 // qre.query5("");
		 //qre.qrery6();
		//qre.qrery7();
	  }
}
