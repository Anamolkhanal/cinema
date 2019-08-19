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
		Scanner sc=new Scanner(System.in);
	
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
		
	public String bookmovies(ArrayList<String> m)
	{    
		moviesarr=m;
		System.out.println(moviesarr);
		System.out.println("enter the number to choice movies:");
		int ch=sc.nextInt()-1;
		this.Moviename= moviesarr.get(ch);
		return Moviename;
	}
	public Movies addmovies(){
		Movies m=null;
		//sc.nextLine();
		System.out.println("Enter the name of the movies:");
		Moviename=sc.nextLine();
		moviesarr.add(Moviename);
		System.out.println("Enter the Releasedate of "+Moviename);
		Releasedate=sc.nextLine();
		System.out.println("price of per seat for movie "+Moviename);
		PriceperSeat=sc.nextInt();
		m=new Movies(Moviename,Releasedate,PriceperSeat);
		return m;
	}
	public void deletemovies() {
		System.out.println("enter the movies name that u want to removed from the list:");
		String name=sc.nextLine();
		moviesarr.remove(name);
	}
		@Override
	public String toString() {
		return "Movies [ Mname=" + Moviename  +", moviesarr=" + moviesarr + "]";
	}


	
}
