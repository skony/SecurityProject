package hsm;

public class AdminInfo {

	private int id;
	private float price;
	private int adminid;
	private String medicalcenter;
	public AdminInfo(int id, float price, int adminid, String medicalcenter) {
		super();
		this.id = id;
		this.price = price;
		this.adminid = adminid;
		this.medicalcenter = medicalcenter;
	}
	public int getId() {
		return id;
	}
	public float getPrice() {
		return price;
	}
	public int getAdminid() {
		return adminid;
	}
	public String getMedicalcenter() {
		return medicalcenter;
	}
	
	
}
