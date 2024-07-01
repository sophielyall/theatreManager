
import java.util.ArrayList;
import java.util.Scanner;

public class TheatreManager {
	static Scanner in;
	static ArrayList<Customer> customers;
	static ArrayList<Movie> movies;
	static ArrayList<Admin> admins;
 public static void main(String[] args)
 {
	 boolean exitMenu = false;
	 ReadFile readFile= new ReadFile();
	//Read list of customers from file
	customers = readFile.readCustomer( "customer");
	
	//Read list of movies from file
	 movies = readFile.readMovie( "movie");
	
	//Read list of admins from file
	 admins = readFile.readAdmin("admin");
	 
	 //menu for cinema manager
	 System.out.println("Welcome to the cinema manager");
	  in = new Scanner(System.in);
	  
	  System.out.println("Choose 1 for custmer or 2 for admin");
	  int option = in.nextInt();
	  //User is a customer
	  if(option ==1)
	  { 
		  while(!exitMenu)
			{ in.nextLine();
			  System.out.println("Customer Username: ");
			  String username = in.nextLine();
			  System.out.println("Customer Password: ");
			  String password = in.nextLine();
			  
			  Customer currentCustomer = loginCustomer(username, password);
			  while(currentCustomer!=null)
			  {
			  //Customer menu
		  System.out.println("Choose one option");
		  System.out.println("1. Make Booking"); 
			 System.out.println("2. Cancel Booking");
			 System.out.println("3. Search Show");
			 System.out.println("4. Exit");
			 
			 switch(in.nextInt())
				{	 
	  case(1):
			System.out.println("make booking");
	  
	  		
	  			
	  			Movie foundMovie = searchShow();
	  			if(foundMovie !=null) {
	  			int counter = 0;
	  			System.out.println("Choose a show for a booking");
	  			for(Show aShow: foundMovie.shows)
	  			{
	  				if(aShow.availableSeats >= 1) {
	  					System.out.println(counter + ". Number of Seats: " + aShow.getSeats() + " Date of Show: " + aShow.getDate());
	  					System.out.println("Enter number of seats you are booking: ");
	  					int seats = in.nextInt();
	  					int bookingId = 0;
	  					if(currentCustomer.bookings.size()==0)
	  					{
	  						bookingId = 1;
	  					}
	  					else
	  						bookingId = currentCustomer.bookings.size() + 1;
	  						//Booking aBooking = new Booking(currentCustomer.bookings.size(),aShow.id, seats);
	  					//Booking aBooking = new Booking(bookingId,aShow.id, seats);
	  					//currentCustomer.bookings.add(aBooking);
	  				}
	  				else {
	  					System.out.println("No seats available.");
	  				}
	  				counter ++;
	  			}}
	  			
	  		
			break;
		case(2):
			System.out.println("cancel Booking");
			for(Booking aBooking: currentCustomer.bookings)
			{
				System.out.println("Booking ID: " + aBooking.getBookingId() + " Show ID: " + aBooking.showId + " number of seats: " + aBooking.numOfSeats);
			}
		
		/**Movie cancelMovie = searchShow();
			if(cancelMovie !=null) {
			int counter = 0;
			System.out.println("Choose a show for a booking");
			for(Show aShow: cancelMovie.shows)
			{
				if(aShow.availableSeats >= 1) {
					System.out.println(counter + ". Number of Seats: " + aShow.getSeats() + " Date of Show: " + aShow.getDate() + "Time of Show: " + aShow.getTime());
					System.out.println("Enter number of seats you are booking: ");
					int seats = in.nextInt();
					int bookingId = 0;
					if(currentCustomer.bookings.size()==0)
					{
						bookingId = 1;
					}
					else
						bookingId = currentCustomer.bookings.size() + 1;
						//Booking aBooking = new Booking(currentCustomer.bookings.size(),aShow.id, seats);
					Booking aBooking = new Booking(bookingId,aShow.id, seats);
					currentCustomer.bookings.add(aBooking);
				}
				else {
					System.out.println("No seats available.");
				}
				counter ++;
			}}**/
			break;
		case(3):
			System.out.println("Search show");
		searchShow();
			break;
		case(4):
			System.out.println("Exit");
		exitMenu = true;
		default:
			System.out.println("enter a number 1-4");
			break;}
	  }
			  System.out.println("Incorrect username or password.  Try again");}}
	  
	  //User is a admin.
	  else if(option == 2)
	  {
		  while(in != null)
				{
			  
			  
			  String username = in.nextLine();
			  String password = in.nextLine();
			  
			  Admin currentAdmin = loginAdmin(username, password);
			  
			  //admin menu
			  System.out.println("Choose one option");
			 System.out.println("1. Add Customer");
			 System.out.println("2. Add Movie");
			 System.out.println("3. Add Show");
			 System.out.println("4. Search Show"); 
			 
			 
			 
				switch(in.nextInt())
				{
				case(1):
					System.out.println("add customer");
					addCustomer();
				
					break;
				
				case(2):
					System.out.println("add movie");
				addMovie();
					break;
				case(3):
					System.out.println("add show");
				addShow();
					break;
				case(4):
					System.out.println("Search For Show");
					Movie foundMovie = searchShow();
					if(foundMovie != null)
						{
						for(Show aShow: foundMovie.shows)
						{
							System.out.println("Show for movie: "  + foundMovie.getTitle());
							System.out.println("Number of Seats: " + aShow.getSeats() + " Date of Show: " + aShow.getDate() + "Time of Show: ");
						}
					
						}
					break;
				default:
					System.out.println("enter a number 1-4");
					break;
				}
	  }
	

		
			//System.out.println("add member");
	
		}
 }
 
private static Customer loginCustomer(String username, String password)
{
	for(Customer aCustomer: customers)
	{
		if(aCustomer.getUsername().equals(username) && aCustomer.getPassword().equals(password)) {
			return aCustomer;
		}
	}
	return null;
}

private static Admin loginAdmin(String username, String password)
{
	for(Admin aAdmin: admins)
	{
		if(aAdmin.getUsername().equals(username) && aAdmin.getPassword().equals(password)) {
			return aAdmin;
		}
	}
	return null;
}
private static Movie searchShow() {
	// TODO Auto-generated method stub
	 System.out.println("Movie Title: ");
	in.nextLine();	
	 String title = in.nextLine();
		
		for(Movie aMovie: movies)
		{
			if(aMovie.getTitle().equals(title))
			{
				return aMovie;
			}
		}
		System.out.println("Could not find movie");
		return null;
}

private static void addShow() {
	// TODO Auto-generated method stub
	Movie aMovie = searchShow();
	int id;
	if(aMovie != null)
	{
		System.out.println("FOUND MOVIE");
		if(aMovie.shows.size() == 0)
		{
			id = 1;
		}
		else
		{
			id = aMovie.shows.size() + 1;
		}
		
		System.out.println("Number of seats: ");
		int seats = in.nextInt();
		in.nextLine();
		System.out.println("Date of show: ");
		String date = in.nextLine();
		System.out.println("Time of show: ");
		String time = in.nextLine();
		
		Show aShow = new Show("S" + id, seats, date, time);
		aMovie.shows.add(aShow);
		
		 SaveFile saveFile = new SaveFile();
		saveFile.saveMovie("movie", movies);
		
	}
	else
		System.out.println("Could not find movie");
	
	
}

private static void addMovie() {
	
	 String id = null;// TODO Auto-generated method stub
	 //int lastId = movies.get(movies.size() -1);
	 if(movies.size() >= 0) {
		id = "1";
	 }
	 in.nextLine();
	 System.out.println("Movie Title: ");
	 String title = in.nextLine();
	 System.out.println("Movie Director: ");
	 String director = in.nextLine();
	 System.out.println("Movie Runtime (Minutes): ");
	 int runtime = in.nextInt();
	 System.out.println("Price: ");
	 Double price = in.nextDouble();
	 
	 Movie aMovie = new Movie(id, title, director, runtime, price);
	 movies.add(aMovie);
	 
	 SaveFile saveFile = new SaveFile();
	 saveFile.saveMovie("movie", movies);
}
public static Customer checkUser(String username, String password) {
	for(Customer aCustomer: customers) {
		if(username.equals(aCustomer.getUsername()) && password.equals(aCustomer.getPassword()))
			System.out.println("Customer Found " + aCustomer.getName());
		return aCustomer;
		}
	
	System.out.println("Could not find user");
	return null;
	}
	

public static void addCustomer() {
	in.nextLine();
	 System.out.println("Customer username: ");
	 String username = in.nextLine();
	 System.out.println("Customer firstname: ");
	 String firstname = in.nextLine();
	 System.out.println("Customer surname: ");
	 String surname = in.nextLine();
	 System.out.println("Customer password: ");
	 String password = in.nextLine();
	 
	 Customer newCustomer = new Customer(username, firstname, surname, password);
	 customers.add(newCustomer);
	 
	 SaveFile saveFile = new SaveFile();
	saveFile.saveCustomer("customer", customers);
 }
}
