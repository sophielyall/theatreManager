import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class TheatreGUI {
	static ArrayList<Admin> admins;
	static ArrayList<Customer> customers;
	static ArrayList<Movie> movies;
	static SaveFile saveFile;
	
	static JFrame frame;
	
	static JButton admin,customer;
public static void main(String[] args)
{
	 ReadFile readFile = new ReadFile();
	  saveFile = new SaveFile();
	//Read list of admins from file
		 admins = readFile.readAdmin("admin");
		 
		//Read list of customers from file
		 customers = readFile.readCustomer("customer");
		 
		//Read list of movie from file
		 movies = readFile.readMovie("movie");
		 
	login();
}

private static void login() {
	// TODO Auto-generated method stub
	frame = new JFrame("Login");
	frame.setLayout(new GridLayout());
	admin = new JButton("Admin");
	customer = new JButton("Customer");
	
	admin.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Login an admin
			loginAdmin();
	}
	});
	
	customer.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Login an customer
			loginCustomer();
	}
	});
	frame.add(admin);
	frame.add(customer);
	frame.pack();
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setVisible(true);
}





protected static void loginCustomer() {
	//creates admin login frame
		JFrame customerFrame = new JFrame("customer Login");
		customerFrame.setLayout(new GridLayout(3,2));
		JLabel idLab = new JLabel("User ID:");
		JTextField idText = new JTextField();
		JLabel passLab = new JLabel("User Password:");
		JTextField passText = new JTextField();
		JButton submit = new JButton("Submit");
		
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username = idText.getText();
				String password = passText.getText();
				for(Customer aCust: customers)
				{
					//checks if username and password is valid
					if(aCust.getUsername().equals(username) && aCust.getPassword().equals(password))
					{
						System.out.println("CUSTOMER FOUND");
						customerFrame.dispose();
						CustomerMenuGui customerMenu = new CustomerMenuGui(aCust);
						customerMenu.runMenu();
						break;
						
				
					}
					else
						System.out.println("INCORRECT PASSWORD OR USERNAME");
				}
			
			}
			
		});
		customerFrame.add(idLab);
		customerFrame.add(idText);
		customerFrame.add(passLab);
		customerFrame.add(passText);
		customerFrame.add(submit);
		customerFrame.pack();
		customerFrame.setVisible(true);

}

//login admin
public static void loginAdmin() {
	
	//creates admin login frame
	JFrame adminFrame = new JFrame("Admin Login");
	adminFrame.setLayout(new GridLayout(3,2));
	JLabel idLab = new JLabel("User ID:");
	JTextField idText = new JTextField();
	JLabel passLab = new JLabel("User Password:");
	JTextField passText = new JTextField();
	JButton submit = new JButton("Submit");
	
	submit.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String username = idText.getText();
			String password = passText.getText();
			System.out.println(admins.size());
			for(Admin aAdmin : admins)
			{
				//checks if username and password is valid
				if(aAdmin.getUsername().equals(username) && aAdmin.getPassword().equals(password))
				{
					
					System.out.println("ADMIN FOUND ");
					adminFrame.dispose();
					AdminMenuGui adminMenu = new AdminMenuGui(aAdmin);
					adminMenu.runMenu();
					break;
					
			
				}
				else
					System.out.println("INCORRECT PASSWORD OR USERNAME");
			}
		
		}
		
	});
	adminFrame.add(idLab);
	adminFrame.add(idText);
	adminFrame.add(passLab);
	adminFrame.add(passText);
	adminFrame.add(submit);
	adminFrame.pack();
	adminFrame.setVisible(true);

	

}



}
