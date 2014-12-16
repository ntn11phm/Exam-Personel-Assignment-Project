package examProject.transferObjects;

public class HsiTO {
	private String date;
	private String time;
	private boolean answer;
	
	public HsiTO(String date, String time) {
		this(date, time, false);
	}
	
	public HsiTO(String date, String time, boolean answer) {
		this.date = date;
		this.time = time;
		this.answer = answer;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}
	
	public boolean getAnswer() {
		return answer;
	}

	@Override
	public String toString() {
		return "" + date + "   "+ time;
	}
}
