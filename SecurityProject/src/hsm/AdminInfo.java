package hsm;

public class AdminInfo {

	private int id;
	private double price;
	private String medicalcenter;
	public AdminInfo(int id, double price, String medicalcenter) {
		super();
		this.id = id;
		this.price = price;
		this.medicalcenter = medicalcenter;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "AdminInfo [id=" + id + ", price=" + price + ", medicalcenter=" + medicalcenter + "]";
	}
	public double getPrice() {
		return price;
	}
	
	public String getMedicalcenter() {
		return medicalcenter;
	}
	
	
}
