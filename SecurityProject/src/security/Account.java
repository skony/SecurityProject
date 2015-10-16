package security;

public class Account implements AccountInterface
{
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private int role;
	private boolean logged_in;
	private boolean locked;
	
	
	
	public Account(int id, String firstname, String lastname, String username, String password, int role, boolean logged_in,
			boolean locked) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.role = role;
		this.logged_in = logged_in;
		this.locked = locked;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public int getRole() {
		return role;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", password=" + password + ", role=" + role + ", logged_in=" + logged_in + ", locked=" + locked + "]";
	}

	public boolean isLogged_in() {
		return logged_in;
	}
	public boolean isLocked() {
		return locked;
	}
	
	
	
}
