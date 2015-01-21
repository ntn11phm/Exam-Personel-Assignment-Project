package examProject.transferObjects;

public class HostSessionDataTO implements Comparable<HostSessionDataTO>{
	private String date;
	private String time;
	private String location;
	private String lastname;
	private String firstname;
	private boolean isResponsible;
	
	public HostSessionDataTO(String date, String time, String location, String firstname, String lastname, boolean isResponsible) {
		this.date = date;
		this.time = time;
		this.location = location;
		this.firstname = firstname;
		this.lastname = lastname;
		this.isResponsible = isResponsible;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public String getLocation() {
		return location;
	}

	public String getLastname() {
		return lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public boolean isResponsible() {
		return isResponsible;
	}
	
	@Override
	public int compareTo(HostSessionDataTO other) {
		int result = -1;
		if (this.date==other.date && this.time==other.time && this.location==other.location)
			result = 0;
		else
			result = 1;
		return result;
	}


}
