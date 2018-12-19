package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import connect.ConnectDataBase;
import entity.Organization;;

public class CreateOrganization {
	private String Tempid; 
	DataExample data = new DataExample();

	public String randomNhan() {
		String nhan = null ;
		nhan = data.nameOrganization[new Random().nextInt(data.nameOrganization.length)];
		this.Tempid = nhan;
		return nhan;
	}

	public String randomMoTa() {
		String des = null;
		des = data.descriptionOrganization[new
		                Random().nextInt(data.descriptionOrganization.length)];
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
	
	public String randomDinhDanh(int id) {
		String nhan = null ;
		nhan = this.Tempid + id;
		return nhan;
	}
	
	public void CreateNodeOrganization(int num) {
		
		long start = System.currentTimeMillis();	
		List<String> list= new ArrayList<String>();
		Organization org = new Organization();
		ConnectDataBase con =new ConnectDataBase("bolt://localhost:11007", "neo4j", "123456789");
		
		try {
		System.out.println("Đang thêm node Organization...");
		 for (int j=0 ; j < num ;j++){
			for(int i=0; i<100 ; i++) {	
				org.setNhan(randomNhan());
				org.setDinhDanh(randomDinhDanh(i));
				org.setMoTa(randomMoTa());
				org.setLink(randomLink());
				org.setNgayThang(randomThoiGian());
				
				String s = "(:Organization{dinhdanh: "+ "\""+ j +org.getDinhDanh()+ "\""
                         	+ ",nhan: "+"\""+ org.getNhan()+ "\""
                         	+ ",mota: "+"\""+org.getMoTa()+ "\""
                         	+ ",link: "+"\""+org.getLink()+ "\""
                         	+ ",ngaythang: "+"\""+org.getNgayThang()+ "\""
                         	+ "})";
				list.add(s);
		  }	
			con.createEntity(list);  
		}
	        System.out.println("Time for create Organization: " + (System.currentTimeMillis() - start) +"ms" );	
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
