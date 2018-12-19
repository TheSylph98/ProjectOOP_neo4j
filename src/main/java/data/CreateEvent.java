package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import connect.ConnectDataBase;
import entity.Event;;

public class CreateEvent {
	private String Tempid; 
	DataExample data = new DataExample();

	public String randomNhan() {
		String nhan = null ;
		nhan = data.event[new Random().nextInt(data.event.length)];
		Tempid = nhan;
		return nhan;
	}

	public String randomMoTa() {
		String des = null;
		des = data.event[new Random().nextInt(data.event.length)];
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
	
	public void CreateNodeEvent(int num) {
		
		long start = System.currentTimeMillis();	
		List<String> list= new ArrayList<String>();
		Event event = new Event();
		ConnectDataBase con =new ConnectDataBase("bolt://localhost:11007", "neo4j", "123456789");
		
		try {
		System.out.println("Đang thêm node Event...");
		 for (int j=0 ; j < num ;j++){
			for(int i=0; i<100 ; i++) {	
				event.setNhan(randomNhan());
				event.setDinhDanh(randomDinhDanh(i));
				event.setMoTa(randomMoTa());
				event.setLink(randomLink());
				event.setNgayThang(randomThoiGian());
				
				String s = "(:Event{dinhdanh: "+ "\""+ j +event.getDinhDanh()+ "\""
                         	+ ",nhan: "+"\""+ event.getNhan()+ "\""
                         	+ ",mota: "+"\""+event.getMoTa()+ "\""
                         	+ ",link: "+"\""+event.getLink()+ "\""
                         	+ ",ngaythang: "+"\""+event.getNgayThang()+ "\""
                         	+ "})";
				list.add(s);
		  }	
			con.createEntity(list);  
		}
	        System.out.println("Time for create Event: " + (System.currentTimeMillis() - start) +"ms" );	
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
