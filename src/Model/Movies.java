package Model;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Movies {
	private String Moviename;
	private String Releasedate;
	private int PriceperSeat;
	private int Id;
	private ArrayList<String> moviesarr=new ArrayList<String>();
	public Movies() {
			Moviename = "";
			Releasedate = "";
			PriceperSeat = 0;
			Id = 0;
		}
	public Movies(String moviename, String releasedate, int priceperSeat) {
			super();
			Moviename = moviename;
			Releasedate = releasedate;
			PriceperSeat = priceperSeat;
			Id++;
		}
		public String getMoviename() {
			return Moviename;
		}
		public void setMoviename(String moviename) {
			Moviename = moviename;
		}
		public String getReleasedate() {
			return Releasedate;
		}
		public void setReleasedate(String releasedate) {
			Releasedate = releasedate;
		}
		public int getPriceperSeat() {
			return PriceperSeat;
		}
		public void setPriceperSeat(int priceperSeat) {
			PriceperSeat = priceperSeat;
		}
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
public String toString() {
		return "Movies [ Mname=" + Moviename  +", moviesarr=" + moviesarr + "]";
	}
}
