package hsm;

public class MedRecord {

	private PatReport patreport;
	private MedCaseInfo medcase;
	private AdminInfo admininfo;
	private StatisticsIndicatorId stats;
	private InternalInfo inf;
	private int id;
	
	public int getId() {
		return id;
	}
	public InternalInfo getInf() {
		return inf;
	}
	public PatReport getPatreport() {
		return patreport;
	}
	public MedRecord(int id, PatReport patreport, MedCaseInfo medcase, AdminInfo admininfo, InternalInfo internal, StatisticsIndicatorId stats) {
		this.id = id;
		this.patreport = patreport;
		this.medcase = medcase;
		this.admininfo = admininfo;
		this.inf = internal;
		this.stats = stats;
	}
	
	public MedCaseInfo getMedcase() {
		return medcase;
	}

	public AdminInfo getAdmininfo() {
		return admininfo;
	}
	
	public StatisticsIndicatorId getStats() {
		return stats;
	}
	public void setStats(StatisticsIndicatorId stats) {
		this.stats = stats;
	}
	
}
