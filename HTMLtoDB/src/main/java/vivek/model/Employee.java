package vivek.model;

public class Employee {
	
	protected long usn;
	private String username;
	private String password;
	private String email;
	private String gender;
	private String branch;
	
	public Employee()
	{
		
	}
	
	
	public Employee(long usn, String username, String password, String email, String gender, String branch)
	{
		super();
		this.usn = usn;
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.branch = branch;
	}
	public long getUsn() {
		return usn;
	}
	
	public void setUsn(long usn)
	{
		this.usn=usn;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	

}
