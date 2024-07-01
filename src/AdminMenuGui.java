import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AdminMenuGui {
	static Admin aAdmin;
	static ArrayList<Customer> customers;
	static ArrayList<Movie> movies;
	static SaveFile saveFile;

	public AdminMenuGui(Admin admin)
	{
		aAdmin = admin;
		
	}
	
	public void runMenu() {
		ReadFile readFile = new ReadFile();
		 saveFile = new SaveFile();
		customers = readFile.readCustomer("customer");
		movies = readFile.readMovie("movie");
		
		
		JFrame adminMenu =  new JFrame("Admin Menu");
		adminMenu.setLayout(new GridLayout(5,2));
		JLabel welcome = new JLabel("Welcome: ");
		JLabel adminName = new JLabel(aAdmin.getFullname());
		JButton addCustomer = new JButton("Add Customer");
		JButton addMovie = new JButton("Add Movie");
		JButton addShow = new JButton("Add Show");
		JButton logout = new JButton("Logout");
		
		addCustomer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addCustomer();
			}
			
		});
		
		addMovie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addMovie();
			}
			
		});
		addShow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addShow();
			}

		
			
		});
	
		logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			adminMenu.dispose();
			//frame.setVisible(true);
			}
			
		});
		adminMenu.add(welcome);
		adminMenu.add(adminName);
		adminMenu.add(addCustomer);
		adminMenu.add(addMovie);
		adminMenu.add(addShow);
		adminMenu.add(logout);
		adminMenu.pack();
		adminMenu.setVisible(true);
		
	}

public static void addCustomer()
{
	JFrame addCustomer = new JFrame("Add Customer");
	addCustomer.setLayout(new GridLayout(5,2));
	JLabel usernameLab = new JLabel("Username: ");
	JTextField usernameText = new JTextField();
	JLabel firstnameLab = new JLabel("Firstname: ");
	JTextField firstnameText = new JTextField();
	JLabel surnameLab = new JLabel("Surname: ");
	JTextField surnameText = new JTextField();
	JLabel passwordLab = new JLabel("Password: ");
	JTextField passwordText = new JTextField();
	JButton submitCustomer = new JButton("Submit");
	
	submitCustomer.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(usernameText.getText().isEmpty() && firstnameText.getText().isEmpty() && surnameText.getText().isEmpty() &&passwordText.getText().isEmpty()) {
				System.out.println("Enter User Details");
			}
			else if(checkUsername(usernameText.getText()))
			{
				System.out.println("Username already exists");
			}
			else
			{
				Customer newCustomer = new Customer(usernameText.getText(),firstnameText.getText(), surnameText.getText(), passwordText.getText());
				customers.add(newCustomer);
				System.out.println("Customer added");
				addCustomer.dispose();
				saveFile.saveCustomer("customer", customers);
			}
		}
		
	});
	
	addCustomer.add(usernameLab);
	addCustomer.add(usernameText);
	addCustomer.add(firstnameLab);
	addCustomer.add(firstnameText);
	addCustomer.add(surnameLab);
	addCustomer.add(surnameText);
	addCustomer.add(passwordLab);
	addCustomer.add(passwordText);
	addCustomer.add(submitCustomer);
	addCustomer.pack();
	addCustomer.setVisible(true);
}

public static boolean checkUsername(String username)
{
	
	for(Customer aCustomer: customers)
	{
		if(aCustomer.getUsername().equals(username))
		{
			return true;
		}
		
	}
	
	return false;
}

public static void addMovie() {
	JFrame addMovie = new JFrame("Add Movie");
	addMovie.setLayout(new GridLayout(2,6));
	int nextID = movies.size() +1;
	String id = "m" + nextID;
	//String id = "m1";
	JLabel idLab = new JLabel("ID: ");
	JLabel newIDLab = new JLabel(id);
	JLabel titleLab = new JLabel("Title");
	JTextField titleText = new JTextField();
	JLabel directorLab = new JLabel("Director");
	JTextField directorText = new JTextField();
	JLabel runtimeLab = new JLabel("Runtime(minutes): ");
	JTextField runtimeText = new JTextField();
	JLabel priceLab = new JLabel("Price (0.0): ");
	JTextField priceText = new JTextField();
	JButton submitMovie = new JButton("Submit");
	
submitMovie.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(titleText.getText().isEmpty() && directorText.getText().isEmpty() && runtimeText.getText().isEmpty() &&priceText.getText().isEmpty()) {
			System.out.println("Enter Movie Details");
		}
		else
		{
			Movie newMovie = new Movie(id, titleText.getText(), directorText.getText(), Integer.parseInt(runtimeText.getText()), Double.parseDouble(priceText.getText()));
			movies.add(newMovie);
			System.out.println("Movie added");
			addMovie.dispose();
			//SaveFile saveFile = new SaveFile();
			saveFile.saveMovie("movie", movies);
		
		}
	}});

addMovie.add(idLab);
addMovie.add(newIDLab);
addMovie.add(titleLab);
addMovie.add(titleText);
addMovie.add(directorLab);
addMovie.add(directorText);
addMovie.add(runtimeLab);
addMovie.add(runtimeText);
addMovie.add(priceLab);
addMovie.add(priceText);
addMovie.add(submitMovie);
addMovie.pack();
addMovie.setVisible(true);
}


public static void addShow() {
	// TODO Auto-generated method stub
	JFrame addShow = new JFrame("Add Show");
	addShow.setLayout(new GridLayout(2,2));
	Object[] strings = movies.toArray();//moviesBox.add(aMovie.getTitle());
	JComboBox moviesBox = new JComboBox(strings);
	JButton submit = new JButton("Select");
	submit.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Movie selectedMovie =  movies.get(moviesBox.getSelectedIndex());
			System.out.println(moviesBox.getSelectedItem());
			System.out.println(selectedMovie.getTitle());
			JFrame showDetails = new JFrame("Show Details");
			showDetails.setLayout(new GridLayout(4,2));
			int nextID = selectedMovie.shows.size() +1;
			String id = "s" + nextID;
			JLabel idLab = new JLabel("ID ");
			JLabel newIdLab = new JLabel(id);
			JLabel seatLab = new JLabel("Number of Seats: ");
			JTextField seatText = new JTextField();
			JLabel dateLab = new JLabel("Date: dd/mm/yyyy");
			JTextField dateText = new JTextField();
			JLabel timeLab = new JLabel("Time: 00:00pm");
			JTextField timeText = new JTextField();
			JButton submit = new JButton("Submit");
			
			submit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(seatText.getText().isEmpty() && dateText.getText().isEmpty() && timeText.getText().isEmpty()) {
						System.out.println("Enter Show Details");
					}
					else
					{
						Show newShow = new Show(id, Integer.parseInt(seatText.getText()), dateText.getText(), timeText.getText());
						selectedMovie.shows.add(newShow);
						saveFile.saveMovie("movie", movies);
						showDetails.dispose();
						addShow.dispose();
					}
					}
				
				
			});
			showDetails.add(idLab);
			showDetails.add(newIdLab);
			showDetails.add(seatLab);
			showDetails.add(seatText);
			showDetails.add(dateLab);
			showDetails.add(dateText);
			showDetails.add(timeLab);
			showDetails.add(timeText);
			showDetails.add(submit);
			showDetails.pack();
			showDetails.setVisible(true);
			
			
		}
		
	});
	addShow.add(submit);
	addShow.add(moviesBox);
	addShow.pack();
	addShow.setVisible(true);
}

}
