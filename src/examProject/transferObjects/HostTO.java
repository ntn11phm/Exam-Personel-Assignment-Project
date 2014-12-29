package examProject.transferObjects;

public class HostTO {
	private int host_id;
	private String firstName;
	private String lastName;
	private boolean isResponsible;
	
	public HostTO(int host_id, String firstName, String lastName) {
		this(host_id, firstName, lastName, false);
	}
	
	public HostTO(int host_id, String firstName, String lastName, boolean isResponsble) {
		this.host_id = host_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isResponsible = isResponsble;
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

	public boolean isResponsible() {
		return isResponsible;
	}

	@Override
	public String toString() {
		return "" + firstName + " " + lastName + " " + host_id;
	}
}
