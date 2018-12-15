package entity;

public class Event extends Entity{
	// Constructor
		public Event(String dinhDanh, String nhan, String moTa, String link, String ngayThang) {
			super(dinhDanh, nhan, moTa, link, ngayThang);
		}
		
		// Constructor
		public Event(String dinhDanh, String nhan) {
			super(dinhDanh, nhan);
		}
		public Event() {
			super();
		};
}
