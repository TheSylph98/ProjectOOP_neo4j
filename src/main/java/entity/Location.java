package entity;

public class Location extends Entity{
	// Constructor
	public Location(String dinhDanh, String nhan, String moTa, String link, String ngayThang) {
		super(dinhDanh, nhan, moTa, link, ngayThang);
	}
	
	// Constructor
	public Location(String dinhDanh, String nhan) {
		super(dinhDanh, nhan);
	}
}
