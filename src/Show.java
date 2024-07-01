import java.io.Serializable;

public class Show implements Serializable{
	private static final long serialVersionUID = 1L;
int  availableSeats ;
String showDate, startTime, id;
 public Show(String aId, int seats, String date, String time)
 {
	 id = aId;
	 availableSeats = seats;
	 showDate = date;
 }

 //returns the number of seats currently available
 public int getSeats()
 {
	 return availableSeats;
 }
 
 //returns date of show
 public String getDate()
 {
	 return showDate;
 }
 
 public String getTime()
 {
	 return startTime;
 }
 
 public String getId() {
	 return id;
 }
 public void bookSeats(int numSeats) {
	 availableSeats -= numSeats;
 }
 
 public void cancelSeats(int numSeats) {
	 availableSeats += numSeats;
 }
 public String toString() {
		return id + " " + getDate() + " " + getTime() + " " + getSeats();
	}
}
