package examProject.transferObjects;
/**
 * Transferobject containing two dates and a toString()
 * @author Magnus Eklund
 */
import java.util.List;

public class CreateInvitationTO {
	private String fromDate;
	private String toDate;
	/**
	 * Constructor.
	 * @param fromDate {@link String} use dateformat: yyyy-MM-dd
	 * @param toDate {@link String} use dateformat: yyyy-MM-dd
	 */
	public CreateInvitationTO(String fromDate, String toDate) {
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	/**
	 * Getter for the fromdate.
	 * @return {@link String}
	 */
	public String getFromDate() {
		return fromDate;
	}
	/**
	 * Getter for the todate.
	 * @return {@link String}
	 */
	public String getToDate() {
		return toDate;
	}
	/**
	 *  Here for unclear reasons :P
	 * @param sessionList
	 * @return {@link String}
	 */
	public String toString(List<CreateInvitationTO> sessionList) {
		return "" + fromDate + "   " + toDate;
	}

}
