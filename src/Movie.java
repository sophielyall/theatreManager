import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable{
	private static final long serialVersionUID = 1L;
String id, title, director;
int runtime;
double price;
ArrayList<Show> shows;

public Movie(String aId, String aTitle, String aDirector, int aRuntime,  double aPrice)
{
	id = aId;
	title = aTitle;
	director = aDirector;
	runtime = aRuntime;
	
	price = aPrice;
	
	shows = new ArrayList<Show>();
	
}

public String getId() {
	return id;
}

public String getTitle() {
	// TODO Auto-generated method stub
	return title;
}

public String toString() {
	return  id + " " + title;
}
}
