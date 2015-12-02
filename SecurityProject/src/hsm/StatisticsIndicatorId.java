package hsm;

public class StatisticsIndicatorId {

	private float percentageOfAffectedPatients;
	private float percentageOfTotal;
	
	public float getPercentageOfAffectedPatients() {
		return percentageOfAffectedPatients;
	}
	public StatisticsIndicatorId(float percentageOfAffectedPatients, float percentageOfTotal) {
		
		this.percentageOfAffectedPatients = percentageOfAffectedPatients;
		this.percentageOfTotal = percentageOfTotal;
	}
	public float getPercentageOfTotal() {
		return percentageOfTotal;
	}
}
