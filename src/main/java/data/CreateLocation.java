package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import connect.ConnectDataBase;
import entity.Location;

public class CreateLocation {
	private String Tempid; 
	DataExample data = new DataExample();

	public String randomNhan() {
		String nhan = null ;
		nhan = data.location[new Random().nextInt(data.location.length)];
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
	
	public void CreateNodeLocation(int num) {
		
		long start = System.currentTimeMillis();	
		List<String> list= new ArrayList<String>();
		Location Location = new Location();
		ConnectDataBase con =new ConnectDataBase("bolt://localhost:11007", "neo4j", "123456789");
		
		try {
		System.out.println("Đang thêm node Location...");
		 for (int j=0 ; j < num ;j++){
			for(int i=0; i<100 ; i++) {	
				Location.setNhan(randomNhan());
				Location.setDinhDanh(randomDinhDanh(i));
				Location.setMoTa(randomMoTa());
				Location.setLink(randomLink());
				Location.setNgayThang(randomThoiGian());
				
				String s = "(:Location{dinhdanh: "+ "\""+ j +Location.getDinhDanh()+ "\""
                         	+ ",nhan: "+"\""+ Location.getNhan()+ "\""
                         	+ ",mota: "+"\""+Location.getMoTa()+i+"\""
                         	+ ",link: "+"\""+Location.getLink()+ "\""
                         	+ ",ngaythang: "+"\""+Location.getNgayThang()+ "\""
                         	+ "})";
				list.add(s);
		  }	
			con.createEntity(list);  
		}
	        System.out.println("Time for create Location: " + (System.currentTimeMillis() - start) +"ms" );	
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
