package entity;

public class Organization extends Entity{
	// Constructor
		public Organization(String dinhDanh, String nhan, String moTa, String link, String ngayThang) {
			super(dinhDanh, nhan, moTa, link, ngayThang);
		}
		
		// Constructor
		public Organization(String dinhDanh, String nhan) {
			super(dinhDanh, nhan);
		}
		public Organization() {
			super();
		}
}
