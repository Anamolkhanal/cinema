package Main;
import Model.Audience;
import Model.Movies;
import Model.Seat;
import Database.Database;

import java.sql.SQLException;
import java.util.*;

public class main {
static Scanner sc;
	public static void main(String [] args) throws SQLException
	{	sc= new Scanner(System.in);
	    Database db = null;
		Movies movie=new Movies();
		Seat s1=null;
		Seat s2=null;
		Seat s3=null;
		Seat s4=null;
		ArrayList<String> seatNo=null;
		 int [][]isbook=null;
		int ch;
		
	do {
		System.out.println("1.Book Movies Ticket");
		System.out.println("2.Add Movies ");
		System.out.println("3.Remove Movies");
		System.out.println("4.Exit");
		System.out.println("Enter the ch ");
		ch=sc.nextInt();
		
		try {
			db = new Database();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch(ch)
		
		{
		
			case 1:
			{
				ArrayList<String> m=new ArrayList<String>();
				isbook=new int[5][5];
				m=db.getMovie();
				String Moviename=choiceMovies(m);
				int n=chooseShowtime();
				if(n==1) {
					String Showtime="8:00 AM";
					isbook=db.getseatinfo(n);
					s1=new Seat(isbook,Showtime);
					seatNo=new ArrayList<String>();
					seatNo=s1.seatmain();
					System.out.println("enter the name of audience:");
					sc.nextLine();
					String Aname=sc.nextLine();
					Audience a=new Audience(Aname,Moviename,Showtime,seatNo);
					db.addaudience(a);					
				
				}
				else if(n==2)
				{
					String Showtime="12:00 AM";
					isbook=db.getseatinfo(n);
					s1=new Seat(isbook,Showtime);
					seatNo=new ArrayList<String>();
					seatNo=s2.seatmain();
					System.out.println("enter the name of audience:");
					sc.nextLine();
					String Aname=sc.nextLine();
					Audience a=new Audience(Aname,Moviename,Showtime,seatNo);
					db.addaudience(a);
				}
				else if(n==3)
				{
					String Showtime="4:00 AM";
					isbook=db.getseatinfo(n);
					s1=new Seat(isbook,Showtime);
					seatNo=new ArrayList<String>();
					seatNo=s3.seatmain();
					System.out.println("enter the name of audience:");
					sc.nextLine();
					String Aname=sc.nextLine();
					Audience a=new Audience(Aname,Moviename,Showtime,seatNo);
					db.addaudience(a);
				}
				else if(n==4)
				{
					String Showtime="8:00 PM";
					isbook=db.getseatinfo(n);
					s1=new Seat(isbook,Showtime);
					seatNo=new ArrayList<String>();
					seatNo=s4.seatmain();
					System.out.println("enter the name of audience:");
					sc.nextLine();
					String Aname=sc.nextLine();
					Audience a=new Audience(Aname,Moviename,Showtime,seatNo);
					db.addaudience(a);
				}
				break;
			}
			case 2:
			{	
				Movies m=null;
				//sc.nextLine();
				System.out.println("Enter the name of the movies:");
				String Moviename=sc.nextLine();
				System.out.println("Enter the number of show for "+Moviename);
				String Releasedate=sc.nextLine();
				System.out.println("price of per seat for movie "+Moviename);
				int PriceperSeat=sc.nextInt();
				m=new Movies(Moviename,Releasedate,PriceperSeat);
				try {
					db = new Database();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				db.addmovies(m);
				break;
			}
			case 3:
			{
				ArrayList<String> m=new ArrayList<String>();
				try {
					db = new Database();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				db.getMovie();
				m=db.getMovie();
				String Moviename=choiceMovies(m);
				db.deleteMovies(Moviename);
			}
			case 4:{
				System.exit(0);
				break;
			}
			default:
			{
				System.out.println("please enter valid number [1-3]");
				break;
			}
		}
	
      }while(ch!=4);
	}
public static void clearBuffer() {
	if(sc.hasNextLine()) 
		sc.nextLine();
	}
public static int chooseShowtime() {
	int ShowNo,i=0;
	do {
	System.out.println("8:00 AM \n12:00 PM\n4:00 PM\n8:00 PM");
	System.out.println("Choice the show time : ");
	ShowNo=sc.nextInt();
	if(ShowNo>=1&&ShowNo<=4)
	{
		if(ShowNo==1)
			i=1;
		else if(ShowNo==2)
			i= 2;
		else if(ShowNo==3)
			i=3;  
		else if(ShowNo==4)
			i=4;
		break;
	}
	else
		System.out.println("Invalid  ShowNo Try [1-4] !!!");
		
	}while(ShowNo>0||ShowNo<5);
	return i;
	}
public static String choiceMovies(ArrayList<String> m)
{    
	System.out.println(m);
	System.out.println("enter the number to choice movies:");
	int ch=sc.nextInt()-1;
	String Moviename= m.get(ch);
	return Moviename;
}
}
