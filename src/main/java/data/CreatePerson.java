package data;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;



import connect.ConnectDataBase;
import entity.Person;

public class CreatePerson {

	private String Tempid;
	 
	DataExample data = new DataExample();
	
	public String lastName() {
		String lastName = null ;
		lastName = data.lastName[new Random().nextInt(data.lastName.length)];
		this.Tempid = lastName;
		return lastName;
	}
	
	public String randomDinhDanh(int id) {
		String nhan = null ;
		nhan = this.Tempid + id;
		return nhan;
	}

	public String randomMoTa() {
		String des = null;
		des = data.descriptionPerson[new
		                Random().nextInt(data.descriptionPerson.length)];
		return des;
	}
	
	public String randomLink() {
		String link ;
		link = data.link[new Random().nextInt(data.link.length)];
		return link;
	}
	
	
	public String randomThoiGian() {
		String date;
		date = data.time[new Random().nextInt(data.time.length)];
		return date;
	}
	
	public String randomNhan() {
		String id;
		id = data.firstName[new Random().nextInt(data.firstName.length)]+" "+
				data.midName[new Random().nextInt(data.midName.length)]+" "+lastName();
		return id;
	}
	public void CreateNodePerson(int num ) {
		
		long start = System.currentTimeMillis();	
		List<String> list=new ArrayList<String>();
		Person person = new Person();
		ConnectDataBase con =new ConnectDataBase("bolt://localhost:11007", "neo4j", "123456789");
		try {
		  for (int j=0 ; j < num ; j++){
			for(int i=0 ; i < 100 ; i++){	
				person.setNhan(randomNhan());
				person.setDinhDanh(randomDinhDanh(i));
				person.setMoTa(randomMoTa());
				person.setLink(randomLink());
				person.setNgayThang(randomThoiGian());
				
				String s = "(:Person{dinhdanh: "+ "\""+j+ person.getDinhDanh()+ "\""
                         	+ ",nhan: "+"\""+ person.getNhan()+ "\""
                         	+ ",mota: "+"\""+person.getMoTa()+ "\""
                         	+ ",ngaythang: "+"\""+person.getNgayThang()+ "\""
                         	+ ",name: "+"\""+ lastName()+ "\""
                         	+ "})";
				list.add(s);
				//System.out.println(s);
		     }		     
			con.createEntity(list);  
		}
	        System.out.println("Time for create Person: " + (System.currentTimeMillis() - start) +"ms" );	
	        try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
}
