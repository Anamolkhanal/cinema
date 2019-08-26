package Model;
import java.awt.Graphics;
import java.sql.SQLException;
import java.util.*;
import Database.Database;
import java.util.Scanner;
public class Seat{
	private double price=300;
	private int [][] seatarr=new int [5][5];
	private ArrayList seatNo;
	private String Showtime;
	Scanner sc=new Scanner (System.in);
	public Seat() {
		price=0.0;
		seatarr=new int[5][5];
		seatNo=null;
		Showtime="";
	}
	public Seat(int[][] seatarr,String Showtime) {
		price=0.0;
		this.seatarr=seatarr;
		seatNo=null;
		this.Showtime=Showtime;
	}
	public ArrayList seatmain() {
		seatlayout();
		seatNo=new ArrayList <String>();
		inputSeat(); 
		return seatNo;
	}
		public void inputSeat() {
		//ArrayList <String> seatNo=new ArrayList <String>();
			Database db=null;
		System.out.println("number of seat you want:");
		int number=sc.nextInt();
		sc.nextLine();
		//do {
			System.out.println("enter block and then number of the seat");
			for(int i=0;i<number;i++)
			{
				char block=sc.next().charAt(0);
				int seatn=sc.nextInt();
				sc.nextLine();
				int check=Isbooked(block,seatn-1);
				if(check==0) 
				{
					String x=block+""+seatn;
					seatNo.add(x);
					
					try {
						db = new Database();
						db.addseatinfo(x,Showtime);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}	
				else
				{
					System.out.println("Sorry the seat is booked already try another one!!");
					i--;
				}
			}
			System.out.println(seatNo+" total price ="+(number*price));
		}
	public void seatlayout() {
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(seatarr[i][j]==1)
					System.out.print("no ");
				else if(i==0)
					System.out.print("A"+(j+1)+" ");
				else if(i==1)
				System.out.print("B"+(j+1)+" "); 
				else if(i==2)
					System.out.print("C"+(j+1)+" ");
				else if(i==3)
					System.out.print("D"+(j+1)+" ");
				else if(i==4)
					System.out.print("E"+(j+1)+" ");
			}
			System.out.println();
		}
	}
	public int Isbooked(char block,int seatn) {
		int i;
		if((block>='A')&&(block<='E'))
		{
			if(block=='A')
				i=0;
			else if(block=='B')
				i=1;
			else if(block=='C')
				i=2;
			else if(block=='D')
				i=3;
			else
				i=4;
		}
		else
		{
			i=6;
			System.out.println("Invalid block!! try again with BLock [A-E]");
			
		}
		if(i>=0&&i<=4) 
		{
			if(seatarr[i][seatn]==0)
			{
				seatarr[i][seatn]=1;
				
				return 0;
			}
			return 1;
		}
		else
		{
			System.out.println("Invalid seat No for block "+block+" [1-5]");
			return 2;
		}
		
		
	}
	@Override
	public String toString() {
		return "Seat [price=" + price + ", seatNo=" + seatNo +"Showtime="+Showtime+ "]";
	}
		
}
