package entity;

public class Person extends Entity{
	// Constructor
	public Person(String dinhDanh, String nhan, String moTa, String link, String ngayThang) {
		super(dinhDanh, nhan, moTa, link, ngayThang);
	}
	
	// Constructor
	public Person(String dinhDanh, String nhan) {
		super(dinhDanh, nhan);
	}
}
