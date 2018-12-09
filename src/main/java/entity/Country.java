package entity;

public class Country extends Entity{
	// Constructor
		public Country(String dinhDanh, String nhan, String moTa, String link, String ngayThang) {
			super(dinhDanh, nhan, moTa, link, ngayThang);
		}
		
		// Constructor
		public Country(String dinhDanh, String nhan) {
			super(dinhDanh, nhan);
		}
}
