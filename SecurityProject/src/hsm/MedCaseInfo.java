package hsm;

public class MedCaseInfo {

@Override
	public String toString() {
		return "MedCaseInfo [diseaseId=" + diseaseId + ", prescription=" + prescription + ", notes=" + notes + ", id="
				+ id + ", doctorid=" + doctorid + "]";
	}


private int diseaseId;
private String prescription;
private String notes;
private int id;
private int doctorid;


public MedCaseInfo( int id,int diseaseId, String prescription, String notes, int doctorid) {
	this.diseaseId = diseaseId;
	this.prescription = prescription;
	this.notes = notes;
	this.id = id;
	this.doctorid = doctorid;
}


public int getDiseaseId() {
	return diseaseId;
}


public String getPrescription() {
	return prescription;
}


public String getNotes() {
	return notes;
}


public int getId() {
	return id;
}


public int getDoctorid() {
	return doctorid;
}




}
