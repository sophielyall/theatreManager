import java.util.ArrayList;

public class Setup {
public static void main(String[] args) {
	ArrayList<Admin> admins = new ArrayList<Admin>();
	ArrayList<Customer> customers = new ArrayList<Customer>();
	ArrayList<Movie> movies = new ArrayList<Movie>();
	SaveFile saveFile = new SaveFile();
	
	Admin admin = new Admin("test", "Sophie", "Test", "test");
	admins.add(admin);
	
	Customer cust1 = new Customer("test", "Phil", "Bing", "test");
	Customer cust2 = new Customer("user", "Cassie", "Smith", "pass");
	customers.add(cust1);
	customers.add(cust2);
	
	Movie movie1 = new Movie("m1", "Stardust", "Matthew Vaughn", 127,  15.00);
	Movie movie2 = new Movie("m2", "Back to the Future", "Robert Zemeckis", 116, 16.50 );
	Movie movie3 = new Movie("m3", "Up", "Pete Docter and Bob Peterson", 96, 12.50);
	movies.add(movie1);
	movies.add(movie2);
	movies.add(movie3);
	
	saveFile.saveAdmin("admin", admins);
	saveFile.saveCustomer("customer", customers);
	saveFile.saveMovie("movie", movies);
	
	
	
}
}
