package examProject.transferObjects;

public class ExamImportSelectionTO {
	private String period_type;
	private String period_lenght;
	
	public ExamImportSelectionTO() {
		this("v", "6");
	}
	
	public ExamImportSelectionTO(String period_type, String period_lenght) {
		this.period_type = period_type;
		this.period_lenght = period_lenght;
	}

	public String getPeriod_type() {
		return period_type;
	}

	public String getPeriod_lenght() {
		return period_lenght;
	}
}
