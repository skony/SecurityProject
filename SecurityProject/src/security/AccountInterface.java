package security;

public interface AccountInterface {

	
	public int getId();
	public String getFirstname();
	public String getLastname();
	public String getUsername();
	public String getPassword();
	public int getRole();
	public boolean isLogged_in();
	public boolean isLocked();
	
}
