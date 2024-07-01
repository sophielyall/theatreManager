import java.io.Serializable;

public class Booking implements Serializable{
	private static final long serialVersionUID = 1L;
	
	int numOfSeats;

	String showId, bookId, movieId;
public Booking(String aId, String aShowId, String aMovieId, int aNumOfSeats)
{
	bookId = aId;
	showId = aShowId;
	movieId = aMovieId;
	numOfSeats = aNumOfSeats;
}

public String getBookingId() {
	return bookId;
}

public String getShowId()
{
	return showId;
}

public String getMovieId()
{
	return movieId;
}
public int getNumberOfSeats()
{
	return numOfSeats;
}




public String toString() {
	return bookId + " " + movieId + " " + showId + " " + numOfSeats;
}
}