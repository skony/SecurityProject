package hsm;

public class AdminInfo {

	private int id;
	private float price;
	private String medicalcenter;
	public AdminInfo(int id, float price, String medicalcenter) {
		super();
		this.id = id;
		this.price = price;
		this.medicalcenter = medicalcenter;
	}
	public int getId() {
		return id;
	}
	public float getPrice() {
		return price;
	}
	
	public String getMedicalcenter() {
		return medicalcenter;
	}
	
	
}
