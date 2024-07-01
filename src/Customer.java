import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	String username, firstname, surname, password;
	ArrayList<Booking> bookings;
public Customer(String aUsername, String aFirstname, String aSurname, String aPassword)
{
	username = aUsername;
	firstname = aFirstname;
	surname = aSurname;
	password = aPassword;
	bookings = new ArrayList<Booking>();
}

public void addBooking(Booking aBooking) {
bookings.add(aBooking);
}

public void removeBooking(Booking aBooking)
{
	bookings.remove(aBooking);
}

public Object getUsername() {
	// TODO Auto-generated method stub
	return username;
}

public Object getPassword() {
	// TODO Auto-generated method stub
	return password;
}

public String getName() {
	// TODO Auto-generated method stub
	String fullName = firstname + " " + surname;
	
	return fullName;
}

}
