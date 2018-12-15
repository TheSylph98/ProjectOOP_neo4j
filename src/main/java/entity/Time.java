package entity;

public class Time extends Entity{
	// Constructor
		public Time(String dinhDanh, String nhan, String moTa, String link, String ngayThang) {
			super(dinhDanh, nhan, moTa, link, ngayThang);
		}
		
		// Constructor
		public Time(String dinhDanh, String nhan) {
			super(dinhDanh, nhan);
		}
		public Time() {
			super();
		};
}
