package examProject.transferObjects;
/**
 * Transferobject containing data needed to create the import URL for kronox. 
 * @author Per Hedblom
 */
public class ExamImportSelectionTO {
	private String period_type;
	private String period_lenght;
	/**
	 * Constructor setting the period_type to weeks ("v") and the period_lenght to "6".
	 */
	public ExamImportSelectionTO() {
		this("v", "6");
	}
	/**
	 * Constructor setting period_type and period_lenght.
	 * @param period_type {@link String} valid values: "d" for days, "v" for weeks, "m" for months.
	 * @param period_lenght {@link String} valid values: numerics between 1 and 30.
	 */
	public ExamImportSelectionTO(String period_type, String period_lenght) {
		this.period_type = period_type;
		this.period_lenght = period_lenght;
	}
	/**
	 * Getter for the period_type.
	 * @return {@link String}
	 */
	public String getPeriod_type() {
		return period_type;
	}
	/**
	 * Getter for the period_lenght.
	 * @return {@link String}
	 */
	public String getPeriod_lenght() {
		return period_lenght;
	}
}
