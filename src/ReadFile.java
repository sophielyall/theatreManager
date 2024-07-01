import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadFile {

	FileInputStream fis;
	ObjectInputStream ois;
	
	public ArrayList<Customer> readCustomer(String filename){
	
		try {
		fis = new FileInputStream(filename);
		ois = new ObjectInputStream(fis);
		ArrayList<Customer> customers= (ArrayList<Customer>) ois.readObject();
		return customers;
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
		
}

	public ArrayList<Movie> readMovie(String filename) {
		try {
		fis = new FileInputStream(filename);
		ois = new ObjectInputStream(fis);
		ArrayList<Movie> movies= (ArrayList<Movie>) ois.readObject();
		return movies;
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	}

	public ArrayList<Admin> readAdmin(String filename) {
		try {
		fis = new FileInputStream(filename);
		ois = new ObjectInputStream(fis);
		ArrayList<Admin> admins= (ArrayList<Admin>) ois.readObject();
		return admins;
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	}
}
