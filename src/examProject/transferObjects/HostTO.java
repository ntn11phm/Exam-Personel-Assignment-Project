package examProject.transferObjects;

public class HostTO {
	private int host_id;
	private String firstName;
	private String lastName;
	
	public HostTO(int host_id, String firstName, String lastName) {
		this.host_id = host_id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getHost_id() {
		return host_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "" + firstName + " " + lastName;
	}
}
