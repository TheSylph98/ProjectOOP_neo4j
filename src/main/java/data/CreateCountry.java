package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import connect.ConnectDataBase;
import entity.Country;

public class CreateCountry {
	private String Tempid; 
	DataExample data = new DataExample();

	public String randomNhan() {
		String nhan = null ;
		nhan = data.quoctich[new Random().nextInt(data.quoctich.length)];
		Tempid = nhan;
		return nhan;
	}

	public String randomMoTa() {
		String des = null;
		des = data.desquoctich[new Random().nextInt(data.desquoctich.length)];
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
	
	public void CreateNodeCountry(int num) {
		
		long start = System.currentTimeMillis();	
		List<String> list= new ArrayList<String>();
		Country country = new Country();
		ConnectDataBase con =new ConnectDataBase("bolt://localhost:11007", "neo4j", "123456789");
		
		try {
		System.out.println("Đang thêm node Country...");
		 for (int j=0 ; j < num ;j++){
			for(int i=0; i<100 ; i++) {	
				country.setNhan(randomNhan());
				country.setDinhDanh(randomDinhDanh(i));
				country.setMoTa(randomMoTa());
				country.setLink(randomLink());
				country.setNgayThang(randomThoiGian());
				
				String s = "(:Country{dinhdanh: "+ "\""+ j +country.getDinhDanh()+ "\""
                         	+ ",nhan: "+"\""+ country.getNhan()+ "\""
                         	+ ",mota: "+"\""+country.getMoTa()+ "\""
                         	+ ",link: "+"\""+country.getLink()+ "\""
                         	+ ",ngaythang: "+"\""+country.getNgayThang()+ "\""
                         	+ "})";
				list.add(s);
		  }	
			con.createEntity(list);  
		}
	        System.out.println("Time for create Country: " + (System.currentTimeMillis() - start) +"ms" );	
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
