package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Calendar; 

import connect.ConnectDataBase;
import entity.Time;

public class CreateTime {
	private String Tempid; 
	DataExample data = new DataExample();

	public String randomNhan(int i) {
		Calendar calendar = Calendar.getInstance();
		i = i%6500;
		calendar.add(Calendar.DATE, -i);
		Tempid = calendar.getTime().toString();
		return Tempid;
	}

	public String randomMoTa() {
		return Tempid;
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
		String tem = "Time";
		return tem+id;
	}
	
	public void CreateNodeTime(int num) {
		
		long start = System.currentTimeMillis();	
		List<String> list= new ArrayList<String>();
		Time time = new Time();
		ConnectDataBase con =new ConnectDataBase("bolt://localhost:11007", "neo4j", "123456789");
		
		try {
		System.out.println("Đang thêm node Time...");
		 for (int j=0 ; j < num ;j++){
			for(int i=0; i<100 ; i++) {	
				time.setNhan(randomNhan(i));
				time.setDinhDanh(randomDinhDanh(i));
				time.setMoTa(randomMoTa());
				time.setLink(randomLink());
				time.setNgayThang(randomThoiGian());
				
				String s = "(:Time{dinhdanh: "+ "\""+ j +time.getDinhDanh()+ "\""
                         	+ ",nhan: "+"\""+ time.getNhan()+ "\""
                         	+ ",mota: "+"\""+time.getMoTa()+ "\""
                         	+ ",link: "+"\""+time.getLink()+ "\""
                         	+ ",ngaythang: "+"\""+time.getNgayThang()+ "\""
                         	+ "})";
				list.add(s);
		  }	
			con.createEntity(list);  
		}
	        System.out.println("Time for create Time: " + (System.currentTimeMillis() - start) +"ms" );	
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
