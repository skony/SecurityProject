package hsm;

import java.sql.Date;

public class PatReport {

	private int id;
	private int patientId;
	private int age;
	private String Reason;
	private Date date;
	
	public PatReport(int id, int patientId, String reason, Date date, int age) {
		this.id = id;
		this.patientId = patientId;
		Reason = reason;
		this.date = date;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public int getPatientId() {
		return patientId;
	}
	public String getReason() {
		return Reason;
	}
	public Date getDate() {
		return date;
	}
	
	public int getAge() {
		return age;
	}
	
	
}
