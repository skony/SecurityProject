package hsm;

public class MedRecord {

	private PatReport patreport;
	private MedCaseInfo medcase;
	private AdminInfo admininfo;
	private StatisticsIndicatorId stats;
	
	
	public PatReport getPatreport() {
		return patreport;
	}
	public MedRecord(PatReport patreport, MedCaseInfo medcase, AdminInfo admininfo, StatisticsIndicatorId stats) {
		this.patreport = patreport;
		this.medcase = medcase;
		this.admininfo = admininfo;
		this.stats = stats;
	}
	public void setPatreport(PatReport patreport) {
		this.patreport = patreport;
	}
	public MedCaseInfo getMedcase() {
		return medcase;
	}
	public void setMedcase(MedCaseInfo medcase) {
		this.medcase = medcase;
	}
	public AdminInfo getAdmininfo() {
		return admininfo;
	}
	public void setAdmininfo(AdminInfo admininfo) {
		this.admininfo = admininfo;
	}
	public StatisticsIndicatorId getStats() {
		return stats;
	}
	public void setStats(StatisticsIndicatorId stats) {
		this.stats = stats;
	}
	
}
