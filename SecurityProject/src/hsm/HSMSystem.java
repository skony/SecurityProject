package hsm;

import db.DBProcedures;

public class HSMSystem {

	public static MedRecord createNewRecord(String username){
		return DBProcedures.create_medRecord(username);
	}
	
	public static MedRecord findRecord(int patid){
		return DBProcedures.fetchMedRecordByPatientId(patid);
	}
	
	public static MedRecord findRecordById(int medrecid){
		return DBProcedures.fetchMedRecordById(medrecid);
	}
	
	public static PatReport getPatReport(MedRecord med){
		return med.getPatreport();
	}
	public static MedCaseInfo getMedCaseInfo(MedRecord med){
		return med.getMedcase();
	}
	
	public static AdminInfo getAdminInfo(MedRecord med){
		return med.getAdmininfo();
	}
	
	public static InternalInfo getInternalInfo(MedRecord med){
		return med.getInf();
	}
	
	public static void updatePatReport(String username, MedRecord med,PatReport pat){
		DBProcedures.update_patRecord(username, med.getId(), pat.getPatientId(), pat.getDate(), pat.getAge());
	}
	
	public static void updateMedCaseInfo(String username,MedRecord med ,MedCaseInfo medcase){
		DBProcedures.update_medcaseinfo(username, med.getId(), medcase.getDiseaseId(), medcase.getPrescription(), medcase.getNotes(), medcase.getDoctorid());
	}
	public static void updateAdminInfo(String username,MedRecord med,AdminInfo adm){
		DBProcedures.update_AdminInfo(username, med.getId(), adm.getPrice(), adm.getMedicalcenter());
	}
	
	public static void runStatistics(){
		
	}
	public static StatisticsIndicatorId getStatisticsIndicator(int IndicatorId){
		return null;
	}
	
	
}
