package examProject.logic;

public interface Password_interface {
	public String getSaltedHash(String password) throws Exception;
	public boolean check(String password, String stored) throws Exception;
}
