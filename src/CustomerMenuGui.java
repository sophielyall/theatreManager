import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CustomerMenuGui {
	Customer aCustomer;
	static ArrayList<Customer> customers;
	static ArrayList<Movie> movies;
	static SaveFile saveFile;
	public CustomerMenuGui(Customer customer)
	{
		aCustomer = customer;
		
	}
	
	public void runMenu()
	{
		//read customer and movie details into arraylists
		ReadFile readFile = new ReadFile();
		 saveFile = new SaveFile();
		customers = readFile.readCustomer("customer");
		movies = readFile.readMovie("movie");
		
		//create customer menu
		JFrame customerMenu =  new JFrame("Customer Menu");
		customerMenu.setLayout(new GridLayout(5,2));
		JLabel welcome = new JLabel("Welcome: ");
		JLabel adminName = new JLabel(aCustomer.getName());
		JButton makeBooking = new JButton("Make Booking");
		JButton cancelBooking = new JButton("Cancel Booking");
		JButton logout = new JButton("Logout");
		
		//for customer to make a booking
		makeBooking.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				makeBooking();
			}

		
			
		});
		
		//for customer to cancel a booking
		cancelBooking.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cancelBooking();
			}
			
		});
		
		
		//to logout and return to login
		logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			customerMenu.dispose();
			}
			
		});
		
		
		customerMenu.add(welcome);
		customerMenu.add(adminName);
		customerMenu.add(makeBooking);
		customerMenu.add(cancelBooking);
		customerMenu.add(logout);
		
		customerMenu.pack();
		customerMenu.setVisible(true);
	}
	
	public void makeBooking() {
		// TODO Auto-generated method stub
		JFrame makeBooking = new JFrame("Make Booking");
		makeBooking.setLayout(new GridLayout(2,2));
		Object[] strings = movies.toArray();;
		JComboBox moviesBox = new JComboBox(strings);
		JButton submit = new JButton("Select");
		submit.addActionListener(new ActionListener() {
		

			@Override
			public void actionPerformed(ActionEvent e) {
				// movie selected from drop down
				Movie selectedMovie =  movies.get(moviesBox.getSelectedIndex());
				if(selectedMovie.shows.size() == 0) {
					makeBooking.dispose();
					System.out.println("NO SHOWS");
				}
				
				
				System.out.println(moviesBox.getSelectedItem());
				System.out.println(selectedMovie.getTitle());
				JFrame bookingDetails = new JFrame("Show Details");
				bookingDetails.setLayout(new GridLayout(4,2));
				//set up next booking ID.
				int nextID = aCustomer.bookings.size() + 1;
				String id = "b" + nextID;
				
				
				JLabel idLab = new JLabel("ID: ");
				JLabel newIdLab = new JLabel(id);
				JLabel showsLab = new JLabel("Shows: ");
				Object[] showsArray = selectedMovie.shows.toArray();
				JComboBox showsBox = new JComboBox(showsArray);
				
				JLabel numSeatLab = new JLabel("Number of Seats: ");
				JTextField numSeatText = new JTextField();
				
				
	
				JButton bookingSubmit = new JButton("Submit");
				
				bookingSubmit.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
		
					int index =  showsBox.getSelectedIndex();
					//all shows for the selected movie.
					Show selectedShow = selectedMovie.shows.get(index);
					System.out.println(selectedShow.toString());
					int seatsToBook = Integer.parseInt(numSeatText.getText());
					//check if enough seats are available.
					if(selectedShow.getSeats()>= seatsToBook)
					{
						selectedShow.bookSeats(seatsToBook);
						System.out.println(selectedShow.getSeats());
						selectedMovie.shows.set(index, selectedShow);
						Booking newBooking = new Booking(newIdLab.getText(), selectedShow.id,selectedMovie.id, seatsToBook);
						aCustomer.addBooking(newBooking);
						
						// to save new booking arraylist for customer
						for(Customer newCust : customers)
						{
							if(aCustomer.getUsername().equals(newCust.getUsername())) 
							{
								int custIndex = customers.indexOf(newCust);
								customers.set(custIndex, aCustomer);
							}
						}
					
						saveFile.saveCustomer("customer", customers);
						saveFile.saveMovie("movie", movies);
						bookingDetails.dispose();
						makeBooking.dispose();
						
					}
					else {
						System.out.println("Not enough seats available");
					}
					}
					
				});
				bookingDetails.add(idLab);
				bookingDetails.add(newIdLab);
				bookingDetails.add(showsLab);
				bookingDetails.add(showsBox);
				bookingDetails.add(numSeatLab);
				bookingDetails.add(numSeatText);
				bookingDetails.add(bookingSubmit);
				bookingDetails.pack();
				bookingDetails.setVisible(true);
				
				
		
			
		
	
	}
		});
		
		makeBooking.add(submit);
		makeBooking.add(moviesBox);
		makeBooking.pack();
		makeBooking.setVisible(true);
	}
	
	public void cancelBooking()
	{
		JFrame cancelFrame = new JFrame("Cancel Booking");
		Object[] bookingsArray = aCustomer.bookings.toArray();
		JComboBox bookingsBox = new JComboBox(bookingsArray);
		JButton cancelSubmit = new JButton("Submit");
		cancelSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// booking to be cancelled.
				Booking selectedBooking = aCustomer.bookings.get(bookingsBox.getSelectedIndex());
				for(Movie aMovie: movies) {
					if(aMovie.getId().equals(selectedBooking.getMovieId()))
					{
						for(Show aShow: aMovie.shows) {
							if(aShow.getId().equals(selectedBooking.getShowId()))
							{
								//add seats back to show and remove booking for customer.
								aShow.cancelSeats(selectedBooking.numOfSeats);
								aCustomer.bookings.remove(selectedBooking);
								break;
							}
						}
					}
				}
				
				// to save booking arraylist for customer
				for(Customer newCust : customers)
				{
					if(aCustomer.getUsername().equals(newCust.getUsername())) {
						int custIndex = customers.indexOf(newCust);
						customers.set(custIndex, aCustomer);
					}
				}
				
				saveFile.saveCustomer("customer", customers);
				saveFile.saveMovie("movie", movies);
				
				cancelFrame.dispose();
			}
			
		});
		cancelFrame.setLayout(new GridLayout(1,2));
		cancelFrame.add(bookingsBox);
		cancelFrame.add(cancelSubmit);
		cancelFrame.pack();
		cancelFrame.setVisible(true);
	}
	
}
	


	

	
