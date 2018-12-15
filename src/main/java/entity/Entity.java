package entity;

public class Entity {
	
	private String dinhDanh = null;
	private String nhan = null;
	private String moTa = null;
	private String link = null;
	private String ngayThang = null;
	
	// Constructor
		public Entity(String dinhDanh, String nhan, String moTa, String link, String ngayThang) {
			this.dinhDanh = dinhDanh;
			this.nhan = nhan;
			this.moTa = moTa;
			this.link = link;
			this.ngayThang = ngayThang;
		}
		
		// Constructor 
		public Entity(String dinhDanh, String nhan) {
			this.dinhDanh = dinhDanh;
			this.nhan = nhan;
		}
		// Constructor 
		public Entity(String dinhDanh, String tenHienThi, String moTa) {
			this.dinhDanh = dinhDanh;
			this.nhan = tenHienThi;
			this.moTa = moTa;
		}
		public Entity() {};
		
		public String getDinhDanh() {
			return dinhDanh;
		}
		public void setDinhDanh(String dinhDanh) {
			this.dinhDanh = dinhDanh;
		}
		public String getNhan() {
			return nhan;
		}
		public void setNhan(String nhan) {
			this.nhan = nhan;
		}
		public String getMoTa() {
			return moTa;
		}
		public void setMoTa(String moTa) {
			this.moTa = moTa;
		}
		public String getLink() {
			return link;
		}
		public void setLink(String link) {
			this.link = link;
		}
		public String getNgayThang() {
			return ngayThang;
		}
		public void setNgayThang(String ngayThang) {
			this.ngayThang = ngayThang;
		}		
}
