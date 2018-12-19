package data;

import org.neo4j.driver.v1.Driver;


import connect.ConnectDataBase;

public class CreateRelation {
   Driver driver;
   ConnectDataBase con =new ConnectDataBase("bolt://localhost:11007", "neo4j", "123456789");
   
	public void CreateRelationship(){
		long start = System.currentTimeMillis();	
		// rel1 
		String rel1="MATCH (a:Person),(b:Location) WHERE a.ngaythang="+"\"20-10-1998\""+"  "
				+ " AND  b.nhan="+"\"Trụ sở Apple Califonia\""
				+ " AND  b.ngaythang= a.ngaythang "
				+ " WITH DISTINCT a,b"
				+ " CREATE (a)-[r:LIVES]->(b)";
		//System.out.println(rel1);
		con.CreateRel(rel1);
		// rel2 
		String rel2="MATCH (a:Person),(b:Location) WHERE  a.ngaythang = b.ngaythang "
				+ " AND b.mota="+"\"Dong Nam A\""
				+ " with distinct a,b"
				+" CREATE (a)-[r:WORK_DNA]->(b)";
		//System.out.println(rel2);
		con.CreateRel(rel2);
		// rel3
		String rel3="MATCH (l:Location),(t:Time) WHERE l.ngaythang = t.ngaythang "
				+ " AND  t.link = l.link"
				+ " with distinct l,t"
				+ " CREATE (l)-[r:CELEBRATE]->(t) ";
		//System.out.println(rel3);
		con.CreateRel(rel3);
		//
		String rel4="MATCH (o:Organization),(c:Country) "
				 + " WHERE o.ngaythang = o.ngaythang " 
			     + " AND  o.link = c.link " 
			     + " with distinct o,c"
			     + " CREATE (l)-[r:ADRESS]->(t) ";
		con.CreateRel(rel4);
		//
		String rel5="MATCH (e:Event),(l:Location),(t:Time) "
				+ " WHERE e.ngaythang = t.ngaythang " 
				+ " AND  e.link = t.link "
				+ " AND  l.link = t.link"
			//	+ " AND l.nhan="+"\"Hồ Thiên Nga\"" 
				+ " with distinct e,l,t"
				+ " CREATE (e)-[r:TO_CHUC_TAI]->(l) ";
        con.CreateRel(rel5);
        //
        String rel6="MATCH (p1:Person),(p2:Person)"
        		+ " WHERE p1.mota=p2.mota and p1.ngaythang=p2.ngaythang "
        		+ " with distinct p1,p2"
        		+ "  create (p1)-[r:LIKE]->(p2)";
        con.CreateRel(rel6);
        //
        String rel7="MATCH (p:Person),(c:Country)"
        		+ " WHERE c.nhan="+"\"Viet Nam\""
        		+ " AND p.ngaythang=c.ngaythang"
        		+ " with distinct p,c"
        		+ " CREATE (p)-[r:BELONG_VN]->(c)";
        con.CreateRel(rel7);
        //
        String rel8="MATCH (e:Event),(l:Location) "
				+ " WHERE e.ngaythang = l.ngaythang " 
				+ " AND l.nhan="+"\"Hồ Thiên Nga\"" 
				+ " with distinct e,l,t"
				+ " CREATE (e)-[r:TO_CHUC_TAI_HO_THIEN_NGA]->(l) ";
        con.CreateRel(rel8);
        //
		System.out.println("Time for create Relation: " + (System.currentTimeMillis() - start) +"ms" );  
	}
}
