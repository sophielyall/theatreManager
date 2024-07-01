import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SaveFile {
public void saveCustomer(String filename, ArrayList<Customer> customers) {
	FileOutputStream fos;
	try {
		fos = new FileOutputStream(filename);

    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(customers);
    oos.close();	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void saveMovie(String filename, ArrayList<Movie> movies) {
	FileOutputStream fos;
	try {
		fos = new FileOutputStream(filename);

    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(movies);
    oos.close();	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void saveAdmin(String filename, ArrayList<Admin> admins) {
	// TODO Auto-generated method stub
	FileOutputStream fos;
	try {
		fos = new FileOutputStream(filename);

    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(admins);
    oos.close();	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
