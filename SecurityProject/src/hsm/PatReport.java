package hsm;

import java.sql.Date;

public class PatReport {

	private int id;
	private int patientId;
	private int age;
	private Date date;
	
	public PatReport(int id, int patientId, Date date, int age) {
		this.id = id;
		this.patientId = patientId;
		this.date = date;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public int getPatientId() {
		return patientId;
	}
	
	public Date getDate() {
		return date;
	}
	
	public int getAge() {
		return age;
	}
	
	
}
