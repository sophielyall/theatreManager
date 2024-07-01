import java.io.Serializable;
import java.util.ArrayList;

public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;
	String username, firstname, surname, password;
	
	public Admin(String aUsername, String aFirstname, String aSurname, String aPassword)
	{
		username = aUsername;
		firstname = aFirstname;
		surname = aSurname;
		password = aPassword;
		
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getFullname() {
		return firstname + " " + surname;
	}
	
	public String getPassword() {
		return password;
	}

}
